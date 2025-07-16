FROM openjdk:17-jdk-alpine

RUN apk add --no-cache bash maven

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY . .

RUN chmod +x mvnw

EXPOSE 8084

# RUN ./mvnw clean package -DskipTests

CMD ["./mvnw", "spring-boot:run"]