FROM openjdk:19-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} management.jar
ENTRYPOINT ["java","-jar","/management.jar"]

