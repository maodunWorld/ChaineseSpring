package com.maodun;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author tongjian
 * @date 2021/2/2 14:37
 */
@Configuration
public class TestConfiguration {
    @EventListener(classes = MyEvent.class)
    public void testLinstener(MyEvent myEvent) {
        System.out.println("config" + myEvent.getMsg());
    }
}
