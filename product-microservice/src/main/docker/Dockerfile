FROM java:8
ADD product-microservice-0.0.1.jar productservice.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","productservice.jar"]

