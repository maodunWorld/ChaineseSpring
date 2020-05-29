package com.maodun.bean;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

/**
 * @author tongjian
 * @date 2020/5/29 15:36
 */
@Component
public class MetricsBean {
//    private final Counter counter;

    public MetricsBean(MeterRegistry registry) {
//        RequiredSearch testcounter = registry.get("testcounter");
//        this.counter = testcounter.counter();
    }

    public void handleMessage(String message) {
//        this.counter.increment();
        // handle message implementation
    }
}
