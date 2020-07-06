package com.maodun;

import com.maodun.bean.DemoQuartzBean;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@SpringBootApplication
@EnableScheduling
public class SchedulerApp implements CommandLineRunner {
    @Autowired
    private Scheduler scheduler;

    public static void main(String[] args) {
        SpringApplication.run(SchedulerApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        JobDetail demoJob = newJob(DemoQuartzBean.class)
                .withIdentity("k1", "g1")
                .build();
        final SimpleTrigger simpleTrigger = newTrigger()
                .withIdentity("k2", "g1")
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(10))
                .build();

        scheduler.scheduleJob(demoJob, simpleTrigger);
    }
}
