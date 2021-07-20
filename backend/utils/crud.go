package utils

import (
	"encoding/json"
	"io/ioutil"
	"net/http"
	"strings"
)

type HttpRequest struct {
	Status       bool
	ResponseBody map[string]interface{}
}

func GetRequest(url string, payload *strings.Reader, headers map[string]string) HttpRequest {
	client := &http.Client{}
	req, err := http.NewRequest("GET", url, payload)
	if err != nil {
		return HttpRequest{}
	} else {
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
		} else {
			return HttpRequest{}
		}
	}
}

func PostRequest(url string, payload *strings.Reader, headers map[string]string) HttpRequest {
	client := &http.Client{}
	req, err := http.NewRequest("POST", url, payload)
	if err != nil {
		return HttpRequest{}
	} else {
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
		} else {
			return HttpRequest{}
		}
	}
}

func DeleteRequest(url string, payload *strings.Reader, headers map[string]string) HttpRequest {
	client := &http.Client{}
	req, err := http.NewRequest("DELETE", url, payload)
	if err != nil {
		return HttpRequest{}
	} else {
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
		} else {
			return HttpRequest{}
		}
	}
}
