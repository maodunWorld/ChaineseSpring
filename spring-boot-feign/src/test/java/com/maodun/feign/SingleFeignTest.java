package com.maodun.feign;

import com.maodun.model.Pay;
import feign.Feign;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

class SingleFeignTest {

    @Test
    void getP() {
        SingleFeign target = Feign.builder().target(SingleFeign.class, "http://localhost:1888/api");
        target.getP("kjkds");
    }

    @Test
    void getP1() {
        SingleFeign target = Feign.builder().target(SingleFeign.class, "http://localhost:1888/api");
        Pay pay = new Pay();
        pay.setStr1("hello str1");
        pay.setStr2("hello str2");
        target.getP1(pay);
    }

    @Test
    void getFrom() {
        SingleFeign target = Feign.builder().target(SingleFeign.class, "http://localhost:1888/api");
        LinkedHashMap<String, Object> stringObjectLinkedHashMap = new LinkedHashMap<>();
        stringObjectLinkedHashMap.put("str", "hello");
        String from = target.getFrom(stringObjectLinkedHashMap);
        System.out.println(from);
    }

    @Test
    void getHeader() {
        SingleFeign target = Feign.builder().target(SingleFeign.class, "http://localhost:1888/api");
        String testheader = target.getHeader("testheader");
        System.out.println(testheader);
    }

    @Test
    void postBody() {
        SingleFeign target = Feign.builder().target(SingleFeign.class, "http://localhost:1888/api");
        String s = target.postBody("hello1", "hello2");
        System.out.println(s);
    }

    @Test
    void postForm() {
        SingleFeign target = Feign.builder().target(SingleFeign.class, "http://localhost:1888/api");
        LinkedHashMap<String, Object> stringObjectLinkedHashMap = new LinkedHashMap<>();
        stringObjectLinkedHashMap.put("testform", "test form str");
        String s = target.postForm(stringObjectLinkedHashMap);
        System.out.println(s);
    }
}
