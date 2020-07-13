package com.maodun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tongjian
 * @date 2020/7/10 11:38
 */
@SpringBootApplication
public class PromethuesPracticeApp {
    public static void main(String[] args) {
        SpringApplication.run(PromethuesPracticeApp.class, "--spring.profiles.active=practice");
    }
}
