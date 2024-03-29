package models

import (
	"context"
	"time"

	"github.com/jackc/pgx/v4"
)

// CreateUserTable return status of user table creation
func CreateUserTable(databaseURL string) bool {
	conn, err := pgx.Connect(context.Background(), databaseURL)
	if err != nil {
		return false
	}
	defer conn.Close(context.Background())
	_, err = conn.Exec(context.Background(), "CREATE TABLE IF NOT EXISTS app_user(id VARCHAR(255) PRIMARY KEY NOT NULL, username VARCHAR(255) NOT NULL, emailID VARCHAR(255) NOT NULL, createdAt TIMESTAMPTZ DEFAULT Now())")
	return err == nil
}

// CreateGistTable return status of gist table creation
func CreateGistTable(databaseURL string) bool {
	conn, err := pgx.Connect(context.Background(), databaseURL)
	if err != nil {
		return false
	}
	defer conn.Close(context.Background())
	_, err = conn.Exec(context.Background(), "CREATE TABLE IF NOT EXISTS gist(id VARCHAR(255) PRIMARY KEY NOT NULL, filename VARCHAR(255) NOT NULL, generatedFrom VARCHAR(255) NOT NULL, url VARCHAR(255) NOT NULL, githubUserID VARCHAR(255) NOT NULL references app_user(id), createdAt TIMESTAMPTZ DEFAULT Now())")
	return err == nil
}

// CreateUser return status of user creation
func CreateUser(databaseURL string, id string, username string, emailID string) bool {
	conn, err := pgx.Connect(context.Background(), databaseURL)
	if err != nil {
		return false
	}
	defer conn.Close(context.Background())
	_, err = conn.Exec(context.Background(), "INSERT INTO app_user(id, username, emailID) VALUES($1, $2, $3)", id, username, emailID)
	return err == nil
}

// GetUser return status of user id availability in the database and the username
func GetUser(databaseURL string, id string) (bool, string) {
	conn, err := pgx.Connect(context.Background(), databaseURL)
	var githubUserID string
	var username string
	if err != nil {
		return false, username
	}
	defer conn.Close(context.Background())
	err = conn.QueryRow(context.Background(), "select id, username from app_user where id=$1", id).Scan(&githubUserID, &username)
	if err != nil || githubUserID != id {
		return false, username
	}
	return true, username
}

// CreateGist return status of gist creation
func CreateGist(databaseURL string, id string, filename string, generatedFrom string, url string, githubUserID string) bool {
	conn, err := pgx.Connect(context.Background(), databaseURL)
	if err != nil {
		return false
	}
	defer conn.Close(context.Background())
	_, err = conn.Exec(context.Background(), "INSERT INTO gist(id, filename, generatedFrom, url, githubUserID) VALUES($1, $2, $3, $4, $5)", id, filename, generatedFrom, url, githubUserID)
	return err == nil
}

// DeleteGist return status of gist deletion
func DeleteGist(databaseURL string, gistID string, githubUserID string) bool {
	conn, err := pgx.Connect(context.Background(), databaseURL)
	if err != nil {
		return false
	}
	defer conn.Close(context.Background())
	_, err = conn.Exec(context.Background(), "DELETE FROM gist WHERE id=$1 AND githubUserID=$2", gistID, githubUserID)
	return err == nil
}

// GetAllGist return all gist created by a user
func GetAllGist(databaseURL string, githubUserID string) []map[string]interface{} {
	conn, err := pgx.Connect(context.Background(), databaseURL)
	gistData := make([]map[string]interface{}, 0)
	if err != nil {
		return gistData
	}
	defer conn.Close(context.Background())
	rows, err := conn.Query(context.Background(), "SELECT id, filename, generatedFrom, url, date_trunc('second', createdAt) as createdAt FROM gist WHERE githubUserID=$1 ORDER BY createdAt DESC NULLS LAST", githubUserID)
	if err != nil {
		return gistData
	}
	defer rows.Close()
	for rows.Next() {
		var id string
		var filename string
		var generatedFrom string
		var url string
		var createdAt time.Time
		err = rows.Scan(&id, &filename, &generatedFrom, &url, &createdAt)
		if err != nil {
			return gistData
		}
		var gist = make(map[string]interface{})
		gist["key"] = id
		gist["filename"] = filename
		gist["generatedFrom"] = generatedFrom
		gist["url"] = url
		gist["createdAt"] = createdAt
		gistData = append(gistData, gist)
	}
	return gistData
}

// GetGist return a gist created by a user
func GetGist(databaseURL string, gistID string) map[string]interface{} {
	conn, err := pgx.Connect(context.Background(), databaseURL)
	gistData := make(map[string]interface{})
	if err != nil {
		return gistData
	}
	defer conn.Close(context.Background())
	rows, err := conn.Query(context.Background(), "SELECT id, filename, generatedFrom, url, date_trunc('second', createdAt) as createdAt FROM gist WHERE id=$1", gistID)
	if err != nil {
		return gistData
	}
	defer rows.Close()
	for rows.Next() {
		var id string
		var filename string
		var generatedFrom string
		var url string
		var createdAt time.Time
		err = rows.Scan(&id, &filename, &generatedFrom, &url, &createdAt)
		if err != nil {
			return gistData
		}
		gistData["key"] = id
		gistData["filename"] = filename
		gistData["generatedFrom"] = generatedFrom
		gistData["url"] = url
		gistData["createdAt"] = createdAt
	}
	return gistData
}
