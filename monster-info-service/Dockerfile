FROM openjdk:10-jre-slim
COPY ./target/monster-info-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT exec java -jar /app.jar monsterinfo