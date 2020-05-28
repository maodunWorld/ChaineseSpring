package com.maodun;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/14 16:55
 */
@SpringBootApplication
@RestController
public class InfluxApp {
    @Autowired
    private MeterRegistry meterRegistry;

    public static void main(String[] args) {
        SpringApplication.run(InfluxApp.class, "--spring.profiles.active=influx");
    }

    @GetMapping("/metrics")
    public ResponseEntity getMetrics() {
        return null;
    }

    @PostMapping("/metrics")
    public ResponseEntity addMetrics() {
        return null;
    }
}
