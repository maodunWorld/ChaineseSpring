package MircoMeterLearn;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
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

    /**
     * 最简单的注册中心
     */
    @Test
    public void test1() {
        SimpleMeterRegistry simpleMeterRegistry = new SimpleMeterRegistry();
        log.info(simpleMeterRegistry.toString());
    }

    /**
     * 复杂的注册中心，复杂注册中心中会维护一个简单注册中心的列表
     */
    @Test
    void test2() {
        CompositeMeterRegistry compositeMeterRegistry = new CompositeMeterRegistry();
        // 初始化一个Counter，并且我们可以将Counter打上一个或多个多个标签。
        // 简单理解Couter为一个计数器
        Counter couter1 = compositeMeterRegistry.counter("couter1");
        couter1.increment();
        SimpleMeterRegistry simple = new SimpleMeterRegistry();
        compositeMeterRegistry.add(simple);
        couter1.increment();
        // Couter只是接口 ，实现类有Dropwizard这种Metrics库
        log.info(String.valueOf(couter1.count()));
    }

    /**
     * 静态全局的注册中心
     */
    @Test
    void test3() {
        Metrics.addRegistry(new SimpleMeterRegistry());
    }

}
