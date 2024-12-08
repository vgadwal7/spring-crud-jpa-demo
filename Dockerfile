# Use OpenJDK as base image
FROM openjdk:17-jdk-slim

# Copy the JAR file
COPY target/spring-crud-jpa-demo-1.jar app.jar

# Expose the application's port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]