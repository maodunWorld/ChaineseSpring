package com.maodun.producer;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/13 17:11
 */
@SpringBootTest
@Log4j2
class TemplateSenderTest {
    @Autowired
    private KafkaTemplate kafkaTemplate;


    /**
     * 发送一条消息
     */
    @Test
    public void sendOne() {
        ProducerRecord producerRecord = new ProducerRecord("myTopic", 0, System.currentTimeMillis(), "a key", "a value");

        /**
         * 异步回调
         */
        ListenableFuture send = kafkaTemplate.send(producerRecord);
        send.addCallback(new ListenableFutureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("--------send fail------------");
            }

            @Override
            public void onSuccess(Object o) {
                log.error("--------send success------------");
            }
        });

        // 同步

        try {
            kafkaTemplate.send(producerRecord).get(10, TimeUnit.SECONDS);
            log.error("--------send success------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}