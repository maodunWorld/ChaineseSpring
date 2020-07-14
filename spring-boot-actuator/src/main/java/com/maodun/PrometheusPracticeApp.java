package com.maodun;

import com.maodun.metrics.MyGauge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Thread.sleep;

/**
 * @author tongjian
 * @date 2020/7/10 11:38
 */
@SpringBootApplication
@Slf4j
public class PrometheusPracticeApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PrometheusPracticeApp.class, "--spring.profiles.active=practice");
    }

    @Override
    public void run(String... args) throws Exception {
        double v = MyGauge.myGauge.doubleValue();
        log.info("Start myGauge Value {} ", v);
        new Thread(() -> {
            while (true) {
                try {
                    sleep(10000);
                    MyGauge.myGauge.set(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        while (true) {
            sleep(1000);
            int i = MyGauge.myGauge.incrementAndGet();
            System.out.println("Now gauge value is {}" + i);
        }
    }
}
