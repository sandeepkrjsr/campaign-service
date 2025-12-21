FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/campaign-service-0.0.1-SNAPSHOT.jar campaign-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "campaign-service.jar"]