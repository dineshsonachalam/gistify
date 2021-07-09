package utils

import (
	"os"
)

func GetEnv() string {
	return os.Getenv("GISTIFY_APP_ENV")
}
