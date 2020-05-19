package com.maodun.IOC.bean;

import org.springframework.context.Lifecycle;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.SmartLifecycle;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author maodunWorld
 * @date 2020/5/19 11:15
 */
@SessionScope
@RequestScope
@ApplicationScope
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
