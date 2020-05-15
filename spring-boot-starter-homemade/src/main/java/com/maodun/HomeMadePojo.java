package com.maodun;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/14 19:08
 */
public class HomeMadePojo {

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

    @Override
    public String toString() {
        return "HomeMadePojo{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
