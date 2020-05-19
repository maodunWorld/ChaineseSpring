package com.maodun.IOC.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author maodunWorld
 * @date 2020/5/19 11:05
 */
@Slf4j
public class ExampleBean2 implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("this is a bean init method base Spring Interface");
    }

    @Override
    public void destroy() throws Exception {
        log.info("this is a bean destroy method base Spring Interface");
    }
}
