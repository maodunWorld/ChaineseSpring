# IOC 容器
```text
JavaConf OR XML -> 反射读取 —> 实例化Java对象，获得上下文环境。
```
## JavaConf 的IOC容器 （XML就不总结了）
### Bean概述    
命名, 默认为驼峰命名方法。
```java
@Bean(name = "udfName")
```

### 依赖注入方式
```java
// 第一种
@Autowired
private ExampleComponent exampleComponent;
```
### Bean 范围  
 默认为单例模式
```java
@SessionScope
@RequestScope
@ApplicationScope

@Scope()

```
自定义范围, 实现指定接口即可。
```java
 org.springframework.beans.factory.config.Scope;
```
### 生命周期
* Bean的初始化与销毁方法  
第一种基于Java注解
```java
    @PostConstruct
    private void init() {
        log.info("this is exampleBean init Method, u can int some resource,like redisClient");
    }

    @PreDestroy
    private void close() {
        log.info("this is bean destroy method, u can close some resource,lick mysql-connection-pool, redis-client");
    }
```
第二种基于Spring提供的接口
```java
@Slf4j
public class ExampleBean2 implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("this is a bean init method base Spring Interface");
    }

    @Override
    public void destroy() throws Exception {
        log.info("this is a bean destroy method base Spring Interface");
    }
}
```
第三种，基于@Bean注解指定初始化，销毁方法。
```java
    @Bean(initMethod = "init", destroyMethod = "close")
    public ExampleBean3 exampleBean3() {
        return new ExampleBean3();
    }

    @Log4j2
    public class ExampleBean3 {
        private void init() {
            log.info("this is a bean init method");
        }

    private void close() {
            log.info("this is a bean close method");
        }
    }          
```
* 托管生命周期
```java
import org.springframework.context.Lifecycle;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.SmartLifecycle;

public class ExampleBean4 implements Lifecycle, LifecycleProcessor, SmartLifecycle {
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onClose() {

    }
}
```
### 配置扫描
```java
@ComponentScan
@Import
```
