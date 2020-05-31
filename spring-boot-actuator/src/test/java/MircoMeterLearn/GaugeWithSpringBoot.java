package MircoMeterLearn;


import com.maodun.InfluxApp;
import com.maodun.metrics.MyGauge;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = InfluxApp.class, args = "--spring.profiles.active=influx")
public class GaugeWithSpringBoot {

    @Autowired
    private MyGauge myGauge;

    @Test
    void test1() throws InterruptedException {
        while (true) {
            myGauge.up();
            Thread.sleep(1000);
            System.out.println(myGauge.up());
        }
    }
}
