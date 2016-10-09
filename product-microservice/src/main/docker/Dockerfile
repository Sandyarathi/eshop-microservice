FROM java:8
ADD product.jar productservice.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","productservice.jar"]

