package com.maodun.controller;

import com.maodun.ant.Action;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tongjian
 * @date 2020/9/16 9:10
 */
@Service
@Slf4j
public class DemoService {

    @Action(name = "测试这个日志")
    public void demo() {
        log.info("this is demo");
    }

    public String demo2(String str) {
        System.out.println("this is demo2" + str);
        return str;
    }

    public String demo3() {
        return "hello";
    }
}
