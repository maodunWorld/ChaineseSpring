package com.maodun.metrics;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tags;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyGauge {
    public static final AtomicInteger myGauge = Metrics.gauge("my.gauge", Tags.empty(), new AtomicInteger(0), AtomicInteger::doubleValue);

    public double down() {
        return myGauge.decrementAndGet();
    }

    public double up() {
        return myGauge.incrementAndGet();
    }
}
