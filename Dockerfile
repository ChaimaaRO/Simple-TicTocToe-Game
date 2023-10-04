FROM openjdk:17-oracle
COPY target/TicTacToe-1.0-SNAPSHOT.jar /app.jar
EXPOSE 8089
CMD ["java", "-cp", "/app.jar", "org.example.Main"]