dockerfile
CopyEdit
FROM openjdk:21-jdk-slim

RUN apt-get update && apt-get install -y maven

WORKDIR /usr/src/cucumber-framework

COPY . .

CMD ["mvn", "clean", "verify"]
