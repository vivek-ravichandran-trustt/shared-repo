# Use a base image with JDK
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file to the container
COPY target/creditCard-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]


#version: '3.8'
#
#services:
#  # Kafka Broker
#  kafka:
#    image: wurstmeister/kafka:latest
#    environment:
#      KAFKA_ADVERTISED_LISTENERS: INSIDE-KAFKA:9093
#      KAFKA_LISTENER_SECURITY_PROTOCOL: PLAINTEXT
#      KAFKA_LISTENERS: INSIDE-KAFKA:9093
#      KAFKA_LISTENER_INTERFACE: INSIDE-KAFKA
#      KAFKA_LISTENER_NAME: INSIDE-KAFKA
#      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
#      KAFKA_LISTENER_PORT: 9093
#    ports:
#      - "9093:9093"
#    networks:
#      - app-network
#
#  # Zookeeper (required by Kafka)
#  zookeeper:
#    image: wurstmeister/zookeeper:latest
#    environment:
#      ZOOKEEPER_CLIENT_PORT: 2181
#    ports:
#      - "2181:2181"
#    networks:
#      - app-network
#
#  # Spring Boot Application
#  creditcard-app:
#    build:
#      context: .
#      dockerfile: Dockerfile
#    ports:
#      - "8080:8080"
#    environment:
#      SPRING_KAFKA_BOOTSTRAP-SERVERS: kafka:9093
#    depends_on:
#      - kafka
#    networks:
#      - app-network
#
#networks:
#  app-network:
#    driver: bridge
