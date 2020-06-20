package slf4j;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test1 {

    @Test
    public void hello() {
        Logger logger = LoggerFactory.getLogger(Test1.class);
        logger.info("hello world");
    }
}
