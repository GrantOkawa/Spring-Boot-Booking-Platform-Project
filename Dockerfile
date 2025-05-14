# Use official Java 17 image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the app's code into the container
COPY . /app

# Grant execute permission to Maven wrapper
RUN chmod +x ./mvnw

# Build the Spring Boot app inside the container
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (used by Spring Boot)
EXPOSE 8080

# Run the packaged jar
CMD ["java", "-jar", "target/assignment2-0.0.1-SNAPSHOT.jar"]