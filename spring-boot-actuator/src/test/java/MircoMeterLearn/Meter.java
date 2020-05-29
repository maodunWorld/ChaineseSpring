package MircoMeterLearn;

import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.*;
import io.micrometer.core.instrument.search.Search;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.ToDoubleFunction;

/**
 * @author tongjian
 * @date 2020/5/29 9:53
 */
@Slf4j
public class Meter {


    @Data
    class TestCase {
        private String code1;
        private String code2;
    }

    static {
        Metrics.addRegistry(new SimpleMeterRegistry());
    }

    /*
    couter 是计数器
     */
    @Test
    void couter() {

        TestCase testCase = new TestCase();
        testCase.setCode1("code1");
        testCase.setCode2("code2");
        addCouter(testCase);
        TestCase testCase1 = new TestCase();
        testCase1.setCode1("code12");
        testCase1.setCode2("code22");
        addCouter(testCase1);
        Search.in(Metrics.globalRegistry).meters().forEach(e -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("code1:")
                    .append(e.getId().getName())
                    .append(",tags:")
                    .append(e.getId().getTags())
                    .append(",type:").append(e.getId().getType())
                    .append(",value").append(e.measure());
            System.out.println(stringBuilder.toString());
        });
    }

    private void addCouter(TestCase testCase) {
        Metrics.counter("testcouter", Arrays.asList(Tag.of("code1", testCase.getCode1()), Tag.of("code2", testCase.getCode2()))).increment();
    }

    @Test
    void test2() {
        Counter counter = Counter
                .builder("counter")
                .baseUnit("beans") // optional
                .description("a description of what this counter does") // optional
                .tags("region", "test") // optional
                .register(Metrics.globalRegistry);
    }

    /*
    functionCouter使用
     */
    @Test
    void test3() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        FunctionCounter register = FunctionCounter.builder("testFunCouter", atomicInteger, new ToDoubleFunction<AtomicInteger>() {
            @Override
            public double applyAsDouble(AtomicInteger value) {
                return value.get();
            }
        }).baseUnit("func")
                .description("funcCouter")
                .tag("funcK", "funcV")
                .register(Metrics.globalRegistry);
        atomicInteger.incrementAndGet();
        atomicInteger.incrementAndGet();
        log.info("couter is" + register.count());
        log.info("atomic is" + atomicInteger.get());
    }


    /*
    Gauges
     */
    @Test
    void test4() {
        ArrayList<Object> listGauge = Metrics.globalRegistry.gauge("listGauge", Collections.emptyList(), new ArrayList<>(), List::size);
        ArrayList<Object> listSize2 = Metrics.globalRegistry.gaugeCollectionSize("ListSize2", Tags.empty(), new ArrayList<>());
        HashMap<Object, Object> mapGauge = Metrics.globalRegistry.gaugeMapSize("mapGauge", Tags.empty(), new HashMap<>());
        // maintain a reference to myGauge
        AtomicInteger myGauge = Metrics.globalRegistry.gauge("numberGauge", new AtomicInteger(0));

// ... elsewhere you can update the value it holds using the object reference
        myGauge.set(27);
        myGauge.set(11);

        // 通过
    }

    /*
    timer
     */
    @Test
    void test5() {
        Timer register = Timer.builder("my.timer")
                .description("test timer")
                .tag("region", "test")
                .register(Metrics.globalRegistry);
    }
}
