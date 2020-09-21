package com.maodun.controller.impl;

import com.maodun.controller.Demo;
import org.springframework.stereotype.Service;

/**
 * @author tongjian
 * @date 2020/7/7 15:02
 */
@Service
public class DemoImpl implements Demo {
    @Override
    public void hello() {
        System.out.println("hello world demo1");
    }
}
