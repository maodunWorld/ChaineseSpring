package com.maodun;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/15 13:56
 */
@SpringBootApplication
@EnableConfigurationProperties({ConfDemo.class, ServersConf.class, RobotProperties.class, BackPresureConf.class})
@Slf4j
public class ConfApp implements CommandLineRunner {

    @Value("${name}")
    private String name;

    @Value("${app.appName")
    private String appName;

    @Autowired
    private ServersConf serversConf;

    @Autowired
    private RobotProperties robotProperties;

    @Autowired
    private BackPresureConf backPresureConf;

    @Autowired
    private ConfDemo confDemo;

    @Value("${caster.host}")
    private String host;

    public static void main(String[] args) {
        SpringApplication.run(ConfApp.class).close();
    }

    @Override
    public void run(String... args) throws Exception {
//        log.info("this is my init method");
//        log.info("get --------" + name);
//        log.info("this is appName: " + appName);
//        log.info(confDemo.toString());
        System.out.println(host);
//        serversConf.getServers().forEach(System.out::println);


    }
}
