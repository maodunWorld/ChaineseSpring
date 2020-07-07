package com.maodun.bean;

import com.maodun.service.Demo;
import com.maodun.service.Demo2;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
public class DemoQuartzBean extends QuartzJobBean {

//    private Demo demo;
//    private Demo2 demo2;
//    public DemoQuartzBean(Demo demo, Demo2 demo2) {
//        this.demo = demo;
//        this.demo2 = demo2;
//    }

    @Autowired
    private Demo demo;
    @Autowired
    private Demo2 demo2;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("this is quartzBean Task");
        demo.hello();
        demo2.hello();
    }
}
