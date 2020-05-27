# SpringBoot整合Mina

# 踩坑
如果你想完美使用SpringBoot IOC和 AOP特性，不要使用 CommandLineRunner, DisposableBean这种方式去启动Mina服务器。
```java
        nioSocketAcceptor.setHandler(new ServerHandler());
        // new ServerHandler后， Handler中的AutoWired将会是空指针异常。
        nioSocketAcceptor.bind(new InetSocketAddress(minaPort));
        log.info("Mina服务器启动了");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Mina服务器关闭了");
            nioSocketAcceptor.unbind();
        }));
```
# 正确整合方式 通过JavaConf 
```java
@Configuration
@Slf4j
public class BaseConf {
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
        nioSocketAcceptor.bind(new InetSocketAddress(8888));
        log.info("Mina启动了");
        return nioSocketAcceptor;
    }
}
```
Handler 也是如此，通过@Component注解进行IOC托管
```java
@Component
@Slf4j
public class ServerHandler extends IoHandlerAdapter {

    @Autowired
    private StringBean stringBean;

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        IoBuffer inBuf = (IoBuffer) message;
        byte[] inbytes = new byte[inBuf.limit()];
        inBuf.get(inbytes, 0, inBuf.limit());
        log.info(stringBean.cheng2(new String(inbytes, "UTF-8")));
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
    }
}
```

# 单元测试 通过
```java
    @Test
    void testClientInfo() throws IOException {
        Socket socket = new Socket("localhost", serverPort);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        outputStream.write("haha".getBytes("UTF-8"));
        outputStream.flush();
        byte[] byteArray = new byte[1024];
        int length = inputStream.read(byteArray);
        Assertions.assertEquals("haha-haha", new String(byteArray, 0, length, "UTF-8"));

        inputStream.close();
        outputStream.close();
        socket.close();
    }
```

# InfluxDb + Grafana + MetricsIo 监控Mina
TODO