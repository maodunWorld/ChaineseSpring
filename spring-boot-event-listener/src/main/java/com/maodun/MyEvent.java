package com.maodun;

import org.springframework.context.ApplicationEvent;

/**
 * @author tongjian
 * @date 2021/2/2 14:25
 */

public class MyEvent extends ApplicationEvent {
    private String msg;

    public MyEvent(Object source) {
        super(source);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
