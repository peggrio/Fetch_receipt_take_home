# start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

#Information around who maintains the image
MAINTAINER PeizhenLiao

#Add the application's jar to the image
COPY target/receipt-0.0.1-SNAPSHOT.jar receipt-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/receipt-0.0.1-SNAPSHOT.jar"]