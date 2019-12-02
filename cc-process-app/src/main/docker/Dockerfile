FROM openjdk:8-jre-alpine
RUN mkdir app
COPY cc-app-process-api.jar app/cc-app.jar
WORKDIR app
RUN "pwd"
RUN "ls"
EXPOSE 8085
ENTRYPOINT ["java","-jar", "cc-app.jar"]