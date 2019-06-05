FROM openjdk:10-jre-slim
COPY ./target/turbine-dashboard-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT exec java -jar /app.jar monsterturbine