FROM eclipse-temurin:17-jdk-focal
WORKDIR /service-backend
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY  src ./src
CMD ["./mvnw", "spring-boot:run"]