package com.maodun;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/15 14:41
 */
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
