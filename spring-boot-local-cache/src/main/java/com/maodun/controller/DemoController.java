package com.maodun.controller;

import com.maodun.pojo.Demo;
import com.maodun.udf.anatation.UdfEvict;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tongjian
 * @date 2020/9/21 16:38
 */
@RestController
@Slf4j
@CacheConfig(cacheNames = "demo")
public class DemoController {
    public static final Map<String, Demo> MAP_CACHE = new ConcurrentHashMap();

    @CachePut(key = "#demo.name")
    @PostMapping("/demo")
    public Demo insert(Demo demo) {
        log.info(demo.toString());
        MAP_CACHE.put(demo.getName(), demo);
        return demo;
    }

    @Cacheable
    @GetMapping("/demo")
    public Demo get(String name) {
        log.info("this get Method {}", name);
        return MAP_CACHE.get(name);
    }

    @CacheEvict(allEntries = true)
    @DeleteMapping("/demo")
    public boolean deleteAll() {
        log.info("this is evict all anatation");
        return true;
    }

    @UdfEvict
    @DeleteMapping("/demoUdf")
    public void udfAntCache() {
        log.info("this is udf anatation, it will evict all cache");
    }

}
