package com.maodun;

import com.maodun.handler.ServerHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.net.InetSocketAddress;

/**
 * @author tongjian
 * @date 2020/5/26 18:39
 */
@SpringBootApplication
@Slf4j
public class MinaApp implements CommandLineRunner, DisposableBean {

//    private static final NioSocketAcceptor nioSocketAcceptor = new NioSocketAcceptor();
//    @Value("${mina.port}")
//    private int minaPort;

    public static void main(String[] args) {
        SpringApplication.run(MinaApp.class);
    }

    @Override
    public void run(String... args) throws Exception {
//        nioSocketAcceptor.setHandler(new ServerHandler());
//        nioSocketAcceptor.bind(new InetSocketAddress(minaPort));
//        log.info("Mina服务器启动了");
//
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            log.info("Mina服务器关闭了");
//            nioSocketAcceptor.unbind();
//        }));
    }

    @Override
    public void destroy() throws Exception {
//        nioSocketAcceptor.unbind();
//        nioSocketAcceptor.dispose();
//        log.info("Mina服务器关闭");
    }
}
