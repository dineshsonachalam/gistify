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
	} else {
		defer conn.Close(context.Background())
		_, err = conn.Exec(context.Background(), "CREATE TABLE IF NOT EXISTS app_user(id VARCHAR(255) PRIMARY KEY NOT NULL, username VARCHAR(255) NOT NULL, email_id VARCHAR(255) NOT NULL, created_at TIMESTAMPTZ DEFAULT Now())")
		if err != nil {
			return false
		} else {
			return true
		}
	}
}

func CreateGistTable(databaseUrl string) bool {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	if err != nil {
		return false
	} else {
		defer conn.Close(context.Background())
		_, err = conn.Exec(context.Background(), "CREATE TABLE IF NOT EXISTS gist(id VARCHAR(255) PRIMARY KEY NOT NULL, filename VARCHAR(255) NOT NULL, generated_from VARCHAR(255) NOT NULL, url VARCHAR(255) NOT NULL, github_user_id VARCHAR(255) NOT NULL references app_user(id), created_at TIMESTAMPTZ DEFAULT Now())")
		if err != nil {
			return false
		} else {
			return true
		}
	}
}

func CreateUser(databaseUrl string, id string, username string, email_id string) bool {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	if err != nil {
		return false
	} else {
		defer conn.Close(context.Background())
		_, err = conn.Exec(context.Background(), "INSERT INTO app_user(id, username, email_id) VALUES($1, $2, $3)", id, username, email_id)
		if err != nil {
			return false
		} else {
			return true
		}
	}
}

func GetUser(databaseUrl string, id string) (bool, string) {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	var github_user_id string
	var username string
	if err != nil {
		return false, username
	} else {
		defer conn.Close(context.Background())
		err := conn.QueryRow(context.Background(), "select id, username from app_user where id=$1", id).Scan(&github_user_id, &username)
		if err != nil || github_user_id != id {
			return false, username
		} else {
			return true, username
		}
	}
}

func CreateGist(databaseUrl string, id string, filename string, generated_from string, url string, github_user_id string) bool {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	if err != nil {
		return false
	} else {
		defer conn.Close(context.Background())
		_, err = conn.Exec(context.Background(), "INSERT INTO gist(id, filename, generated_from, url, github_user_id) VALUES($1, $2, $3, $4, $5)", id, filename, generated_from, url, github_user_id)
		if err != nil {
			return false
		} else {
			return true
		}
	}
}

func DeleteGist(databaseUrl string, gist_id string, github_user_id string) bool {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	if err != nil {
		return false
	} else {
		defer conn.Close(context.Background())
		_, err = conn.Exec(context.Background(), "DELETE FROM gist WHERE id=$1 AND github_user_id=$2", gist_id, github_user_id)
		if err != nil {
			return false
		} else {
			return true
		}
	}
}

func GetAllGist(databaseUrl string, github_user_id string) []map[string]interface{} {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	gistData := make([]map[string]interface{}, 0, 0)
	if err != nil {
		return gistData
	} else {
		defer conn.Close(context.Background())
		rows, err := conn.Query(context.Background(), "SELECT id, filename, generated_from, url, date_trunc('second', created_at) as created_at FROM gist WHERE github_user_id=$1 ORDER BY created_at DESC NULLS LAST", github_user_id)
		if err != nil {
			return gistData
		} else {
			defer rows.Close()
			for rows.Next() {
				var id string
				var filename string
				var generated_from string
				var url string
				var created_at time.Time
				err = rows.Scan(&id, &filename, &generated_from, &url, &created_at)
				if err != nil {
					return gistData
				} else {
					var gist = make(map[string]interface{})
					gist["key"] = id
					gist["filename"] = filename
					gist["generated_from"] = generated_from
					gist["url"] = url
					gist["created_at"] = created_at
					gistData = append(gistData, gist)
				}
			}
			return gistData
		}
	}
}

func GetGist(databaseUrl string, gist_id string) map[string]interface{} {
	conn, err := pgx.Connect(context.Background(), databaseUrl)
	gistData := make(map[string]interface{})
	if err != nil {
		return gistData
	} else {
		defer conn.Close(context.Background())
		rows, err := conn.Query(context.Background(), "SELECT id, filename, generated_from, url, date_trunc('second', created_at) as created_at FROM gist WHERE id=$1", gist_id)
		if err != nil {
			return gistData
		} else {
			defer rows.Close()
			for rows.Next() {
				var id string
				var filename string
				var generated_from string
				var url string
				var created_at time.Time
				err = rows.Scan(&id, &filename, &generated_from, &url, &created_at)
				if err != nil {
					return gistData
				} else {
					gistData["key"] = id
					gistData["filename"] = filename
					gistData["generated_from"] = generated_from
					gistData["url"] = url
					gistData["created_at"] = created_at
				}
			}
			return gistData
		}
	}
}
