FROM openjdk:8-jdk-alpine

ADD build/libs/*.jar microservice.jar

ENTRYPOINT ["java", "-jar", "microservice.jar"]