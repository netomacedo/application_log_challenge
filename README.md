Simple application to process log files and persist in H2 DB.

[Java 8]: I used Java8 to develop the backend. You will only need to run those command (from CMD) to start the application.

#BUILD AND GENERATE JAR FILE:  gradlew build

#YOU CAN GET THE JAR file in /build/libs/project.jar

#RUN APPLICATION USING your .json file by parameter: java -jar logs_challenge-0.0.1-SNAPSHOT.jar log.json

#CHECK THE RESULT IN DATABASE ACCESSING THE URL: http://localhost:8080/h2-console user: sa password: password
