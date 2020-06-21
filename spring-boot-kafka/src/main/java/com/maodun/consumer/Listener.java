package com.maodun.consumer;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/13 17:49
 */

@Log4j2
public class Listener {
    @KafkaListener(topics = "myTopic")
    public void LisenerDemo(ConsumerRecord<?, ?> record, Acknowledgment ack) {
        log.info(record.value().toString());
    }
}
