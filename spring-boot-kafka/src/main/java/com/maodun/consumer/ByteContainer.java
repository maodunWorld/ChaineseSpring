package com.maodun.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tongjian
 * @date 2020/6/22 11:34
 */
@Slf4j
public class ByteContainer {
    public static void main(String[] args) {
        ContainerProperties containerProps = new ContainerProperties("test");

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.15.102:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test.group");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
        DefaultKafkaConsumerFactory<String, byte[]> cf =
                new DefaultKafkaConsumerFactory<String, byte[]>(props);
        KafkaMessageListenerContainer<String, byte[]> container =
                new KafkaMessageListenerContainer<>(cf, containerProps);
        container.setupMessageListener(new MessageListener<String, byte[]>() {
            @Override
            public void onMessage(ConsumerRecord<String, byte[]> stringConsumerRecord) {
                String s = new String(stringConsumerRecord.value(), 0, stringConsumerRecord.value().length);
                log.info("result str is {} ", s);
                log.info(stringConsumerRecord.value().toString());
            }
        });
        container.start();
    }
}
