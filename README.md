
# Registration FrontEnd
This is simple registration backend using the following technologies
- Framework: Spring Boot
- ORM Framework: JPA
- Unit test: Mockito
- RESTful

## Requirements

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* [MySQL](https://www.mysql.com/) - Open-Source Relational Database Management System

## Install

* Database
    
    ```
    CREATE DATABASE mitrias_0107;
    CREATE TABLE user
    (
      id            bigint auto_increment
        primary key,
      date_of_birth datetime     null,
      email         varchar(255) null,
      first_name    varchar(255) null,
      gender        int          null,
      last_name     varchar(255) null,
      phone_number  varchar(255) null
    )
    ```
* Backend
    
    - git clone `https://github.com/linh626688/registration-be`
    - run locally `mvn spring-boot:run`  or executed Main class `RegistrationApplication.java`

## Files and Directories
```
    .
    ├── .idea
    ├── src
    │   └── main
    │       └── java
    │           ├── com.helix.registration
    │           ├── com.helix.registration.config
    │           ├── com.helix.registration.controller
    │           ├── com.helix.registration.model
    │           ├── com.arc.application.service
    │           └── com.arc.application.repository   
    │           └── RegistrationApplication.java
    ├── src
    │   └── main
    │       └── resources
    │           ├── application.properties
    ├── src
    │   └── test
    │       └── java
    │           ├── com.helix.registration
    │               ├── RegistrationApplicationTests.java
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    └── README.md
```

## packages

- `models` — to hold our entities and dto;
- `repository` — to communicate with the database;
- `service` — to hold our business logic;
- `controllers` — to listen to the client;
- `resources/` - Contains all the static resources, templates and property files.
- `resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

- `test/` - contains unit tests

- `pom.xml` - contains all the project dependencies


### Unit test
- We have 3 function test in RegistrationApplicationTests.java succeeded
  
### API
- We expose register rest api
```
URL: http://localhost:8080/api/register
Method: POST
Body: {
      	"email":"linh@gmail.com",
      	"firstName":"linh",
      	"lastName":"dang",
      	"gender":"MALE",
      	"dateOfBirth":"1998-02-02",
      	"phoneNumber":"0872786565"
      }
      
Reponse: 
----------------Success----------------
{
    "header": {
        "success": true,
        "statusCode": "200",
        "statusMessage": "OK"
    },
    "body": {
        "phoneNumber": "0772786565",
        "firstName": "linh",
        "lastName": "dang",
        "dateOfBirth": "1998-02-02T00:00:00.000+0000",
        "gender": "MALE",
        "email": "linh@gmail.com"
    }
}
----------------Failure----------------
{
    "header": {
        "success": false,
        "statusCode": "500",
        "statusMessage": "Internal Server Error"
    },
    "body": {
        "errors": [
            {
                "errorCode": "EMAIL_IS_EXITS",
                "errorMessage": "EMAIL_IS_EXITS"
            }
        ]
    }
}

```

### Live demo
- FrontEnd : [https://pure-headland-60558.herokuapp.com/](https://pure-headland-60558.herokuapp.com/) 
- BackEnd : [https://sleepy-shelf-66824.herokuapp.com/](https://sleepy-shelf-66824.herokuapp.com/) 