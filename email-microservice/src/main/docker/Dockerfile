FROM java:8
ADD email.jar emailservice.jar
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","emailservice.jar"]

