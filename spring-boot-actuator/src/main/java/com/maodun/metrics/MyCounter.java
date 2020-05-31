package com.maodun.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.Measurement;
import io.micrometer.core.instrument.Metrics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyCounter {
    public static final Counter Counter1 = Metrics.counter("a.test.counter", "bind", "demo");

    public void counterAdd() {
        log.info("Before Add: {} ", Counter1.count());
        Counter1.increment(10d);
        final Measurement next1 = Counter1.measure().iterator().next();
        System.out.println(next1);
        log.info("After Add: {} ", Counter1.count());
    }

    public double getCount() {
        return Counter1.count();
    }
}
