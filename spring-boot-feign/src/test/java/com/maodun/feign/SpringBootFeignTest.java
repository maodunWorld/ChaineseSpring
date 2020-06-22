package com.maodun.feign;

import com.maodun.FeignApp;
import com.maodun.model.Pay;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = FeignApp.class)
@ActiveProfiles("feign")
@Slf4j
public class SpringBootFeignTest {

    @Autowired
    private SpringBootFeign springBootFeign;

    @Test
    void test1() {
        String s = springBootFeign.get("hello", "hello");
        log.info(s);
    }

    @Test
    void test2() {
        Pay pay = new Pay();
        pay.setStr1("hello");
        pay.setStr2("hello");
        String post = springBootFeign.post(pay);
        log.info(post);
    }
}
