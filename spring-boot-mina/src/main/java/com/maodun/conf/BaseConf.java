package com.maodun.conf;

import com.maodun.bean.StringBeanImpl;
import com.maodun.handler.ServerHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author tongjian
 * @date 2020/5/27 9:19
 */
@Configuration
@Slf4j
public class BaseConf {

    @Value("${mina.port}")
    private int serverPort;

    @Autowired
    private ServerHandler serverHandler;

    @Bean
    public StringBeanImpl stringBean() {
        return new StringBeanImpl();
    }


    @Bean(destroyMethod = "unbind")
    public NioSocketAcceptor initMina() throws IOException {
        NioSocketAcceptor nioSocketAcceptor = new NioSocketAcceptor();
        nioSocketAcceptor.setHandler(serverHandler);
        nioSocketAcceptor.bind(new InetSocketAddress(serverPort));
        log.info("Mina启动了");
        return nioSocketAcceptor;
    }
}
