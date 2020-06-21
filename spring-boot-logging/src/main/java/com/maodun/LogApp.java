package com.maodun;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LogApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(LogApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("this is debug");
        log.trace("this is trace");
        log.info("this is info");
        log.warn("this is warn");
        log.error("this is error");
    }
}
