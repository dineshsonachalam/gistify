#!/bin/bash
echo "127.0.0.1 postgres" | sudo tee -a /etc/hosts
echo "💾 Installing frontend dependencies"
npm i --prefix frontend
echo "🚀 Starting frontend and backend app"
npm run start --prefix frontend &
cd backend && go run main.go &
echo "📦📦📦 Running docker-compose"
docker-compose down 
docker-compose up 
