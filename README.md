# CatapultLabs test task

This project contains an example of a meter reading service

## Development

- Run the Spring Boot application which will run on port 8080
NOTE: you need to have maven installed for this: 'https://www.baeldung.com/install-maven-on-windows-linux-mac'
Within the terminal run: `mvn spring-boot:run`

- Run the Vue application (/src/frontend)  which will run on port 3000
Open up another terminal window
First navigate to `cd src/frontend`
Then run for development with hotreload: `npm run serve`

- All calls to `/api/**` are proxied to 8080 thanks to `vue.config.js`

## Packaging 

When you run `mvn clean package` the frontend Vue application will build in the `dist` directory. 
The Maven plugin `maven-resources-plugin` will copy the contents of the build directory into `/target/static/classes`




