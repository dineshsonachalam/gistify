package models

import (
	"context"
	"time"

	"github.com/jackc/pgx/v4"
)

func CreateUserTable(databaseUrl string) bool {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	if err != nil {
		return false
	}
	defer conn.Close(context.Background())
	_, err = conn.Exec(context.Background(), "CREATE TABLE IF NOT EXISTS app_user(id VARCHAR(255) PRIMARY KEY NOT NULL, username VARCHAR(255) NOT NULL, emailID VARCHAR(255) NOT NULL, createdAt TIMESTAMPTZ DEFAULT Now())")
	return err == nil
}

func CreateGistTable(databaseUrl string) bool {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	if err != nil {
		return false
	}
	defer conn.Close(context.Background())
	_, err = conn.Exec(context.Background(), "CREATE TABLE IF NOT EXISTS gist(id VARCHAR(255) PRIMARY KEY NOT NULL, filename VARCHAR(255) NOT NULL, generatedFrom VARCHAR(255) NOT NULL, url VARCHAR(255) NOT NULL, githubUserID VARCHAR(255) NOT NULL references app_user(id), createdAt TIMESTAMPTZ DEFAULT Now())")
	return err == nil
}

func CreateUser(databaseUrl string, id string, username string, emailID string) bool {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	if err != nil {
		return false
	}
	defer conn.Close(context.Background())
	_, err = conn.Exec(context.Background(), "INSERT INTO app_user(id, username, emailID) VALUES($1, $2, $3)", id, username, emailID)
	return err == nil
}

func GetUser(databaseUrl string, id string) (bool, string) {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	var githubUserID string
	var username string
	if err != nil {
		return false, username
	}
	defer conn.Close(context.Background())
	err = conn.QueryRow(context.Background(), "select id, username from app_user where id=$1", id).Scan(&githubUserID, &username)
	if err != nil || githubUserID != id {
		return false, username
	} else {
		return true, username
	}
}

func CreateGist(databaseUrl string, id string, filename string, generatedFrom string, url string, githubUserID string) bool {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	if err != nil {
		return false
	}
	defer conn.Close(context.Background())
	_, err = conn.Exec(context.Background(), "INSERT INTO gist(id, filename, generatedFrom, url, githubUserID) VALUES($1, $2, $3, $4, $5)", id, filename, generatedFrom, url, githubUserID)
	return err == nil
}

func DeleteGist(databaseUrl string, gistID string, githubUserID string) bool {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	if err != nil {
		return false
	}
	defer conn.Close(context.Background())
	_, err = conn.Exec(context.Background(), "DELETE FROM gist WHERE id=$1 AND githubUserID=$2", gistID, githubUserID)
	return err == nil
}

func GetAllGist(databaseUrl string, githubUserID string) []map[string]interface{} {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	gistData := make([]map[string]interface{}, 0)
	if err != nil {
		return gistData
	}
	defer conn.Close(context.Background())
	rows, err := conn.Query(context.Background(), "SELECT id, filename, generatedFrom, url, date_trunc('second', createdAt) as createdAt FROM gist WHERE githubUserID=$1 ORDER BY createdAt DESC NULLS LAST", githubUserID)
	if err != nil {
		return gistData
	} else {
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
			} else {
				var gist = make(map[string]interface{})
				gist["key"] = id
				gist["filename"] = filename
				gist["generatedFrom"] = generatedFrom
				gist["url"] = url
				gist["createdAt"] = createdAt
				gistData = append(gistData, gist)
			}
		}
		return gistData
	}
}

func GetGist(databaseUrl string, gistID string) map[string]interface{} {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	gistData := make(map[string]interface{})
	if err != nil {
		return gistData
	}
	defer conn.Close(context.Background())
	rows, err := conn.Query(context.Background(), "SELECT id, filename, generatedFrom, url, date_trunc('second', createdAt) as createdAt FROM gist WHERE id=$1", gistID)
	if err != nil {
		return gistData
	} else {
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
			} else {
				gistData["key"] = id
				gistData["filename"] = filename
				gistData["generatedFrom"] = generatedFrom
				gistData["url"] = url
				gistData["createdAt"] = createdAt
			}
		}
		return gistData
	}
}
