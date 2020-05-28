package com.maodun.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tongjian
 * @date 2020/5/28 18:26
 */
public class UDFMetrics implements MeterBinder {
    AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        Gauge.builder("udfcouter", atomicInteger, c -> c.incrementAndGet())
                .tag("host", "localhost")
                .description("自定义metrcis")
                .register(meterRegistry);
    }
}
