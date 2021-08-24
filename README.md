<p align="center">
  <a href="https://gistify.dineshsonachalam.com/">
    <img src="https://i.imgur.com/hVDyC3I.png" alt="Gistify">
  </a>
</p>
<p align="center">
    <em>Powered by Go, PostgreSQL, React, Redux, Kubernetes, Cypress E2E and Github CI/CD</em>
</p>

<p align="center">
    <a href="https://sonarcloud.io/dashboard?id=gistify">
        <img src="https://sonarcloud.io/images/project_badges/sonarcloud-white.svg"/>
    </a>
</p>
<p align="center">
    <a href="https://goreportcard.com/report/github.com/dineshsonachalam/gistify">
       <img src="https://goreportcard.com/badge/github.com/dineshsonachalam/gistify"/>
    </a>
    <a href="https://www.codacy.com/gh/dineshsonachalam/gistify/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dineshsonachalam/gistify&amp;utm_campaign=Badge_Grade">
        <img src="https://app.codacy.com/project/badge/Grade/0df66242e68d46dba6d9886d3de2f79e"/>
    </a>
    <a href="https://github.com/dineshsonachalam/Gistify/actions/workflows/k8-deploy.yml" alt="CI/CD status">
        <img src="https://github.com/dineshsonachalam/Gistify/actions/workflows/k8-deploy.yml/badge.svg" />
    </a>
</p>

## Demo
1. <a href="https://gistify.dineshsonachalam.com/">Live demo</a>  
2. <a href="https://vimeo.com/590610461">Video demo</a> 

## What's this project all about?

This project showcases how to build a Go parser that converts (almost) anything(YAML, TOML, CSV, and EXCEL) to JSON and upload it to Github Gist.  We focus on the following aspects as part of this project.

- [x] 1. Build an efficient Golang parser that takes (YAML/TOML/CSV/EXCEL) file as an input and converting it to JSON.
- [x] 2. Build a Golang API service with JWT support using Golang's Gin framework and authenticate users using Github Oauth.
- [x] 3. Take the converted JSON by Golang parser and upload it to Github Gist.
- [x] 4. Build UI using React and Redux.
- [x] 5. Deployment using Kubernetes.

## Start the application

1. Register a new Github OAuth application - https://github.com/settings/applications/new
<img src="https://i.imgur.com/18AUGZN.png"/>

2. Get the Github Client ID and Client Secret.
<img src="https://i.imgur.com/aWGnCRS.png"/>

3. Create a new Github access token with Gist Write permissions - https://github.com/settings/tokens
<img src="https://i.imgur.com/DwyBWxG.png"/>

4. Update the Github client ID in your React applications .env.dev file.

```
dineshsonachalam@macbook gistify % cat frontend/.env.dev 
REACT_APP_API_ENDPOINT = "http://localhost:8003"
REACT_APP_GITHUB_CLIENT_ID = "21c29d28ab59b778a8bd"
REACT_APP_COOKIE_DOMAIN = "localhost"
```

5. Set the following environment variables with Github client ID, Github client secret, Github API token, and JWT secret key.

```
export GISTIFY_APP_ENV="DEV"
export GISTIFY_DEV_APP_URL="http://localhost:3000/"
export GISTIFY_DEV_GITHUB_CLIENT_ID=""
export GISTIFY_DEV_GITHUB_CLIENT_SECRET=""
export GISTIFY_DEV_JWT_SECRET_KEY=""
export GISTIFY_DEV_GIST_API_TOKEN=""
```

6. Start the Postgres container.
```
docker-compose up
```

7. Start the React app.
```
cd frontend && npm run start
```

8. Start the Backend app.
```
cd backend && go run main.go
```

<img src="https://i.imgur.com/QVuD4M0.png"/>

## License

[MIT](https://choosealicense.com/licenses/mit/) © [dineshsonachalam](https://www.github.com/dineshsonachalam)