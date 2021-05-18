package utils

import (
	"os"
)

func GetEnv() string {
	return os.Getenv("GOANYJSON_APP_ENV")
}
