package utils

import (
	"encoding/json"
	"fmt"
	"strings"
)

// UploadResponse represents the response of the Github Gist upload
type UploadResponse struct {
	FileUpload bool
	GistId     string
	GistURL    string
}

// UploadJsonToGist return status of uploading JSON to gist
func UploadJsonToGist(GIST_API_TOKEN string, fileName string, newFilename string, jsonString string, author string, appUrl string) UploadResponse {
	gistUrl := "https://api.github.com/gists"
	headers := map[string]string{
		"Authorization": fmt.Sprintf("Bearer %s", GIST_API_TOKEN),
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
	uploadResponse := Request("POST", gistUrl, payload, headers)
	if uploadResponse.Status {
		isFileUploaded := true
		gistID := fmt.Sprintf("%v", uploadResponse.ResponseBody["id"])
		gistURL := fmt.Sprintf("%v", uploadResponse.ResponseBody["html_url"])
		return UploadResponse{isFileUploaded, gistID, gistURL}
	}
	return UploadResponse{}
}
