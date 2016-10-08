FROM java:8
ADD inventory.jar inventoryservice.jar
EXPOSE 8084
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","inventoryservice.jar"]

