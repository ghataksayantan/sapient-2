#FROM maven:3-jdk-7-alpine as builder
FROM tomcat:8.0-jre7-alpine as runner
LABEL maintainer="varun.singhal@amadeus.com"

WORKDIR /app

# Copy files. We don't copy "." to avoid re-building the image every time
#ADD src src
#ADD settings.xml .
#ADD pom.xml .

# Build .war with 1 thread per CPU core
#RUN mvn -T 1C install --settings settings.xml

# Switch to tomcat image
#FROM tomcat:8.0-jre7-alpine as runner

# Copy .war into tomcat as the ROOT webapp
RUN rm -rf $CATALINA_HOME/webapps/*
#COPY --from=builder /app/target/hidbm.war $CATALINA_HOME/webapps/ROOT.war
COPY hidbm-pdt-1.0.12.war $CATALINA_HOME/webapps/ROOT.war

EXPOSE 8080