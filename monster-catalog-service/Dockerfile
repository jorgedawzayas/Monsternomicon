FROM openjdk:10-jre-slim
COPY ./target/monster-catalog-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT exec java -jar /app.jar monstercatalog