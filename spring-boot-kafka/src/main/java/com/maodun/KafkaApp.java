package com.maodun;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/13 16:20
 */
@SpringBootApplication
@Slf4j
public class KafkaApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApp.class);
    }


    @Override
    public void run(String... args) throws Exception {
//        ContainerProperties containerProperties = new ContainerProperties("test");
//
//        containerProperties.setMessageListener(new MessageListener<Integer, String>() {
//            @Override
//            public void onMessage(ConsumerRecord<Integer, String> integerStringConsumerRecord) {
//                log.info("收到v {}", integerStringConsumerRecord.toString());
//            }
//        });
//
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.30.102:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test.group");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
//        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "10000");
//        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        DefaultKafkaConsumerFactory<Integer, String> cf =
//                new DefaultKafkaConsumerFactory<Integer, String>(props);
//        KafkaMessageListenerContainer<Integer, String> container =
//                new KafkaMessageListenerContainer<>(cf, containerProperties);
//
//        container.start();
    }
}
