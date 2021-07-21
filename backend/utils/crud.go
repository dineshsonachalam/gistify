package utils

import (
	"encoding/json"
	"io/ioutil"
	"net/http"
	"strings"
)

// HttpRequest represents the response of HTTP request
type HttpRequest struct {
	Status       bool
	ResponseBody map[string]interface{}
}

// Request return HTTP GET/POST/DELETE JSON response
func Request(requestType string, url string, payload *strings.Reader, headers map[string]string) HttpRequest {
	client := &http.Client{}
	req, err := http.NewRequest(requestType, url, payload)
	if err != nil {
		return HttpRequest{}
	}
	for headerKey, headerValue := range headers {
		req.Header.Add(headerKey, headerValue)
	}
	response, err := client.Do(req)
	if err != nil {
		return HttpRequest{}
	}
	defer response.Body.Close()
	if response.StatusCode >= 200 && response.StatusCode <= 299 {
		responseBody, err := ioutil.ReadAll(response.Body)
		if err != nil {
			return HttpRequest{}
		}
		jsonResponse := make(map[string]interface{})
		json.Unmarshal(responseBody, &jsonResponse)
		return HttpRequest{true, jsonResponse}
	}
	return HttpRequest{}
}
