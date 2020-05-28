package com.maodun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tongjian
 * @date 2020/5/27 17:06
 */
@SpringBootApplication
public class PrometheusApp {
    public static void main(String[] args) {
        SpringApplication.run(PrometheusApp.class, "--spring.profiles.active=prometheus");
    }
}
