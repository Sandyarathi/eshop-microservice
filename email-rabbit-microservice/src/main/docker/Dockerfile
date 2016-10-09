FROM java:8
ADD email-1.0.jar.jar email.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","email.jar"]

