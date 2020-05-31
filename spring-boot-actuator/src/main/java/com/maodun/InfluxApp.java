package com.maodun;

import com.maodun.metrics.MyCounter;
import com.maodun.metrics.MyCounterV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/14 16:55
 */
@SpringBootApplication
@Slf4j
@RestController
public class InfluxApp implements CommandLineRunner {

    @Autowired
    private MyCounter myCounter;

    @Autowired
    private MyCounterV2 myCounterV2;

    public static void main(String[] args) {
        SpringApplication.run(InfluxApp.class, "--spring.profiles.active=influx");
    }

    @Override
    public void run(String... args) throws Exception {
//        while (true) {
//            myCounterV2.add();
//            Thread.sleep(500);
//            System.out.println(myCounterV2.get());
//
//        }
//        int time = 0;
//        for (int i = 0; i < 100; i++) {
//            myCounter.counterAdd();
//        }
//        while (true) {
//            Thread.sleep(1000);
//            time++;
//            System.out.println(myCounter.getCount());
//            System.out.println(time);
//        }
    }
}
