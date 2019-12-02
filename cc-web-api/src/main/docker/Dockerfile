FROM openjdk:8-jre-alpine
RUN mkdir app
COPY cc-web-api.jar app/cc-web-api.jar
WORKDIR app
RUN "pwd"
RUN "ls"
EXPOSE 8085
ENTRYPOINT ["java","-jar", "cc-web-api.jar"]