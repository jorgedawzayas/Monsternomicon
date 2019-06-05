FROM openjdk:10-jre-slim
COPY ./target/discovery-server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8761
ENTRYPOINT exec java -jar /app.jar monsterdiscovery