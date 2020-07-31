package com.maodun.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tongjian
 * @date 2020/7/31 11:15
 */
@Service
@Slf4j
public class Demo {

    public void print() {
        log.info("this is log");
        System.out.println("this is sout");
    }
}
