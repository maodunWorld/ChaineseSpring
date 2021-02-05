package com.maodun;

import org.springframework.context.ApplicationEvent;

/**
 * @author tongjian
 * @date 2021/2/5 15:14
 */
public class MyEventTwo extends ApplicationEvent {
    private String msg;

    public MyEventTwo(Object source) {
        super(source);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

