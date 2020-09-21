package com.maodun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author tongjian
 * @date 2020/9/21 16:30
 */
@SpringBootApplication
@EnableCaching
public class LocalCacheApp {
    public static void main(String[] args) {
        SpringApplication.run(LocalCacheApp.class, args);
    }
}
