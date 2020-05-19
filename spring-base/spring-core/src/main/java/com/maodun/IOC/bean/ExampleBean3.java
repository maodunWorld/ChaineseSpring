package com.maodun.IOC.bean;

import lombok.extern.log4j.Log4j2;

/**
 * @author maodunWorld
 * @date 2020/5/19 11:10
 */
@Log4j2
public class ExampleBean3 {
    private void init() {
        log.info("this is a bean init method");
    }

    private void close() {
        log.info("this is a bean close method");
    }
}
