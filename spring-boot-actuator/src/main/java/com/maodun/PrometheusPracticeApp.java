package com.maodun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author tongjian
 * @date 2020/7/10 11:38
 */
@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.maodun.metrics.*"))
public class PrometheusPracticeApp {
    public static void main(String[] args) {
        SpringApplication.run(PrometheusPracticeApp.class, "--spring.profiles.active=practice");
    }
}
