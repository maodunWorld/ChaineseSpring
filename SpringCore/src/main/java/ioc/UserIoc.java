package ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// @ComponentScan(basePackages = "com.acme") 将其他IOC容器融合到本容器
// @Import 注解导入指定IOC容器
@Configuration
public class UserIoc {
    //Scope注解指定Bean的实例化方式
    @Scope
    // Bean注解可以指定生命周期的回调函数
    @Bean
    public User userService(){
        return new User(1, "haha");
    }

}
