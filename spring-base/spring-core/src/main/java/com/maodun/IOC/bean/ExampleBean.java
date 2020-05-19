package com.maodun.IOC.bean;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author maodunWorld
 * @date 2020/5/19 10:59
 */
@Slf4j
public class ExampleBean {
    private String exampleField;

    public String getExampleField() {
        return exampleField;
    }

    public void setExampleField(String exampleField) {
        this.exampleField = exampleField;
    }

    @PostConstruct
    private void init() {
        log.info("this is exampleBean init Method, u can int some resource,like redisClient");
    }

    @PreDestroy
    private void close() {
        log.info("this is bean destroy method, u can close some resource,lick mysql-connection-pool, redis-client");
    }
}
