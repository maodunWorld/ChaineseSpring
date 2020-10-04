package com.maodun;

import com.maodun.pojo.Demo;
import com.maodun.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class TransactionApp implements CommandLineRunner {
    @Autowired
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(TransactionApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Demo demo = new Demo();
        demo.setId(UUID.randomUUID().toString());
        demo.setName("haha");
        demo.setAge(23l);
        demo.setHeigh(157l);
        demoService.saveDemo1(demo);
    }
}
