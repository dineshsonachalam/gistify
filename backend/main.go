package main

import (
	"fmt"
	"goanyjson/auth"
	"goanyjson/middleware"
	"goanyjson/models"
	"goanyjson/utils"
	"io/ioutil"
	"os"
	"path/filepath"
	"strings"

	"github.com/gin-gonic/gin"
)

func main() {
	ENV := utils.GetEnv()
	GITHUB_CLIENT_ID := os.Getenv(fmt.Sprintf("GOANYJSON_%s_GITHUB_CLIENT_ID", ENV))
	GITHUB_CLIENT_SECRET := os.Getenv(fmt.Sprintf("GOANYJSON_%s_GITHUB_CLIENT_SECRET", ENV))
	JWT_SECRET_KEY := []byte(os.Getenv(fmt.Sprintf("GOANYJSON_%s_JWT_SECRET_KEY", ENV)))
	GIST_API_TOKEN := os.Getenv(fmt.Sprintf("GOANYJSON_%s_GIST_API_TOKEN", ENV))
	GOANYJSON_APP_URL := os.Getenv(fmt.Sprintf("GOANYJSON_%s_APP_URL", ENV))
	DATABASE_URL := "postgres://dinesh:simple@postgres:5432/anyjson"

	r := gin.Default()
	r.Use(middleware.CORSMiddleware())

	if (len(GITHUB_CLIENT_ID) > 0) && (len(GITHUB_CLIENT_SECRET) > 0) {
		r.GET("/oauth/redirect", func(c *gin.Context) {
			requestToken := c.Request.FormValue("code")
			userDetails := auth.GithubUserDetails(GITHUB_CLIENT_ID, GITHUB_CLIENT_SECRET, requestToken)
			userInfo := make(map[string]string)
			userInfo["id"] = userDetails.Id
			userInfo["username"] = userDetails.Username
			// store in DB
			// userInfo["email"] = userDetails.Email
			jwtAccessToken := auth.CreateJwtAccessToken(userInfo, JWT_SECRET_KEY)

			models.CreateUserTable(DATABASE_URL)
			models.CreateGistTable(DATABASE_URL)

			isUserAlreadyPresent, _ := models.GetUser(DATABASE_URL, userInfo["id"])
			if !isUserAlreadyPresent {
				models.CreateUser(DATABASE_URL, userInfo["id"], userInfo["username"], userDetails.Email)
			}
			// Expiry time in minutes - Setting expiry time as 15 minute
			c.SetCookie("token", jwtAccessToken, (15 * 60), "/", GOANYJSON_APP_URL, false, false)
			c.Redirect(301, "http://localhost:3000/"+userInfo["username"])
		})

		// Create a new gist
		r.POST("/gists", func(c *gin.Context) {
			const BEARER_SCHEMA = "Bearer"
			authHeader := c.GetHeader("Authorization")
			tokenString := authHeader[len(BEARER_SCHEMA)+1:]
			isValidJwtToken := auth.ValidateJwtAccessToken(tokenString, JWT_SECRET_KEY)
			if isValidJwtToken {
				tokenExpiry, githubUserId, username := auth.IsJwtAccessTokenExpiryInFiveMin(tokenString)
				userInfo := make(map[string]string)
				userInfo["id"] = githubUserId
				userInfo["username"] = username
				if tokenExpiry {
					tokenString = auth.CreateJwtAccessToken(userInfo, JWT_SECRET_KEY)
				}
				formFile, err := c.FormFile("uploadfile")
				if err != nil {
					c.JSON(200, gin.H{
						"isFileUploaded": false,
						"gist_url":       "",
						"gist_id":        "",
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
						UploadResponse := utils.UploadJsonToGist(GIST_API_TOKEN, filename, newFilename, JsonString, userInfo["username"], GOANYJSON_APP_URL)
						models.CreateGist(DATABASE_URL, UploadResponse.GistId, newFilename, fileExtension, UploadResponse.GistURL, githubUserId)
						c.JSON(200, gin.H{
							"isFileUploaded": UploadResponse.FileUpload,
							"gist_url":       UploadResponse.GistURL,
							"gist_id":        UploadResponse.GistId,
							"jwtAccessToken": tokenString,
							"message":        "Conversion and upload was successful",
						})
					} else {
						c.JSON(200, gin.H{
							"isFileUploaded": false,
							"gist_url":       "",
							"gist_id":        "",
							"jwtAccessToken": tokenString,
							"message":        "Conversion to JSON failed",
						})
					}
				}
			} else {
				c.JSON(200, gin.H{
					"isFileUploaded": false,
					"gist_url":       "",
					"gist_id":        "",
					"jwtAccessToken": "",
					"message":        "Invalid JWT access token",
				})
			}
		})

		// Delete a gist
		r.DELETE("/gists/:gist_id", func(c *gin.Context) {
			const BEARER_SCHEMA = "Bearer"
			authHeader := c.GetHeader("Authorization")
			tokenString := authHeader[len(BEARER_SCHEMA)+1:]
			isValidJwtToken := auth.ValidateJwtAccessToken(tokenString, JWT_SECRET_KEY)
			if isValidJwtToken {
				tokenExpiry, githubUserId, username := auth.IsJwtAccessTokenExpiryInFiveMin(tokenString)
				userInfo := make(map[string]string)
				userInfo["id"] = githubUserId
				userInfo["username"] = username
				if tokenExpiry {
					tokenString = auth.CreateJwtAccessToken(userInfo, JWT_SECRET_KEY)
				}
				gist_id := c.Param("gist_id")
				gist_url := fmt.Sprintf("https://api.github.com/gists/%v", gist_id)
				payload := strings.NewReader(`{}`)
				headers := map[string]string{
					"Authorization": fmt.Sprintf("Bearer %s", GIST_API_TOKEN),
					"Content-Type":  "application/json",
				}
				GistDeleteResponse := utils.DeleteRequest(gist_url, payload, headers)
				models.DeleteGist(DATABASE_URL, gist_id, githubUserId)
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
		})

		// Get all gists created by user
		r.GET("/gists", func(c *gin.Context) {
			const BEARER_SCHEMA = "Bearer"
			authHeader := c.GetHeader("Authorization")
			tokenString := authHeader[len(BEARER_SCHEMA)+1:]
			isValidJwtToken := auth.ValidateJwtAccessToken(tokenString, JWT_SECRET_KEY)
			if isValidJwtToken {
				tokenExpiry, id, username := auth.IsJwtAccessTokenExpiryInFiveMin(tokenString)
				userInfo := make(map[string]string)
				userInfo["id"] = id
				userInfo["username"] = username
				if tokenExpiry {
					tokenString = auth.CreateJwtAccessToken(userInfo, JWT_SECRET_KEY)
				}
				gistData := models.GetAllGist(DATABASE_URL, id)
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
		})

		// Get a gist by GIST id
		r.GET("/gists/:gist_id", func(c *gin.Context) {
			gist_id := c.Param("gist_id")
			const BEARER_SCHEMA = "Bearer"
			authHeader := c.GetHeader("Authorization")
			tokenString := authHeader[len(BEARER_SCHEMA)+1:]
			isValidJwtToken := auth.ValidateJwtAccessToken(tokenString, JWT_SECRET_KEY)
			if isValidJwtToken {
				tokenExpiry, id, username := auth.IsJwtAccessTokenExpiryInFiveMin(tokenString)
				userInfo := make(map[string]string)
				userInfo["id"] = id
				userInfo["username"] = username
				if tokenExpiry {
					tokenString = auth.CreateJwtAccessToken(userInfo, JWT_SECRET_KEY)
				}
				gistData := models.GetGist(DATABASE_URL, gist_id)
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
		})
		r.Run(":8003")
	} else {
		fmt.Println("Please set the env variables in ~/.zshrc (OSX - Mac)")
	}
}
