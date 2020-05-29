package UDFMetrics;

import com.maodun.InfluxApp;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tags;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author tongjian
 * @date 2020/5/29 16:34
 */
@SpringBootTest(classes = InfluxApp.class, args = "--spring.profiles.active=influx")
@Slf4j
public class UDFMetricsUse {
    private final List<String> words = new CopyOnWriteArrayList<>();

    /**
     *
     */
    @Test
    void test1() {

        Map map = Metrics.globalRegistry.getMeters().stream().collect(
                Collectors.toMap(meter -> meter.getId().getName(),
                        meter -> Metrics.gaugeCollectionSize(meter.getId().getName(), Tags.empty(), words).size()));

        System.out.println(map.get("dictionary.size"));
    }

}
