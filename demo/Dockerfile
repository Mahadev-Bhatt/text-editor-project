# Use a lightweight JDK image
FROM openjdk:21-jdk-slim

# Add a volume to store logs
VOLUME /tmp

# Copy the jar file
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
