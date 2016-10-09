FROM java:8
ADD customer-1.0.jar customerservice.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","customerservice.jar"]

