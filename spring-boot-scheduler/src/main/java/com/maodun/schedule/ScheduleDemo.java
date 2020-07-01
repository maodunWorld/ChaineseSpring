package com.maodun.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.Date;


@Configuration
@Slf4j
public class ScheduleDemo {

    //    @Scheduled(cron = "0/2 * * * * ?")
    public void demo() {
        log.info("触发调度 ： {}", new Date());
    }
}

