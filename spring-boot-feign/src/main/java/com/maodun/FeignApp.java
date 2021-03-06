package com.maodun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignApp.class, "--spring.profiles.active=feign");
    }
}
