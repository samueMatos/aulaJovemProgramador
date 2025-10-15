#maquina virtual
FROM maven:3.9.8-eclipse-temurin-21-jammy as builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests


# Rodar o codigo

FROM eclipse-temurin:21-jre-jammy

COPY --from=builder /app/target/aulaapijovemprogramador-0.0.1-SNAPSHOT.jar /app.jar


EXPOSE 8080

ENTRYPOINT ["java", "-jar","/app.jar"]