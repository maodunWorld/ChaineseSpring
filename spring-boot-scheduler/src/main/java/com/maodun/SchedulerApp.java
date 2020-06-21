package com.maodun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulerApp {
    public static void main(String[] args) {
        SpringApplication.run(SchedulerApp.class, args);
    }
}
