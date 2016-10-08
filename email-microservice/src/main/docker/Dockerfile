FROM java:8
ADD email-0.0.1-SNAPSHOT.jar emailservice.jar
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","emailservice.jar"]

