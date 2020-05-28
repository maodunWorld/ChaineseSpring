package MircoMeterLearn;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author tongjian
 * @date 2020/5/28 18:51
 */
@Slf4j
public class Registry {

    @Test
    public void test1() {
        SimpleMeterRegistry simpleMeterRegistry = new SimpleMeterRegistry();
        log.info(simpleMeterRegistry.toString());
    }

    @Test
    void test2() {
        CompositeMeterRegistry compositeMeterRegistry = new CompositeMeterRegistry();
        // 初始化一个Counter，并且我们可以将Counter打上多个标签。
        Counter couter1 = compositeMeterRegistry.counter("couter1");
        couter1.increment();
    }
}
