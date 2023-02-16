# To build and run docker-with-spring-profile:
#
# docker build -f docker/Dockerfile --tag=java-mybank-account-transfer:latest .
# docker run --name java-mybank-account-transfer -p8080:8080 java-mybank-account-transfer:latest
#
# To run with profiles:
# docker run --name java-mybank-account-transfer -p8080:8080 -e "dbhost=172.18.0.2" java-mybank-account-transfer:latest
#
# https://www.baeldung.com/spring-boot-docker-images

FROM openjdk:17-alpine
EXPOSE 8080
ARG JAR_FILE=target/banking-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]