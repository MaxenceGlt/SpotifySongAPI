FROM eclipse-temurin:17.0.6_10-jdk
WORKDIR /app
COPY target/MoviesApp.jar /app/myapp.jar

CMD ["java", "-jar", "/app/myapp.jar"]