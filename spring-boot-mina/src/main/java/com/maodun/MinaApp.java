package com.maodun;

import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tongjian
 * @date 2020/5/26 18:39
 */
@SpringBootApplication
public class MinaApp implements CommandLineRunner, DisposableBean {

    private NioSocketAcceptor nioSocketAcceptor = null;

    public static void main(String[] args) {
        SpringApplication.run(MinaApp.class);
    }

    @Override
    public void run(String... args) throws Exception {

    }

    @Override
    public void destroy() throws Exception {
        nioSocketAcceptor.unbind();
        nioSocketAcceptor.dispose();
    }
}
