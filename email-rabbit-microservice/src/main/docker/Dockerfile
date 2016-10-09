FROM java:8
ADD email-1.0.jar email.jar
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","email.jar"]

