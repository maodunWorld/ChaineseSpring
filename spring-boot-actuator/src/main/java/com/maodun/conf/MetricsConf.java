package com.maodun.conf;

import com.maodun.metrics.UDFMetrics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tongjian
 * @date 2020/5/28 18:37
 */
@Configuration
public class MetricsConf {
    @Bean
    public UDFMetrics udfMetrics() {
        return new UDFMetrics();
    }
}
