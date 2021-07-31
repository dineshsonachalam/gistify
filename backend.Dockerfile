FROM golang:rc-buster

WORKDIR /go/src/app

COPY backend .

ENV PORT=8003

EXPOSE $PORT

RUN go build main.go

CMD ["./main"]

