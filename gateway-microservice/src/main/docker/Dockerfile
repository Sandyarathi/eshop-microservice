FROM java:8
ADD gateway-1.0.jar gateway.jar
EXPOSE 8086
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","gateway.jar"]

