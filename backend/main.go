package main

import (
	"any-json/utils"
	"io/ioutil"
	"path/filepath"
	"strings"

	"github.com/gin-gonic/gin"
)

type AppStats struct {
	FileParsed bool
	JsonString string
	FileUpload bool
	GistURL    string
}

func main() {
	router := gin.Default()
	apiResponse := AppStats{}
	databaseUrl := "postgres://dinesh:simple@postgres:5432/anyjson"
	appUrl := "https://anyjson.dineshsonachalam.com"
	userId := "1"

	author := "https://github.com/dineshsonachalam"
	router.POST("/upload", func(c *gin.Context) {
		formFile, err := c.FormFile("uploadfile")
		if err != nil {
			c.JSON(200, gin.H{
				"success": false,
				"payload": "{}",
			})
		}
		// Get raw file bytes - no reader method
		openedFile, _ := formFile.Open()
		file, _ := ioutil.ReadAll(openedFile)
		filename := filepath.Base(formFile.Filename)
		fileExtension := filepath.Ext(filename)
		newFilename := (strings.Split(filename, "."))[0] + ".json"

		ParserResponse := utils.ParserResponse{}
		UploadResponse := utils.UploadResponse{}

		if fileExtension == ".yaml" || fileExtension == ".yml" {
			ParserResponse = utils.YAMLToJSON(file)
		} else if fileExtension == ".toml" {
			ParserResponse = utils.TOMLToJSON(file)
		} else if fileExtension == ".csv" {
			ParserResponse = utils.CSVToJSON(file)
		} else if fileExtension == ".xlsx" {
			ParserResponse = utils.ExcelToJSON(file)
		}
		apiResponse.FileParsed = ParserResponse.FileParsed
		apiResponse.JsonString = ParserResponse.JsonString
		if apiResponse.FileParsed == true {
			UploadResponse = utils.UploadJsonToGist(filename, newFilename, apiResponse.JsonString, author, appUrl)
			c.JSON(200, gin.H{
				"isFileUploaded": UploadResponse.FileUpload,
				"gist_url":       UploadResponse.GistURL,
				"gist_id":        UploadResponse.GistId,
			})
		} else {
			c.JSON(200, gin.H{
				"isFileUploaded": UploadResponse.FileUpload,
				"gist_url":       UploadResponse.GistURL,
				"gist_id":        UploadResponse.GistId,
			})
		}
	})
	router.Run(":8003")
}

// dineshsonachalam@macbook ~ % source ~/.bash_profile
// dineshsonachalam@macbook ~ % echo $GIST_API_TOKEN
