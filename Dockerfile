FROM openjdk:11
WORKDIR /opt/user-management-api
ARG JAR_FILE=um-webapp/target/*.jar
COPY ${JAR_FILE} um-webapp.jar
ENTRYPOINT ["java","-jar","um-webapp.jar"]
