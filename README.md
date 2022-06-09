# kotlin-spring-boot-openapi-gradle
This is a demo Kotlin Spring Boot Webserver with a hibernate JPA and generated OpenApi model. Also testing the Kotlin Gradle DLS

## How to start
Execute the gradle Task  Shared > other > buildKotlinSpring         

You can also uncomment in Shared the JavaCompile Task

Then you can use the Run Command in Backend

### Stack:
- Kotlin
- Gradle DSL Kotlin
- Hibernate 
- SQLite
- Spring Boot
- OpenAPI Generator
- React
## Overview
#### Test Client
is a small React App that uses generated code to fetch data
* yarn generate command is needed to generate the api calls
#### Shared
Libary that contains the generated Kotlin OpenApi Code
* /specs/ contains the OpenApi Model
#### Backend
Backend Server Needs the Shared library to run, hibernate creates the necessary Database 