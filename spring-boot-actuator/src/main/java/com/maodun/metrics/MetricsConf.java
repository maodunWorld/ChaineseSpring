package com.maodun.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tags;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tongjian
 * @date 2020/5/29 15:31
 */
@Configuration
public class MetricsConf {
    @Bean
    public Counter udfCounter() {
        Counter counter = Metrics.globalRegistry.counter("testCouter", Tags.of("k", "v"));
        counter.increment(3d);
        return counter;
    }

    @Bean
    public UDFMetrics udfMetrics() {
        return new UDFMetrics();
    }
}
