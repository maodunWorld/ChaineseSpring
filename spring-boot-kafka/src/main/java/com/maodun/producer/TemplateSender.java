package com.maodun.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/13 17:07
 */
public class TemplateSender {

    @Autowired
    private KafkaTemplate kafkaTemplate;

}
