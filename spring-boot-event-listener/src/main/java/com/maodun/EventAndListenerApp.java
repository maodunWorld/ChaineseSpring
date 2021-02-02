package com.maodun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;

/**
 * @author tongjian
 * @date 2021/2/2 14:23
 */
@SpringBootApplication
public class EventAndListenerApp implements CommandLineRunner {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public static void main(String[] args) {
        SpringApplication.run(EventAndListenerApp.class);
    }

    @Override
    public void run(String... args) throws Exception {
        MyEvent myEvent = new MyEvent("");
        myEvent.setMsg("hello");
        applicationEventPublisher.publishEvent(myEvent);
    }


    @EventListener(classes = MyEvent.class)
    public void testLinstener(MyEvent myEvent) {
        System.out.println(myEvent.getMsg());
    }
}

