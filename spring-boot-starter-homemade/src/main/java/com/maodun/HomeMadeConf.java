package com.maodun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/14 18:45
 */
@Configuration
@EnableConfigurationProperties(HomeMadePojoPropertise.class)
public class HomeMadeConf {

    @Autowired
    private HomeMadePojoPropertise homeMadePojoPropertise;

    @Bean
    public HomeMadePojo initHomeMadePojo() {
        HomeMadePojo homeMadePojo = new HomeMadePojo();
        homeMadePojo.setCode(homeMadePojoPropertise.getCode());
        homeMadePojo.setName(homeMadePojoPropertise.getName());
//        homeMadePojo.setName("name");
//        homeMadePojo.setCode("code");
        return homeMadePojo;
    }
}
