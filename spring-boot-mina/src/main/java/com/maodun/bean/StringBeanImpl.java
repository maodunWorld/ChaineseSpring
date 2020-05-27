package com.maodun.bean;

/**
 * @author tongjian
 * @date 2020/5/27 9:17
 */
public class StringBeanImpl implements StringBean {
    public String cheng2(String msg) {
        return msg + "-" + msg;
    }
}
