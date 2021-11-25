FROM openjdk:8-jdk-alpine
EXPOSE 8181
VOLUME /tmp
ARG JAR_FILE=target/api-spring-boot.jar
COPY target/*.jar api-spring-boot.jar
ENTRYPOINT ["java","-jar","api-spring-boot.jar"]