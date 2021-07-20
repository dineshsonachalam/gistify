package utils

import (
	"bytes"
	"container/list"
	"encoding/csv"
	"encoding/json"
	"fmt"
	"strings"

	"github.com/pelletier/go-toml"
	"github.com/tealeg/xlsx"
	"sigs.k8s.io/yaml"
)

type ParserResponse struct {
	FileParsed bool
	JsonString string
}

func YAMLToJSON(data []byte) ParserResponse {
	parsedData, _ := yaml.YAMLToJSON(data)
	jsonMap := make(map[string]interface{})
	if err := json.Unmarshal(parsedData, &jsonMap); err != nil {
		return ParserResponse{}
	} else {
		parsedJson, err := json.MarshalIndent(jsonMap, "", "  ")
		jsonString := string(parsedJson)
		if err != nil {
			return ParserResponse{}
		} else {
			return ParserResponse{true, jsonString}
		}
	}

}

func TOMLToJSON(data []byte) ParserResponse {
	readerData := strings.NewReader(string(data))
	tree, err := toml.LoadReader(readerData)
	if err != nil {
		return ParserResponse{}
	} else {
		treeMap := tree.ToMap()
		bytes, err := json.MarshalIndent(treeMap, "", "  ")
		if err != nil {
			return ParserResponse{}
		} else {
			jsonString := string(bytes[:])
			return ParserResponse{true, jsonString}
		}
	}
}

func CSVToJSON(data []byte) ParserResponse {
	bytesData := bytes.NewReader(data)
	// create a new reader
	r := csv.NewReader(bytesData)
	records, err := r.ReadAll()
	if err != nil {
		return ParserResponse{}
	} else {
		parsedData := make([]map[string]interface{}, 0, 0)
		headerName := records[0]
		for rowCounter, row := range records {
			if rowCounter != 0 {
				var singleMap = make(map[string]interface{})
				for colCounter, col := range row {
					singleMap[headerName[colCounter]] = col
				}
				if len(singleMap) > 0 {

					parsedData = append(parsedData, singleMap)
				}
			}
		}
		if len(parsedData) > 0 {
			fmt.Printf("var2 = %T\n", parsedData)
			parsedJson, err := json.MarshalIndent(parsedData, "", "  ")
			if err != nil {
				return ParserResponse{}
			} else {
				jsonString := string(parsedJson)
				return ParserResponse{true, jsonString}
			}
		} else {
			return ParserResponse{}
		}
	}
}

func ExcelToJSON(data []byte) ParserResponse {
	xlFile, err := xlsx.OpenBinary(data)
	if err != nil {
		return ParserResponse{}
	} else {
		parsedData := make([]map[string]interface{}, 0, 0)
		headerName := list.New()
		// sheet
		for _, sheet := range xlFile.Sheets {
			// rows
			for rowCounter, row := range sheet.Rows {
				// column
				headerIterator := headerName.Front()
				var singleMap = make(map[string]interface{})

				for _, cell := range row.Cells {
					if rowCounter == 0 {
						text := cell.String()
						headerName.PushBack(text)
					} else {
						text := cell.String()
						singleMap[headerIterator.Value.(string)] = text
						headerIterator = headerIterator.Next()
					}
				}
				if rowCounter != 0 && len(singleMap) > 0 {

					parsedData = append(parsedData, singleMap)
				}

			}
		}
		if len(parsedData) > 0 {
			parsedJson, err := json.MarshalIndent(parsedData, "", "  ")
			if err != nil {
				return ParserResponse{}
			} else {
				jsonString := string(parsedJson)
				return ParserResponse{true, jsonString}
			}
		} else {
			return ParserResponse{}
		}
	}
}
