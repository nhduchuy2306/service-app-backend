FROM eclipse-temurin:17-jdk-focal
WORKDIR /service-backend
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN sed -i 's/\r$//' mvnw
RUN chmod +x mvnw
RUN /bin/sh mvnw dependency:resolve
COPY  src ./src
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=stag"]