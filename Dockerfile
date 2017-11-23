#Base JAVA image
FROM maven:latest

#Create App directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

#Install App dependencies
COPY . /usr/src/app
RUN cd /usr/src/app/ && mvn compile package -Dmaven.test.skip=true && cp target/mediator-0.0.1-SNAPSHOT.jar /usr/src/app

EXPOSE 8081

CMD java -jar -Dserver.port=8081 mediator-0.0.1-SNAPSHOT.jar
