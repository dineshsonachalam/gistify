package auth

import (
	"fmt"
	"gistify/utils"
	"strconv"
	"strings"
)

// GithubUserInfo represent authenticated Github user information
type GithubUserInfo struct {
	Id       string `json:"id"`
	Username string `json:"username"`
	Email    string ` json:"email"`
}

// GithubUserDetails return authenticated Github user information
func GithubUserDetails(clientId string, clientSecret string, requestToken string) GithubUserInfo {
	accessTokenURL := fmt.Sprintf("https://github.com/login/oauth/access_token?client_id=%s&client_secret=%s&code=%s", clientId, clientSecret, requestToken)
	payload := strings.NewReader(`{}`)
	headers := map[string]string{
		"accept": "application/json",
	}
	AccessTokenResponse := utils.Request("POST", accessTokenURL, payload, headers)
	if AccessTokenResponse.Status {
		accessToken := AccessTokenResponse.ResponseBody["access_token"]
		githubUserDetailsUrl := "https://api.github.com/user"
		payload := strings.NewReader(`{}`)
		headers := map[string]string{
			"Authorization": fmt.Sprintf("Bearer %s", accessToken),
		}
		GithubUserDetailsResponse := utils.Request("GET", githubUserDetailsUrl, payload, headers)
		if GithubUserDetailsResponse.Status {
			githubUserId := int(GithubUserDetailsResponse.ResponseBody["id"].(float64))
			githubUsername := GithubUserDetailsResponse.ResponseBody["login"].(string)
			githubUserEmail := GithubUserDetailsResponse.ResponseBody["email"].(string)
			id := strconv.Itoa(githubUserId)
			username := githubUsername
			email := githubUserEmail
			return GithubUserInfo{id, username, email}
		}
	}
	return GithubUserInfo{}
}
