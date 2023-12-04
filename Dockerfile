FROM maven:3-openjdk-18-slim
EXPOSE 8080
WORKDIR /app
COPY ./ /app
RUN mvn clean package
ENTRYPOINT "java -jar controlAPI-0.0.1-SNAPSHOT.jar"