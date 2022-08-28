FROM maven:3.8-openjdk-17-slim as build

WORKDIR /tmp/dockerapp

COPY ./pom.xml .
COPY ./src/ ./src/
RUN mvn clean package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jdk-jammy

COPY --from=build /tmp/dockerapp/target/*.jar /app/app.jar

WORKDIR /app
CMD ["java", "-Ddebug", "-jar", "/app/app.jar"]
