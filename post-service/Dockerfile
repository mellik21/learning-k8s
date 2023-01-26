FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/post-service-1.0.2.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","app.jar"]
