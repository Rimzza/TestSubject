FROM maven:3.9.11-eclipse-temurin-17 AS builder
WORKDIR /usr/src/
COPY . .
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /usr/src/target/*.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]