package utils

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"os"
	"strings"
)

type UploadResponse struct {
	FileUpload bool
	GistURL    string
}

func PostRequest(url string, method string, payload *strings.Reader, headers map[string]string) UploadResponse {
	client := &http.Client{}
	req, err := http.NewRequest(method, url, payload)
	if err != nil {
		return UploadResponse{}
	}
	for header_key, header_value := range headers {
		req.Header.Add(header_key, header_value)
	}

	response, err := client.Do(req)
	if err != nil {
		return UploadResponse{}
	}
	defer response.Body.Close()

	// if response.StatusCode != http.StatusOK {
	// 	return UploadResponse{}
	// }

	body, err := ioutil.ReadAll(response.Body)
	if err != nil {
		return UploadResponse{}
	}
	jsonResponse := make(map[string]string)
	json.Unmarshal(body, &jsonResponse)
	gistUrl := jsonResponse["html_url"]
	return UploadResponse{true, gistUrl}
}

func UploadJsonToGist(fileName string, newFilename string, jsonString string, author string, appUrl string) UploadResponse {
	gistBearerToken := os.Getenv("GIST_API_TOKEN")
	gistUrl := "https://api.github.com/gists"
	method := "POST"
	headers := map[string]string{
		"Authorization": fmt.Sprintf("Bearer %s", gistBearerToken),
		"Content-Type":  "application/json",
	}
	jsonData := fmt.Sprintf(`%s`, jsonString)
	jsonBytes, _ := json.Marshal(jsonData)
	responseBody := fmt.Sprintf(`{
		"public": true,
		"files": {
			"%s": {
				"content": %s
			}
		},
		"description":  "Generated from %s by %s. Gist created by user: %s."
	}`, newFilename, string(jsonBytes), fileName, appUrl, author)
	jsonPayload := string(responseBody)
	payload := strings.NewReader(jsonPayload)
	result := PostRequest(gistUrl, method, payload, headers)
	return result
}
