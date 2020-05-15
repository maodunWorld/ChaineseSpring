package com.maodun;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/15 13:56
 */
@SpringBootApplication
@EnableConfigurationProperties({ConfDemo.class, ServersConf.class})
@Slf4j
public class ConfApp implements CommandLineRunner {

    @Value("${name}")
    private String name;

    @Value("${app.appName")
    private String appName;

    @Autowired
    private ServersConf serversConf;

    @Autowired
    private ConfDemo confDemo;

    public static void main(String[] args) {
        SpringApplication.run(ConfApp.class).close();
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("this is my init method");
        log.info("get --------" + name);
        log.info("this is appName: " + appName);
        log.info(confDemo.toString());
        serversConf.getServers().forEach(System.out::println);
    }
}
