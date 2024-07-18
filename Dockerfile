FROM amazoncorretto:21
LABEL org.opencontainers.image.authors="sanga.lawalata@gmail.com"
WORKDIR /app
COPY target/testLoginApp-example.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","testLoginApp-example.jar"]