# CatapultLabs test task

This project contains an example of a meter reading service

## Development

### Prerequisites

- You will need the latest npm (version 8.12.2), latest maven (https://maven.apache.org/install.html)
and postgreSQL to create the database 

- postgreSQL for windows: download the latest postgreSQL version (at the time 14.4) from https://www.enterprisedb.com/downloads/postgres-postgresql-downloads.
After installation open the application pgAdmin. Create a database named `catapultTest` by navigating from the sidebar to Databases, right click and select Create
Then make sure the owner is postgres. Within the application.properties file within /src/main/java/dev/toode/resources is the database username and password. Set that
to the password that you have for the user postgres. Within pgAdmin you can change the password of the user posgres by navigating to Login/Group roles and right click on postgres,
go to definition and set a password. 

- postgreSQL for mac: download and install https://postgresapp.com/, after installation you can open the Terminal and type `psql`.
After that you need to create a database called catapultTest by running `CREATE DATABASE catapultTest;`
Currently you should have two users, you can check by running `\du`.
We still need to grant priviledges to the users to use the database catapultTest, you can do that by typing `GRANT ALL PRIVILEDGES ON DATABASE "catapultTest" TO posgres;`
And let's give all the priviledges to the you as the user `GRANT ALL PRIVILEDGES ON DATABASE "catapultTest" TO {username};`.

On a mac you need to navigate to the application.properties file within /src/main/java/dev/toode/resources and where the spring.datasource.username and spring.datasource.password are being asked
leave them just blank.

### Running the application

- Run the Spring Boot application which will run on port 8080
NOTE: you need to have maven installed for this: 'https://www.baeldung.com/install-maven-on-windows-linux-mac'
Within the terminal run: `mvn spring-boot:run`

- Run the Vue application (/src/frontend)  which will run on port 3000
Open up another terminal window
First navigate to `cd src/frontend`
Then run for development with hotreload: `npm run serve`

- All calls to `/api/**` are proxied to 8080 due to `vue.config.js`

- The application should be running on localhost:3000






