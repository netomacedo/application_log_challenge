package com.example.logs_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync/*annotation which enables Spring’s ability to run Asynchronous methods in a background thread poo*/
public class LogsChallengeApplication {

    public static void main(String[] args) {
//        System.out.println(args[0]);
        SpringApplication.run(LogsChallengeApplication.class, args);

    }

    /*maximum of 5 threads should run concurrently and
    the queue size is set to 1000*/
    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(1000);
        executor.setThreadNamePrefix("LOGAsync-");
        executor.initialize();
        return executor;
    }

}

