# SpringBoot配置文件
Properties和YAML，推荐用YAML
* YAML获取数组
```yaml
my:
   servers:
       - dev.example.com
       - another.example.com
```
# 定制Init方法 Implements CommandLineRunner
```java
@SpringBootApplication
@Slf4j
public class ConfApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ConfApp.class);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("this is my init method");
    }
}
```
# 获取参数
```java
@Value("${name}")
private String name;
```
* 配置文件中获取参数
```java
app:
  appName: ${name} this is is appName
```

* 配置类
```java
@ConfigurationProperties("demo")
public class ConfDemo {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ConfDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```
# 复杂点
```yaml
robot:
  id: 301
  interval:
    hour:
      list: 8;17;21
  item: sh/zz数据传输
  qq:
    groups: 15233038
    persons: 531472181
  server:
    ip: http://172.19.104.247:8182/inspection/pushing
```
```java
@ConfigurationProperties("robot")
@Data
@ToString
public class RobotProperties {
    private String id;
    private String item;
    @Value("${robot.interval.hour.list}")
    private String interval;
    @Value("${robot.server.ip}")
    private String ip;
    private qqPropperties qq = new qqPropperties();

    @Data
    @ToString
    public class qqPropperties {
        private String groups;
        private String persons;
    }
}
```
# Profile 配置
指定启动那个配置文件，可以指定多个
```yaml
spring:
  profiles:
    active:
      - dev
      - dev1
```