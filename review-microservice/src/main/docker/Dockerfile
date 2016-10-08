FROM java:8
ADD ReviewMicroservice-0.0.1-SNAPSHOT.jar reviewservice.jar
EXPOSE 8085
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","reviewservice.jar"]

