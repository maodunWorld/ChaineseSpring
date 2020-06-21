package com.maodun.conf;

import com.maodun.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConf {
    /**
     * 1 创建Job对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        final JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(QuartzDemo.class);
        return jobDetailFactoryBean;
    }

    /**
     * 2 创建Trigger对象
     */
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        final SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
        simpleTriggerFactoryBean.setRepeatInterval(2000);
        simpleTriggerFactoryBean.setRepeatCount(5);
        return simpleTriggerFactoryBean;
    }

    /**
     * 3 创建Scheduler对象
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        final SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean().getObject());
        return schedulerFactoryBean;
    }
}



