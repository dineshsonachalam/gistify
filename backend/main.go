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

// getEnv return environmental variables
func GetEnv() (string, string, []byte, string, string, string, string) {
	ENV := utils.GetEnv()
	GITHUB_CLIENT_ID := os.Getenv(fmt.Sprintf("GISTIFY_%s_GITHUB_CLIENT_ID", ENV))
	GITHUB_CLIENT_SECRET := os.Getenv(fmt.Sprintf("GISTIFY_%s_GITHUB_CLIENT_SECRET", ENV))
	JWT_SECRET_KEY := []byte(os.Getenv(fmt.Sprintf("GISTIFY_%s_JWT_SECRET_KEY", ENV)))
	GIST_API_TOKEN := os.Getenv(fmt.Sprintf("GISTIFY_%s_GIST_API_TOKEN", ENV))
	GISTIFY_APP_URL := os.Getenv(fmt.Sprintf("GISTIFY_%s_APP_URL", ENV))
	DATABASE_URL := "postgres://dinesh:simple@postgres:5432/dinesh-micro-apps"
	var COOKIE_DOMAIN string
	if ENV == "DEV" {
		COOKIE_DOMAIN = ".localhost"
	} else {
		COOKIE_DOMAIN = ".dineshsonachalam.com"
	}
	return GITHUB_CLIENT_ID, GITHUB_CLIENT_SECRET, JWT_SECRET_KEY, GIST_API_TOKEN, GISTIFY_APP_URL, DATABASE_URL, COOKIE_DOMAIN
}

func GithubOauthRedirect(c *gin.Context, GITHUB_CLIENT_ID string, GITHUB_CLIENT_SECRET string,
	JWT_SECRET_KEY []byte, DATABASE_URL string, COOKIE_DOMAIN string, GISTIFY_APP_URL string) {
	requestToken := c.Request.FormValue("code")
	userDetails := auth.GithubUserDetails(GITHUB_CLIENT_ID, GITHUB_CLIENT_SECRET, requestToken)
	userInfo := make(map[string]string)
	userInfo["id"] = userDetails.Id
	userInfo["username"] = userDetails.Username
	jwtAccessToken := auth.CreateJwtAccessToken(userInfo, JWT_SECRET_KEY)
	models.CreateUserTable(DATABASE_URL)
	models.CreateGistTable(DATABASE_URL)
	isUserAlreadyPresent, _ := models.GetUser(DATABASE_URL, userInfo["id"])
	if !isUserAlreadyPresent {
		models.CreateUser(DATABASE_URL, userInfo["id"], userInfo["username"], userDetails.Email)
	}
	// Expiry time in minutes - Setting expiry time as 40 minute
	c.SetCookie("token", jwtAccessToken, (40 * 60), "/", COOKIE_DOMAIN, false, false)
	c.Redirect(301, GISTIFY_APP_URL+userInfo["username"])
}

func CreateNewGist(c *gin.Context, JWT_SECRET_KEY []byte, GIST_API_TOKEN string,
	GISTIFY_APP_URL string, DATABASE_URL string) {
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
				UploadResponse := utils.UploadJsonToGist(GIST_API_TOKEN, filename, newFilename, JsonString, userInfo["username"], GISTIFY_APP_URL)
				models.CreateGist(DATABASE_URL, UploadResponse.GistId, newFilename, fileExtension, UploadResponse.GistURL, githubUserId)
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

func DeleteGist(c *gin.Context, JWT_SECRET_KEY []byte, GIST_API_TOKEN string, DATABASE_URL string) {
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
		gistID := c.Param("gistID")
		gistURL := fmt.Sprintf("https://api.github.com/gists/%v", gistID)
		payload := strings.NewReader(`{}`)
		headers := map[string]string{
			"Authorization": fmt.Sprintf("Bearer %s", GIST_API_TOKEN),
			"Content-Type":  "application/json",
		}
		GistDeleteResponse := utils.DeleteRequest(gistURL, payload, headers)
		models.DeleteGist(DATABASE_URL, gistID, githubUserId)
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

func GetAllGists(c *gin.Context, JWT_SECRET_KEY []byte, DATABASE_URL string) {
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
}

func GetGist(c *gin.Context, JWT_SECRET_KEY []byte, DATABASE_URL string) {
	gistID := c.Param("gistID")
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
		gistData := models.GetGist(DATABASE_URL, gistID)
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
	GITHUB_CLIENT_ID, GITHUB_CLIENT_SECRET, JWT_SECRET_KEY, GIST_API_TOKEN, GISTIFY_APP_URL, DATABASE_URL, COOKIE_DOMAIN := GetEnv()
	r := gin.Default()
	r.Use(middleware.CORSMiddleware())
	if (len(GITHUB_CLIENT_ID) > 0) && (len(GITHUB_CLIENT_SECRET) > 0) {
		// Github Oauth redirect
		r.GET("/oauth/redirect", func(c *gin.Context) {
			GithubOauthRedirect(c, GITHUB_CLIENT_ID, GITHUB_CLIENT_SECRET,
				JWT_SECRET_KEY, DATABASE_URL, COOKIE_DOMAIN,
				GISTIFY_APP_URL)
		})

		// Create a new gist
		r.POST("/gists", func(c *gin.Context) {
			CreateNewGist(c, JWT_SECRET_KEY, GIST_API_TOKEN, GISTIFY_APP_URL, DATABASE_URL)
		})

		// Delete a gist
		r.DELETE("/gists/:gistID", func(c *gin.Context) {
			DeleteGist(c, JWT_SECRET_KEY, GIST_API_TOKEN, DATABASE_URL)
		})

		// Get all gists created by user
		r.GET("/gists", func(c *gin.Context) {
			GetAllGists(c, JWT_SECRET_KEY, DATABASE_URL)
		})

		// Get a gist by GIST id
		r.GET("/gists/:gistID", func(c *gin.Context) {
			GetGist(c, JWT_SECRET_KEY, DATABASE_URL)
		})
		r.Run(":8003")
	} else {
		fmt.Println("Please set the env variables in ~/.zshrc (OSX - Mac)")
	}
}
