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
        MyEvent myEvent = new MyEvent(this);
        myEvent.setMsg("hello");
        MyEventTwo myEventTwo = new MyEventTwo(this);
        myEventTwo.setMsg("kji");
        applicationEventPublisher.publishEvent(myEventTwo);
        applicationEventPublisher.publishEvent(myEvent);

    }


    @EventListener(classes = {MyEvent.class, MyEventTwo.class})
    public void testLinstener(Object event) {
        if (event instanceof MyEvent) {
            MyEvent event1 = (MyEvent) event;
            System.out.println(event1.getMsg());
        } else if (event instanceof MyEventTwo) {
            MyEventTwo event1 = (MyEventTwo) event;
            System.out.println(event1.getMsg());
        }
    }
}

