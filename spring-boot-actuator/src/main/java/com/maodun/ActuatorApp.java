package com.maodun;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/14 16:55
 */
@SpringBootApplication
public class ActuatorApp {
    public static void main(String[] args) {
        SpringApplication.run(ActuatorApp.class);
    }
}
