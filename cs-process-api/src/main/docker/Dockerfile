FROM openjdk:8-jre-alpine
RUN mkdir app
COPY creditscore-process-api.jar app/cs-app.jar
WORKDIR app
RUN "pwd"
RUN "ls"
EXPOSE 8085
ENTRYPOINT ["java","-jar", "cs-app.jar"]