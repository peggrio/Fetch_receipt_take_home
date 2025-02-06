# Stage 1: Build the application inside a Maven container
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

# Stage 2: Create a runtime image
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar receipt.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","receipt.jar"]