Simple application to process log files and persist in H2 DB.

Backend
Before you can build this project, you must install and configure the following dependencies on your machine:

[Java 8]: I used Java8 to develop the backend.
You will only need to run this command (from CMD) to start the application.

#GENERATE JAR FILE
gradlew spring-boot:run

#RUN APPLICATION USING .json parameter
java -jar logs_challenge-0.0.1-SNAPSHOT.jar log.json

#CHECK THE RESULT IN DATABASE ACCESSING THE URL:
http://localhost:8080/h2-console
user: sa
password: password
