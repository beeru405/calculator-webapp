FROM tomcat:latest

COPY target/webapp-0.2.war /usr/local/tomcat/webapps/
