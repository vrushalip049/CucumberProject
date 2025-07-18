FROM maven:3.8-jdk17
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:resolve
COPY . .
CMD ["mvn", "clean", "test"]