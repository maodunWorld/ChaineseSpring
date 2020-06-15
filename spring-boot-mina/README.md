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

# InfluxDb + Grafana + MicroMeter 监控Mina
pom
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-influx</artifactId>
            <scope>runtime</scope>
        </dependency>

```
yml
```yaml
management:
  metrics:
    export:
      influx:
        auto-create-db: true
        db: test
        uri: http://192.168.30.102:8086

          # 连接和读取的超时时间
          #        connect-timeout: 1s
          #        read-timeout: 10s

          # 线程数，默认为2
          #        num-threads: 1

          # ANY 写入任何一个节点，就返回成功（即使数据的所属文件和节点不一致，也算保存成功）
          # ONE 可以写入任何一个节点，就返回成功（必须数据所属文件和节点一致才算保存成功）
          # QUORUM 大多数节点返回成功即成功（例如 三个节点，两个节点保存成功，即可按成功返回）
          # ALL 所有节点返回成功才算成功 （例如有三个节点，所有节点保存成功，才算是成功）
          #        consistency: one

          # 是否开启压缩
          #        compressed: true

          # 批大小
          #        batch-size: 10000

          #        enabled: true

          # 多久保存一次，默认为一分钟一次
          #        step: 1m

          #数据保留策略
          # retentionPolicy: autogen
          #Time period for which Influx should retain data in the current database. For instance 7d
          # 数据保留的时间，例如保留七天
          #retentionDuration:
          #How many copies of the data are stored in the cluster. Must be 1 for a single node instance.
          #节点的备份数据，单节点的必须为1
        #retentionReplicationFactor:
        #每一组文件，保存的时间范围

      prometheus:
        enabled: false
  endpoints:
    jmx:
      exposure:
        exclude: '*'
  server:
    port: -1
```
自定义Counter
```java
    public static final AtomicInteger atomicInteger = new AtomicInteger(0);
    public static final FunctionCounter testunit = FunctionCounter.builder("a.test.counter2", atomicInteger, AtomicInteger::get)
            .baseUnit("testunit")
            .register(Metrics.globalRegistry);
```
最后，输出到InfluxDb，用Grafana可视化展示（略）
