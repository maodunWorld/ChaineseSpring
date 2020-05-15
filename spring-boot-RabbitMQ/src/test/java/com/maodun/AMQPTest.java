package com.maodun;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/14 17:23
 */
@SpringBootTest
public class AMQPTest {

    @MockBean
    private AmqpTemplate amqpTemplate;

    @MockBean
    private AmqpAdmin amqpAdmin;

    @Test
    public void sendTest() {


    }
}
