package com.maodun.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author tongjian
 * @date 2020/5/29 15:27
 */
@Component
public class RegistryBind {
    private final List<String> words = new CopyOnWriteArrayList<>();

    public RegistryBind(MeterRegistry registry) {
        words.add("hehe");
        registry.gaugeCollectionSize("dictionary.size", Tags.empty(), this.words);
    }
}
