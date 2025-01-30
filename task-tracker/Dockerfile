FROM eclipse-temurin:17
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY ./target/*.jar app.jar
EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]