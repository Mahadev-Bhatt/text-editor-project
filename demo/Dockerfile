# Stage 1: Build the jar using Maven with JDK 17
FROM maven:3.8.6-jdk-17 AS build

WORKDIR /app

# Copy Maven config and source code
COPY pom.xml .
COPY src ./src

# Build the project (skip tests to speed up if needed)
RUN mvn clean package -DskipTests

# Stage 2: Run the jar with a lightweight JDK 17 runtime
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your app uses (default 8080)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
