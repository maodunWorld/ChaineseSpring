package com.maodun.redis;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.RedisTemplate;

@DataRedisTest
public class Create {
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    void test1() {

    }

}
