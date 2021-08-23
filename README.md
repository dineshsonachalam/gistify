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

## License

[MIT](https://choosealicense.com/licenses/mit/) © [dineshsonachalam](https://www.github.com/dineshsonachalam)