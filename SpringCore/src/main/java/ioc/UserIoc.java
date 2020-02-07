package ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

// @ComponentScan(basePackages = "com.acme") 将其他IOC容器融合到本容器
// @Import 注解导入指定IOC容器
//@Component 指定为一个IOC容器
//@PropertySource("classpath:application.properties") 注入properties
@Configuration // 表示此Java类是一个配置文件，等同于一个XML文件。
//@Import() 导入其他Java Conf
public class UserIoc {
    //Scope注解指定Bean的实例化方式
    @Scope
    // Bean注解可以指定生命周期的回调函数
    @Bean
//    @Resource 使用Bean 名字进行注入
//    @Value("${catalog.name:默认值}") 注入属性
    public User userService(){
        return new User(1, "haha");
    }

//    @PostConstruct 开始时调用的方法
    public void start(){};

//    @PreDestroy bean结束时调用的方法
    public void end(){};

}
