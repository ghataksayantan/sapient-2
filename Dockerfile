FROM tomcat:9.0-jdk8 as runner
LABEL maintainer="sayantan"

WORKDIR /app
RUN rm -rf $CATALINA_HOME/webapps/*
COPY /target/sapient-0.0.1-SNAPSHOT $CATALINA_HOME/webapps/ROOT.war

EXPOSE 8080