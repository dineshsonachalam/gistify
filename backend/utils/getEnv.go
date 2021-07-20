package utils

import (
	"os"
)

// GetEnv return APP env (dev or prod)
func GetEnv() string {
	return os.Getenv("GISTIFY_APP_ENV")
}
