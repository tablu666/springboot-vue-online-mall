# E-commerce website

#### A full-stack web application using Spring boot and Vue Cli.
This is an online shopping application with frontend and backend separated which is mainly developed for consumers, it also includes simple order & user management backend services.
The frontend calls the backend API and performs data interaction through json.

#### Live Demo: [https://tvmall-tablu.herokuapp.com/](https://tvmall-tablu.herokuapp.com/)

## Screenshot
![]()

## Features
- REST API
- Full JSON interaction
- Redis-based shopping cart
- Order payment process
- Categories
- Pagination

## Technology Stacks
**Backend**
- Java 8
- Spring Boot 2.1.7
- Mybatis
- MySQL
- Redis
- Spring Security
- Maven

**Frontend**
- Vue CLI 4.5.4

## Database Schema
![]()

## Rapid deployment & Run
**Backend**
1. Install [MySQL](https://dev.mysql.com/downloads/mysql/5.7.html)
2. Create a local database like 'mall' using MySQL Workbench or Navicat.
3. Execute SQL statement to build table. (`cd backend/src/main/resources/sql`)
4. Prepare [Redis](https://redis.io/)
5. Configure spring datasource & Redis in `application.yml`
6. The server is running on localhost:8080

**Frontend**
1. Install [Node.js and npm](https://www.npmjs.com/get-npm)
2. `cd frontend`
3. Run `npm install`
4. Run `npm run serve`
5. The client is runnning on localhost:8081

Note: it only works locally, some codes should be modified before production mode.