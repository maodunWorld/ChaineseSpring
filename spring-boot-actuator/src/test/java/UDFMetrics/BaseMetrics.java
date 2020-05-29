package UDFMetrics;

import com.maodun.InfluxApp;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tongjian
 * @date 2020/5/29 15:49
 */
@SpringBootTest(classes = InfluxApp.class, args = "--spring.profiles.active=influx")
@Slf4j
public class BaseMetrics {
    private static final AtomicInteger registrySize = new AtomicInteger(0);
    private static final AtomicInteger meterSize = new AtomicInteger(0);

    @Test
    void allMetrics() {
        for (MeterRegistry registry : Metrics.globalRegistry.getRegistries()) {
            registrySize.incrementAndGet();
            log.info("Registry Name is: {}", registry.config().toString());
            for (Meter meter : registry.getMeters()) {
                meterSize.incrementAndGet();
                log.info("Meter名字为: {} ", meter.getId().getName());
            }
        }
        log.info("注册中心数量为: {}，Metrics 仪表数为: {}", registrySize.get(), meterSize.get());
    }
}
