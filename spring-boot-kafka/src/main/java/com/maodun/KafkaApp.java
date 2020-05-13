package com.maodun;

import lombok.extern.java.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CountDownLatch;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/13 16:20
 */
@SpringBootApplication
@Log
public class KafkaApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApp.class);
    }

    @Autowired
    private KafkaTemplate<String, String> template;

    private final CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run(String... args) throws Exception {
//        this.template.send("myTopic", "foo1");
//        this.template.send("myTopic", "foo2");
//        this.template.send("myTopic", "foo3");
//        latch.await(60, TimeUnit.SECONDS);
//        log.info("All received");
    }

    //    @KafkaListener(topics = "myTopic")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
//        log.info(cr.toString());
//        latch.countDown();
    }
}
