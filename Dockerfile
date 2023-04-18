FROM openjdk:20
ARG JAR_FILE=target/*.jar
COPY ./target/demo-1.0.jar app.jar
EXPOSE 7171
ENTRYPOINT ["java", "-jar", "/app.jar"]