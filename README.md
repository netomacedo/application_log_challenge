Simple application to process log files Async and persist in H2 DB.

[Java 8]: I used Java8 to develop the backend. You will only need to run those command (from CMD) to start the application.

#BUILD AND GENERATE JAR FILE:  gradlew build

#YOU CAN GET THE JAR FILE IN /build/libs/project_name.jar

#TO RUN UNIT TESTS USE: gradlew test --tests com.example.logs_challenge.LogsChallengeApplicationTests

#RUN APPLICATION USING YOUR PATH WHERE YOUR .JSON FILE IS: java -jar logs_challenge-0.0.1-SNAPSHOT.jar path/log.json

#CHECK THE RESULT IN DATABASE ACCESSING THE URL: http://localhost:8080/h2-console user: sa password: password
