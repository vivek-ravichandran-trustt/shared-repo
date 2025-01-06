# Use a base image with JDK
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file to the container
COPY target/ReportingService-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on
EXPOSE 9093

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
