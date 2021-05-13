package utils

import (
	"bytes"
	"container/list"
	"encoding/csv"
	"encoding/json"

	"github.com/tealeg/xlsx"
	"sigs.k8s.io/yaml"
)

type ParserResponse struct {
	FileParsed bool
	JsonString string
}

func YAMLToJSON(data []byte) ParserResponse {
	parsedData, err := yaml.YAMLToJSON(data)
	jsonString := string(parsedData)
	if err != nil {
		return ParserResponse{}
	} else {
		return ParserResponse{true, jsonString}
	}
}

func CSVToJSON(data []byte) ParserResponse {
	bytes_data := bytes.NewReader(data)
	// create a new reader
	r := csv.NewReader(bytes_data)
	records, err := r.ReadAll()
	if err != nil {
		return ParserResponse{}
	} else {
		parsedData := make([]map[string]interface{}, 0, 0)
		header_name := records[0]
		for row_counter, row := range records {
			if row_counter != 0 {
				var singleMap = make(map[string]interface{})
				for col_counter, col := range row {
					singleMap[header_name[col_counter]] = col
				}
				if len(singleMap) > 0 {

					parsedData = append(parsedData, singleMap)
				}
			}
		}
		if len(parsedData) > 0 {
			parsedJson, err := json.Marshal(parsedData)
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
		header_name := list.New()
		// sheet
		for _, sheet := range xlFile.Sheets {
			// rows
			for row_counter, row := range sheet.Rows {
				// column
				header_iterator := header_name.Front()
				var singleMap = make(map[string]interface{})

				for _, cell := range row.Cells {
					if row_counter == 0 {
						text := cell.String()
						header_name.PushBack(text)
					} else {
						text := cell.String()
						singleMap[header_iterator.Value.(string)] = text
						header_iterator = header_iterator.Next()
					}
				}
				if row_counter != 0 && len(singleMap) > 0 {

					parsedData = append(parsedData, singleMap)
				}

			}
		}
		if len(parsedData) > 0 {
			parsedJson, err := json.Marshal(parsedData)
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
