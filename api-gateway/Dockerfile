FROM openjdk:10-jre-slim
COPY ./target/api-gateway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8084
ENTRYPOINT exec java -jar /app.jar monsterapi
