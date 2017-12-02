FROM razikus/jboss-with-maven:latest

ENV MYSQL_HOST="localhost"
ENV MYSQL_PORT=3306
ENV MYSQL_USER="igi"
ENV MYSQL_PASSWORD="scores"


USER root
RUN mkdir -p /sources/igi/
RUN chown -R jboss:jboss /sources/igi/

USER jboss
ADD project /sources/igi/
RUN \
	cd /sources/igi/ && mvn clean install


ADD customization /opt/jboss/wildfly/customization/
USER root
RUN cp /sources/igi/target/IgiAdventures.war /opt/jboss/wildfly/customization/
USER jboss
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin123 --silent

CMD ["/opt/jboss/wildfly/customization/execute.sh"]

