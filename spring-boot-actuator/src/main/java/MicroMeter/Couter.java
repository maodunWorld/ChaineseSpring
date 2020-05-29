package MicroMeter;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.search.Search;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import lombok.Data;

import java.util.Arrays;

/**
 * @author tongjian
 * @date 2020/5/29 10:11
 */
public class Couter {
    @Data
    static
    class TestCase {
        private String code1;
        private String code2;
    }

    static {
        Metrics.addRegistry(new SimpleMeterRegistry());
    }

    public static void main(String[] args) {

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

    private static void addCouter(TestCase testCase) {
        Metrics.counter("testcouter", Arrays.asList(Tag.of("code1", testCase.getCode1()), Tag.of("code2", testCase.getCode2()))).increment();
    }
}
