# Project for a Bank Challenge using Spring Boot and Hexagonal Architecture


[![Get Your Hands Dirty On Clean Architecture](https://reflectoring.io/images/gyhdoca/hexagonal-architecture_hu6764515d7030d45af6f7f498c79e292b_50897_956x0_resize_box_3.png)](https://reflectoring.io/book)

All my code on [Github](https://github.com/luisfelipebarrera/java-clean-architecture-banking).

It implements a domain-centric "Hexagonal" approach of a common web application with Java and Spring Boot. 

* BaseDatos.sql file, contains structure and sample data.

## Referenced Articles

* [Hexagonal Architecture with Java and Spring](https://reflectoring.io/spring-hexagonal/)
* [Github](https://github.com/thombergs/buckpal)

## Prerequisites

* Postgres Database 14.6
* JDK 17
* this project uses Lombok, so enable annotation processing in your IDE
* Add environment variables in your IDE:
  *   dbhost=localhost

## Test integrity
* Run commands:
  
| Maven commands |
|----------------|
|$ mvn clean package         |
|$ java -jar target/banking-0.0.1-SNAPSHOT.jar         |


## Docker release

To build and run docker-with-spring-profile:

| $  docker build -f docker/Dockerfile --tag=java-mybank-account-transfer:latest . |
|----------------------------------------------------------------------------------|

Run docker image:

| $  docker run --name java-mybank-account-transfer -p8080:8080 java-mybank-account-transfer:latest  |
|-----|

To run with environment variables (or a specific profile):

|docker run --name java-mybank-account-transfer -p8080:8080 -e "dbhost=172.18.0.2" java-mybank-account-transfer:latest     |
|-----|

* [Creating Docker Images with Spring Boot](https://www.baeldung.com/spring-boot-docker-images)


