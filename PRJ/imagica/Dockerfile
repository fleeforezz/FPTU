# Base image with OpenJDK 8
   FROM openjdk:8-jdk-slim

   # Set environment variables
   ENV CATALINA_HOME /opt/tomcat
   ENV PATH $CATALINA_HOME/bin:$PATH

   # Install necessary packages
   RUN apt-get update && \
       apt-get install -y wget && \
       apt-get clean && \
       rm -rf /var/lib/apt/lists/*

   # Install Apache Tomcat 8.0.27.0
   RUN wget https://archive.apache.org/dist/tomcat/tomcat-8/v8.0.27/bin/apache-tomcat-8.0.27.tar.gz -O /tmp/tomcat.tar.gz && \
       mkdir -p $CATALINA_HOME && \
       tar -xzf /tmp/tomcat.tar.gz --strip-components=1 -C $CATALINA_HOME && \
       rm /tmp/tomcat.tar.gz

   # Copy jdbc driver to apache tomcat
   COPY ./lib/sqljdbc42.jar $CATALINA_HOME/lib/

   # Copy the WAR file of your web application to the Tomcat webapps directory
   COPY ./dist/imagica.war $CATALINA_HOME/webapps/

   # Expose the default Tomcat port
   EXPOSE 8080

   # Set the working directory
   WORKDIR $CATALINA_HOME

   # Set the entry point for Tomcat
   CMD ["catalina.sh", "run"]