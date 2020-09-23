package com.maodun;

import com.maodun.controller.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tongjian
 * @date 2020/9/16 9:09
 */
@SpringBootApplication
public class AOPApp implements CommandLineRunner {
    @Autowired
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(AOPApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(demoService.demo3());
    }
}
