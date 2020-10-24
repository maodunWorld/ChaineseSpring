package com.maodun;

import com.maodun.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EmbedDataBaseApp {
    @Autowired
    private TestDao testDao;


    public static void main(String[] args) {
        SpringApplication.run(EmbedDataBaseApp.class, args);
    }
}
