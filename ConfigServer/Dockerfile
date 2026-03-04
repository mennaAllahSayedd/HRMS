#FROM eclipse-temurin:21-jdk
#
#ARG JAR_FILE=target/configserver-0.0.1-SNAPSHOT.jar
#
#COPY ${JAR_FILE} app.jar
#
#ENTRYPOINT ["java","-jar","/app.jar"]
#

FROM eclipse-temurin:21-jre

WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]