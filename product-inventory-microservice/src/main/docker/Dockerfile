FROM java:8
ADD inventory-1.0.jar inventory.jar
EXPOSE 8084
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","inventory.jar"]

