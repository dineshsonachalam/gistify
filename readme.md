


### Pending work:

1. CRUD functionality.
```
// Postgres table schema:
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS gists;

CREATE TABLE users(
   github_user_id VARCHAR(255) NOT NULL,
   github_username VARCHAR(255) NOT NULL,
   github_email_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(github_user_id)
);

CREATE TABLE gists(
   gist_id VARCHAR(255) NOT NULL,
   gist_url VARCHAR(255) NOT NULL,
   github_user_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(gist_id),
   CONSTRAINT fk_user
      FOREIGN KEY(github_user_id) 
	  REFERENCES users(github_user_id)
);

// Operations:
1. Create user.
2. Validate if the user_id is available in the table users.
3. User will be able to create gist after Oauth validation.
4. List down all the gist created by the user by filtering gists table by github_user_id. 
   Sort by last modified data.
5. Delete gists by gist id.
```
**NOTE**
Keys that I'm interested to look from the Github Oauth response.
```
{
    "id": 12673979, // github user id
    "login": "dineshsonachalam",
    "email": "dineshsonachalam@gmail.com" // github user email
}
```
2. Add Github Oauth to the Backend.
3. Migrate from HTTP2 to GRPC using grpc gateway.
4. Develop frontend.
5. Add test for frontend and backend.
6. k8 deployment.


#### Go guideline
1. To initialize a project with go module, run:
```go mod init your-project-name```

2.Add missing and/or remove unused modules: 
```go mod tidy```

3. You can even vendor the modules in your project directory:
```
go mod vendor
```

Creating gists:
```
curl --location --request POST 'https://api.github.com/gists' \
--header 'Authorization: Bearer <ACCESS_TOKEN>' \
--header 'Content-Type: application/json' \
--header 'Cookie: _octo=GH1.1.329936248.1614167878; logged_in=no' \
--data-raw '{"public":true,"files":{"test.txt":{"content":"String file contents"}}}'
```