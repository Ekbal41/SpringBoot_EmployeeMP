FROM maven:3.8.6-eclipse-temurin-19 AS build
COPY . .
RUN mvn clean package

FROM openjdk:19-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} management.jar
ENTRYPOINT ["java","-jar","/management.jar"]

