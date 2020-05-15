# 自制SpringBoot的Starter

# 理解自动装配
基本原理为IOC思想  
一般来说：JavaConfig Or XML -> 反射读取，实例化Bean -> 注入IOC容器。   
SpringBoot中，统一了参数存放地，配合自动扫包完成Bean初始化，并注入SpringBoot容器。   
application.yaml -> 读取参数 -> JavaConfig -> 反射读取，实例化Bean -> 注入SpringBoot容器。   

* 那么抛出一个问题，SpringBoot如何知道你需要加载那些JavaConfig？  
在自制的SpringBoot Starter中，resources定义META-INF/spring.factories文件来指定SpringBoot需要初始化JavaConfig

# POM 

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-autoconfigure -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-autoconfigure</artifactId>
    <version>2.2.7.RELEASE</version>
</dependency>
```

# JavaConfig
```java
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


# 注意
artifactId应按照spring-boot-starter-****, 例如 spring-boot-starter-homemade
```
指定初始化的JavaConfig
```yaml
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.maodun.HomeMadeConf
```

# 如何动态获取参数
pom
```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-autoconfigure-processor -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-autoconfigure-processor</artifactId>
    <version>2.2.7.RELEASE</version>
</dependency>
```
注解
```java
/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/15 9:15
 */
@ConfigurationProperties("homemade")
public class HomeMadePojoPropertise {
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
```
对应YAML文件 或properties
```yaml
homemade:
    name: ****
    code: ***
```
```properties
homemade.name=***
homemade.code=***
```
JavaConfig
```java
@EnableConfigurationProperties(HomeMadePojoPropertise.class)
```
# 最后打包到Maven私服即可
略

# 自制Starter的单元测试
```java
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    public void initHomeMadePojo() {
        this.contextRunner.withUserConfiguration(HomeMadeConf.class).withPropertyValues("homemade.name=name", "homemade.code=code").run((context) -> {
            assertThat(context).hasSingleBean(HomeMadePojo.class);
            HomeMadePojo bean = context.getBean(HomeMadePojo.class);
            System.out.println(bean);
            // 输出结果 HomeMadePojo{name='name', code='code'}
        });
    }
```