FROM openjdk:8

MAINTAINER Lavender Irons "lavenderirons@gmail.com" 

WORKDIR /usr/local/bin

ADD target/makeup-app.jar . 

ENTRYPOINT ["java", "-jar", "makeup-app.jar"]



