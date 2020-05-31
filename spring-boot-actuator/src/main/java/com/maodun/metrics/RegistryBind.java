package com.maodun.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

/**
 * @author tongjian
 * @date 2020/5/29 15:27
 */
@Component
public class RegistryBind implements MeterBinder {

    @Override
    public void bindTo(MeterRegistry meterRegistry) {

    }
}
