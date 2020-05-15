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

# Profile 配置
指定启动那个配置文件，可以指定多个
```yaml
spring:
  profiles:
    active:
      - dev
      - dev1
```