package com.maodun.feign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("feign")
public class SpringBootFeignTest {

    @Autowired
    private SpringBootFeign springBootFeign;

    @Test
    void test1() {

    }
}
