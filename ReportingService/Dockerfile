## TrainingService/Dockerfile
#FROM eclipse-temurin:21-jdk
#
## اسم الـ JAR اللي اتعمله package في target
#ARG JAR_FILE=target/*.jar
#
## انسخ الملف من جهازك للصورة
#COPY ${JAR_FILE} app.jar
#
## الطريقة اللي الصورة هتشغل بيها المشروع
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]