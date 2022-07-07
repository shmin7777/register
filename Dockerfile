FROM openjdk:8-jdk-alpine
ADD register-0.0.1-SNAPSHOT.jar register.jar
ENTRYPOINT ["java", "-jar", "register.jar"]
ENV TZ Asia/Seoul
