FROM openjdk:14-jdk-alpine
WORKDIR /app
COPY target/Greeting-1.0-SNAPSHOT.jar /app/Greeting-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Greeting-1.0-SNAPSHOT.jar"]
