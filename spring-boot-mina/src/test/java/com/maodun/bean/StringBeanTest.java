package com.maodun.bean;

import org.junit.jupiter.api.Test;

/**
 * @author tongjian
 * @date 2020/5/27 9:18
 */
class StringBeanTest {

    @Test
    void cheng2() {
        StringBeanImpl stringBean = new StringBeanImpl();
        System.out.println(stringBean.cheng2("haha"));
    }
}