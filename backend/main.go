package main

import (
	"fmt"
	"gistify/auth"
	"gistify/middleware"
	"gistify/models"
	"gistify/utils"
	"io/ioutil"
	"os"
	"path/filepath"
	"strings"

	"github.com/gin-gonic/gin"
)

// GetEnv return environmental variables
func GetEnv() (string, string, []byte, string, string, string, string) {
	env := utils.GetEnv()
	githubClientID := os.Getenv(fmt.Sprintf("GISTIFY_%s_GITHUB_CLIENT_ID", env))
	githubClientSecret := os.Getenv(fmt.Sprintf("GISTIFY_%s_GITHUB_CLIENT_SECRET", env))
	jwtSecretKey := []byte(os.Getenv(fmt.Sprintf("GISTIFY_%s_JWT_SECRET_KEY", env)))
	gistApiToken := os.Getenv(fmt.Sprintf("GISTIFY_%s_GIST_API_TOKEN", env))
	gistifyAppURL := os.Getenv(fmt.Sprintf("GISTIFY_%s_APP_URL", env))
	databaseURL := "postgres://dinesh:simple@postgres:5432/dinesh-micro-apps"
	var cookieDomain string
	if env == "DEV" {
		cookieDomain = ".localhost"
	} else {
		cookieDomain = ".dineshsonachalam.com"
	}
	return githubClientID, githubClientSecret, jwtSecretKey, gistApiToken, gistifyAppURL, databaseURL, cookieDomain
}

// GithubOauthRedirect set JWT cookie & redirect to Github Oauth redirect URL
func GithubOauthRedirect(c *gin.Context, githubClientID string, githubClientSecret string,
	jwtSecretKey []byte, databaseURL string, cookieDomain string, gistifyAppURL string) {
	requestToken := c.Request.FormValue("code")
	userDetails := auth.GithubUserDetails(githubClientID, githubClientSecret, requestToken)
	userInfo := make(map[string]string)
	userInfo["id"] = userDetails.Id
	userInfo["username"] = userDetails.Username
	jwtAccessToken := auth.CreateJwtAccessToken(userInfo, jwtSecretKey)
	models.CreateUserTable(databaseURL)
	models.CreateGistTable(databaseURL)
	isUserAlreadyPresent, _ := models.GetUser(databaseURL, userInfo["id"])
	if !isUserAlreadyPresent {
		models.CreateUser(databaseURL, userInfo["id"], userInfo["username"], userDetails.Email)
	}
	// Expiry time in minutes - Setting expiry time as 40 minute
	c.SetCookie("token", jwtAccessToken, (40 * 60), "/", cookieDomain, false, false)
	c.Redirect(301, gistifyAppURL+userInfo["username"])
}

// CreateNewGist return status of GIST creation
func CreateNewGist(c *gin.Context, jwtSecretKey []byte, gistApiToken string,
	gistifyAppURL string, databaseURL string) {
	const BEARER_SCHEMA = "Bearer"
	authHeader := c.GetHeader("Authorization")
	tokenString := authHeader[len(BEARER_SCHEMA)+1:]
	isValidJwtToken := auth.ValidateJwtAccessToken(tokenString, jwtSecretKey)
	if isValidJwtToken {
		tokenExpiry, githubUserId, username := auth.IsJwtAccessTokenExpiryInFiveMin(tokenString)
		userInfo := make(map[string]string)
		userInfo["id"] = githubUserId
		userInfo["username"] = username
		if tokenExpiry {
			tokenString = auth.CreateJwtAccessToken(userInfo, jwtSecretKey)
		}
		formFile, err := c.FormFile("uploadfile")
		if err != nil {
			c.JSON(200, gin.H{
				"isFileUploaded": false,
				"gistURL":        "",
				"gistID":         "",
				"jwtAccessToken": "",
				"message":        "Invalid file format",
			})
		} else {
			// Get raw file bytes - no reader method
			openedFile, _ := formFile.Open()
			file, _ := ioutil.ReadAll(openedFile)
			filename := filepath.Base(formFile.Filename)
			fileExtension := filepath.Ext(filename)

			newFilename := (strings.Split(filename, "."))[0] + ".json"
			ParserResponse := utils.ParserResponse{}

			if fileExtension == ".yaml" || fileExtension == ".yml" {
				ParserResponse = utils.YAMLToJSON(file)
			} else if fileExtension == ".toml" {
				ParserResponse = utils.TOMLToJSON(file)
			} else if fileExtension == ".csv" {
				ParserResponse = utils.CSVToJSON(file)
			} else if fileExtension == ".xlsx" {
				ParserResponse = utils.ExcelToJSON(file)
			}

			fileExtension = strings.Replace(fileExtension, ".", "", -1)
			FileParsed := ParserResponse.FileParsed
			JsonString := ParserResponse.JsonString
			if FileParsed {
				UploadResponse := utils.UploadJsonToGist(gistApiToken, filename, newFilename, JsonString, userInfo["username"], gistifyAppURL)
				models.CreateGist(databaseURL, UploadResponse.GistId, newFilename, fileExtension, UploadResponse.GistURL, githubUserId)
				c.JSON(200, gin.H{
					"isFileUploaded": UploadResponse.FileUpload,
					"gistURL":        UploadResponse.GistURL,
					"gistID":         UploadResponse.GistId,
					"jwtAccessToken": tokenString,
					"message":        "Conversion and upload was successful",
				})
			} else {
				c.JSON(200, gin.H{
					"isFileUploaded": false,
					"gistURL":        "",
					"gistID":         "",
					"jwtAccessToken": tokenString,
					"message":        "Conversion to JSON failed",
				})
			}
		}
	} else {
		c.JSON(200, gin.H{
			"isFileUploaded": false,
			"gistURL":        "",
			"gistID":         "",
			"jwtAccessToken": "",
			"message":        "Invalid JWT access token",
		})
	}
}

// DeleteGist return status of GIST deletion
func DeleteGist(c *gin.Context, jwtSecretKey []byte, gistApiToken string, databaseURL string) {
	const BEARER_SCHEMA = "Bearer"
	authHeader := c.GetHeader("Authorization")
	tokenString := authHeader[len(BEARER_SCHEMA)+1:]
	isValidJwtToken := auth.ValidateJwtAccessToken(tokenString, jwtSecretKey)
	if isValidJwtToken {
		tokenExpiry, githubUserId, username := auth.IsJwtAccessTokenExpiryInFiveMin(tokenString)
		userInfo := make(map[string]string)
		userInfo["id"] = githubUserId
		userInfo["username"] = username
		if tokenExpiry {
			tokenString = auth.CreateJwtAccessToken(userInfo, jwtSecretKey)
		}
		gistID := c.Param("gistID")
		gistURL := fmt.Sprintf("https://api.github.com/gists/%v", gistID)
		payload := strings.NewReader(`{}`)
		headers := map[string]string{
			"Authorization": fmt.Sprintf("Bearer %s", gistApiToken),
			"Content-Type":  "application/json",
		}
		GistDeleteResponse := utils.Request("DELETE", gistURL, payload, headers)
		models.DeleteGist(databaseURL, gistID, githubUserId)
		if GistDeleteResponse.Status {
			c.JSON(200, gin.H{
				"isDeleted":      true,
				"jwtAccessToken": tokenString,
			})
		} else {
			c.JSON(200, gin.H{
				"isDeleted":      false,
				"jwtAccessToken": "",
			})
		}
	} else {
		c.JSON(200, gin.H{
			"isDeleted":      false,
			"jwtAccessToken": "",
		})
	}
}

// GetAllGists return all GIST created by an user
func GetAllGists(c *gin.Context, jwtSecretKey []byte, databaseURL string) {
	const BEARER_SCHEMA = "Bearer"
	authHeader := c.GetHeader("Authorization")
	tokenString := authHeader[len(BEARER_SCHEMA)+1:]
	isValidJwtToken := auth.ValidateJwtAccessToken(tokenString, jwtSecretKey)
	if isValidJwtToken {
		tokenExpiry, id, username := auth.IsJwtAccessTokenExpiryInFiveMin(tokenString)
		userInfo := make(map[string]string)
		userInfo["id"] = id
		userInfo["username"] = username
		if tokenExpiry {
			tokenString = auth.CreateJwtAccessToken(userInfo, jwtSecretKey)
		}
		gistData := models.GetAllGist(databaseURL, id)
		c.JSON(200, gin.H{
			"isDeleted":      true,
			"gistData":       gistData,
			"jwtAccessToken": tokenString,
		})
	} else {
		c.JSON(200, gin.H{
			"isDeleted":      false,
			"jwtAccessToken": "",
		})
	}
}

// GetGist return a gist created by an user by gist ID
func GetGist(c *gin.Context, jwtSecretKey []byte, databaseURL string) {
	gistID := c.Param("gistID")
	const BEARER_SCHEMA = "Bearer"
	authHeader := c.GetHeader("Authorization")
	tokenString := authHeader[len(BEARER_SCHEMA)+1:]
	isValidJwtToken := auth.ValidateJwtAccessToken(tokenString, jwtSecretKey)
	if isValidJwtToken {
		tokenExpiry, id, username := auth.IsJwtAccessTokenExpiryInFiveMin(tokenString)
		userInfo := make(map[string]string)
		userInfo["id"] = id
		userInfo["username"] = username
		if tokenExpiry {
			tokenString = auth.CreateJwtAccessToken(userInfo, jwtSecretKey)
		}
		gistData := models.GetGist(databaseURL, gistID)
		c.JSON(200, gin.H{
			"isDeleted":      true,
			"gistData":       gistData,
			"jwtAccessToken": tokenString,
		})
	} else {
		c.JSON(200, gin.H{
			"isDeleted":      false,
			"jwtAccessToken": "",
		})
	}
}

func main() {
	githubClientID, githubClientSecret, jwtSecretKey, gistApiToken, gistifyAppURL, databaseURL, cookieDomain := GetEnv()
	r := gin.Default()
	r.Use(middleware.CORSMiddleware())
	if (len(githubClientID) > 0) && (len(githubClientSecret) > 0) {
		// Github Oauth redirect
		r.GET("/oauth/redirect", func(c *gin.Context) {
			GithubOauthRedirect(c, githubClientID, githubClientSecret,
				jwtSecretKey, databaseURL, cookieDomain,
				gistifyAppURL)
		})

		// Create a new gist
		r.POST("/gists", func(c *gin.Context) {
			CreateNewGist(c, jwtSecretKey, gistApiToken, gistifyAppURL, databaseURL)
		})

		// Delete a gist
		r.DELETE("/gists/:gistID", func(c *gin.Context) {
			DeleteGist(c, jwtSecretKey, gistApiToken, databaseURL)
		})

		// Get all gists created by user
		r.GET("/gists", func(c *gin.Context) {
			GetAllGists(c, jwtSecretKey, databaseURL)
		})

		// Get a gist by GIST id
		r.GET("/gists/:gistID", func(c *gin.Context) {
			GetGist(c, jwtSecretKey, databaseURL)
		})
		r.Run(":8003")
	} else {
		fmt.Println("Please set the env variables in ~/.zshrc (OSX - Mac)")
	}
}
