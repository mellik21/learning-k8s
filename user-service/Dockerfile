FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/user-service-1.0.1.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","app.jar"]
