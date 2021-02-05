package com.maodun;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author tongjian
 * @date 2021/2/2 14:38
 */
//@Component
public class TestConponent {
    @EventListener(classes = MyEvent.class)
    public void testLinstener(MyEvent myEvent) {
        System.out.println("component+  " + myEvent.getMsg());
    }
}
