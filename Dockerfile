# Build stage
FROM maven:3.8-jdk17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:resolve
COPY . .
RUN mvn -B clean package