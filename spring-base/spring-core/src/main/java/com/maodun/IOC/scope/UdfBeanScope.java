package com.maodun.IOC.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * @author maodunWorld
 * @date 2020/5/19 11:52
 */
public class UdfBeanScope implements Scope {
    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        return null;
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
