# Gyst
A Gist like application.

## Technology Stack
* Spring Boot
* Vue.js

# Development

## Set Environment Variables
```bash
export GOOGLE_CLIENT_ID=<YOUR ID>
export GOOGLE_CLIENT_SECRET=<YOUR SECRETE>
```

## Run Application
```bash
docker-compose up -d

# run backend server
./gradlew bootRun

# buuld frontend dev server
cd frontend
yarn install
yarn run dev
```
