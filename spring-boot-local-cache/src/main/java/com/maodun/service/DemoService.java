package com.maodun.service;

import com.maodun.pojo.Demo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tongjian
 * @date 2020/9/21 16:38
 */
@Service
@Slf4j
public class DemoService {
    public static final Map<String, Demo> MAP_CACHE = new ConcurrentHashMap();

    public String insert(Demo demo) {
        log.info(demo.toString());
        MAP_CACHE.put(demo.getName(), demo);
        return demo.getName();
    }

    public Long get(String name) {
        log.info("this get Method {}", name);
        return MAP_CACHE.get(name).getKey();
    }

    public boolean deleteAll() {
        return true;
    }

    public boolean evictCache() {
        return true;
    }

    public void multiCacheOperation() {

    }
}
