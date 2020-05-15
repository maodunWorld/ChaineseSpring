package com.maodun;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/15 9:15
 */
@ConfigurationProperties(prefix = "homemade")
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
