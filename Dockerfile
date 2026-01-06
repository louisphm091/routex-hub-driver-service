FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /usr/src/app
COPY . .
RUN mvn -B package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /usr/src/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]