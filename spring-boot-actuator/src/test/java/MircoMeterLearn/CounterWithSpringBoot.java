package MircoMeterLearn;


import com.maodun.InfluxApp;
import com.maodun.metrics.MyCounter;
import com.maodun.metrics.MyCounterV2;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.search.RequiredSearch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = InfluxApp.class, args = "--spring.profiles.active=influx")
public class CounterWithSpringBoot {

    @Autowired
    private MyCounter myCounter;

    @Autowired
    private MyCounterV2 myCounterV2;

    @Test
    void getCounterByGlobalRegistry() throws InterruptedException {
        final RequiredSearch requiredSearch = Metrics.globalRegistry.get("a.test.counter");
        final Counter counter = requiredSearch.counter();
        for (int i = 0; i < 60; i++) {
            myCounter.counterAdd();
        }
        Thread.sleep(1000 * 20);

        System.out.println(counter.count());
        System.out.println(myCounter.getCount());

        Thread.sleep(1000 * 20);
        myCounter.counterAdd();
        counter.increment();
        System.out.println(counter.count());
        System.out.println(myCounter.getCount());
    }

    @Test
    void testFunctionCounter() throws InterruptedException {
        final RequiredSearch requiredSearch = Metrics.globalRegistry.get("a.test.counter2");
        final FunctionCounter counter = requiredSearch.functionCounter();

        for (int i = 0; i < 120; i++) {
            myCounterV2.add();
        }

        System.out.println(counter.count());
        System.out.println(counter.measure().iterator().next().getValue());
        System.out.println(myCounterV2.get());
        System.out.println(myCounterV2.get2());
        System.out.println(myCounterV2.get3());
    }
}
