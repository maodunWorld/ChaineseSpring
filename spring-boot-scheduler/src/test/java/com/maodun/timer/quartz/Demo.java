package com.maodun.timer.quartz;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


@Slf4j
public class Demo {

    public static void main(String[] args) throws SchedulerException {

        JobDetail job = newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        final Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.scheduleJob(job, trigger);
        defaultScheduler.start();
    }

    @Test
    void test1() throws SchedulerException {
        final Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.start();
        defaultScheduler.shutdown();
    }

    @Test
    void test2() throws SchedulerException {


    }

    private class HelloJob implements Job {

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            log.info("hello hello");
        }
    }
}
