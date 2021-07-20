package auth

import (
	"encoding/json"
	"time"

	"github.com/dgrijalva/jwt-go"
)

type JwtPayload struct {
	Id       string `json:"id"`
	Username string `json:"username"`
	jwt.StandardClaims
}

// CreateJwtAccessToken return JWT access token
func CreateJwtAccessToken(payload map[string]string, jwtSecretKey []byte) string {
	// Step 1: Token expiration time - 15 minutes
	tokenExpirationTime := time.Now().Add(15 * time.Minute)
	// Step 2: Create JWT payload, which includes the
	// id, username, and token expiration time
	jwtPayload := &JwtPayload{
		Id:       payload["id"],
		Username: payload["username"],
		StandardClaims: jwt.StandardClaims{
			// In JWT, the expiry time is expressed as unix milliseconds
			ExpiresAt: tokenExpirationTime.Unix(),
		},
	}
	// Step 3: Declare the JWT token with algorithm used for signing
	// and the payload
	token := jwt.NewWithClaims(jwt.SigningMethodHS256, jwtPayload)
	// Step 4: Create the JWT access token
	jwtAccessToken, _ := token.SignedString(jwtSecretKey)
	return jwtAccessToken
}

// ValidateJwtAccessToken return the JWT access token validation status
func ValidateJwtAccessToken(jwtAccessToken string, jwtSecretKey []byte) bool {
	// Step 1: Initialize a new instance of JwtPayload
	jwtPayload := &JwtPayload{}
	// Step 2: JWT Token <HEADER>.<PAYLOAD>.<SIGNATURE>
	// Compute signature using Header + Payload using JWT secret key.
	// Then comparing generated signature with computed signature.
	// If two signature matches, token is valid else invalid.
	jwtToken, err := jwt.ParseWithClaims(jwtAccessToken, jwtPayload, func(token *jwt.Token) (interface{}, error) {
		return jwtSecretKey, nil
	})
	if err != nil || !jwtToken.Valid {
		return false
	}
	return true
}

// IsJwtAccessTokenExpiryInFiveMin return the status of JWT access token expiry is within 5 minutes.
func IsJwtAccessTokenExpiryInFiveMin(jwtAccessToken string) (bool, string, string) {
	token, _, err := new(jwt.Parser).ParseUnverified(jwtAccessToken, jwt.MapClaims{})
	if err != nil {
		return false, "", ""
	}
	jwtPayload, ok := token.Claims.(jwt.MapClaims)
	if !ok {
		return false, "", ""
	}
	var tokenExpirationTime time.Time
	id := jwtPayload["id"].(string)
	username := jwtPayload["username"].(string)
	switch exp := jwtPayload["exp"].(type) {
	case float64:
		tokenExpirationTime = time.Unix(int64(exp), 0)
	case json.Number:
		v, _ := exp.Int64()
		tokenExpirationTime = time.Unix(v, 0)
	}
	currentTime := time.Now().Add(5 * time.Minute)
	if tokenExpirationTime.Before(currentTime) {
		return true, id, username
	}
	return false, id, username
}
