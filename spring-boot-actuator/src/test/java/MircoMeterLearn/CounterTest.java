package MircoMeterLearn;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class CounterTest {

    @Test
    void test1() {
        final SimpleMeterRegistry simpleMeterRegistry = new SimpleMeterRegistry();
        final Counter counter = simpleMeterRegistry.counter("test.counter1", "testk1", "testv1");
        final Counter register = Counter.builder("test.counter2")
                .baseUnit("long")
                .description("a test counter2 desc")
                .tag("testk2", "testv2")
                .register(simpleMeterRegistry);

        for (int i = 0; i < 100000; i++) {
            register.increment();
            counter.increment();
        }


        log.info(counter.measure().toString());
        System.out.println(register.count());
        System.out.println(counter.count());
        log.info(register.measure().toString());
    }

    @Test
    void test2() {

    }
}
