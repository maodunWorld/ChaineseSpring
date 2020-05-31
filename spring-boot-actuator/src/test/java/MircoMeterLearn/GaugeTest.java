package MircoMeterLearn;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Measurement;
import io.micrometer.core.instrument.Metrics;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class GaugeTest {

    @Test
    void test1() {
        final AtomicInteger gauge = Metrics.gauge("counter.gauge", new AtomicInteger(0), AtomicInteger::doubleValue);
        for (int i = 0; i < 100; i++) {
            gauge.incrementAndGet();
        }
        System.out.println(gauge.get());
    }

    @Test
    void test2() {
        final AtomicInteger obj = new AtomicInteger(10);
        final Gauge a_test_gauge = Gauge.builder("counter.gauge2", obj, AtomicInteger::doubleValue)
                .register(Metrics.globalRegistry);
        obj.incrementAndGet();
        System.out.println(obj.get());
        a_test_gauge.value();
        final Measurement next = a_test_gauge.measure().iterator().next();
    }
}
