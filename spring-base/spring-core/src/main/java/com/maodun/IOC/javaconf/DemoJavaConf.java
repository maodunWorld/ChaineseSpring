package com.maodun.IOC.javaconf;

import com.maodun.IOC.bean.ExampleBean3;
import com.maodun.IOC.component.ExampleComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * @author maodunWorld
 * @date 2020/5/19 11:00
 */
@Configuration

public class DemoJavaConf {
    @Autowired

    private ExampleComponent exampleComponent;

    @Bean(initMethod = "init", destroyMethod = "close")
    public ExampleBean3 exampleBean3() {
        return new ExampleBean3();
    }


}
