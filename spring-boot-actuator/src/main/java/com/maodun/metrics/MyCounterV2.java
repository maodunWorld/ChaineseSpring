package com.maodun.metrics;

import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyCounterV2 {
    public static final AtomicInteger atomicInteger = new AtomicInteger(0);
    public static final FunctionCounter testunit = FunctionCounter.builder("a.test.counter2", atomicInteger, AtomicInteger::get)
            .baseUnit("testunit")
            .register(Metrics.globalRegistry);

    public void add() {
        atomicInteger.incrementAndGet();
    }

    public double get() {
        return testunit.count();
    }

    public double get2() {
        return testunit.measure().iterator().next().getValue();
    }

    public double get3() {
        return atomicInteger.get();
    }
}
