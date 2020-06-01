package SpringBootTest.Ant;

import com.maodun.TestApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author tongjian
 * @date 2020/6/1 9:43
 */
@SpringBootTest(classes = TestApp.class)
@ActiveProfiles("1")
@Slf4j
public class anatationTest {
    @Value("${pojo}")
    private int pojoV;

    @Test
    void activeProfileTest() {
        log.info("Test with profile 1, pojoV is : {}", String.valueOf(pojoV));
    }


}
