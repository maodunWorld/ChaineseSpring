package com.maodun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tongjian
 * @date 2020/9/21 16:30
 */
@SpringBootApplication
@EnableCaching
public class LocalCacheApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(LocalCacheApp.class, args);
    }

    @Autowired
    private CaffeineCacheManager caffeineCacheManager;

    @Override
    public void run(String... args) throws Exception {
        Cache test = caffeineCacheManager.getCache("test");
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("kjk", "kjk");
        test.put("test", stringStringHashMap);

        Map<String, String> test1 = test.get("test", Map.class);

        String kjk = test1.get("kjk");
        System.out.println(kjk);
    }
}
