package com.maodun.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/13 13:20
 */
@Configuration
public class MongoConf {
    @Bean
    public MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }
}
