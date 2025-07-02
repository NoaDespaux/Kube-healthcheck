# Use a lightweight OpenJDK image
FROM eclipse-temurin:17-jre

# Copy the built jar file
COPY target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]

