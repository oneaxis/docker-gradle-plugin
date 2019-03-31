FROM gradle:5.3.0-jdk11-slim 
USER root 
WORKDIR /builder 
COPY  . .
RUN ["gradle","build"]

FROM openjdk:11.0-jre-slim 
WORKDIR /app 
COPY --from=0 /builder/build/libs/app.jar .
EXPOSE 9090 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar"]