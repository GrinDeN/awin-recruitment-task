FROM openjdk:11
WORKDIR /opt/app
ARG JAR_FILE=target/transactions-0.0.2-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]