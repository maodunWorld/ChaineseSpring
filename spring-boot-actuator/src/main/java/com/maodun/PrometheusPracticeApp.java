package com.maodun;

import com.maodun.metrics.MyGauge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tongjian
 * @date 2020/7/10 11:38
 */
@SpringBootApplication
@Slf4j
public class PrometheusPracticeApp implements CommandLineRunner {
    @Autowired
    private MyGauge myGauge;

    public static void main(String[] args) {
        SpringApplication.run(PrometheusPracticeApp.class, "--spring.profiles.active=practice");
    }

    @Override
    public void run(String... args) throws Exception {
        double v = MyGauge.myGauge.doubleValue();
        log.info("Start myGauge Value {} ", v);
    }
}
