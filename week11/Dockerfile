FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/api-0.0.1-SNAPSHOT.jar
COPY target/*.jar api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","api-0.0.1-SNAPSHOT.jar"]