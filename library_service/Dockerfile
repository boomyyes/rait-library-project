# Stage 1: Build the application using Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
# Copy the Maven project files
COPY pom.xml .
COPY .mvn/ .mvn
COPY mvnw .
COPY mvnw.cmd .
# Download dependencies (this layer is cached)
RUN mvn dependency:go-offline -B
# Copy the rest of the source code
COPY src ./src
# Package the application
RUN mvn package -DskipTests

# Stage 2: Create the final runtime image
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# Copy the built JAR file from the build stage
COPY --from=build /app/target/library_service-0.0.1-SNAPSHOT.jar app.jar
# Expose the port the application runs on (8080 by default)
EXPOSE 8080
# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]