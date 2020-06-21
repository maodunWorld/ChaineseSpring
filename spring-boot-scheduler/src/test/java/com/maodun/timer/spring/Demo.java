package com.maodun.timer.spring;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Demo {

    @Test
    void test1() {
        final ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(5);
        threadPoolTaskExecutor.setQueueCapacity(25);
        threadPoolTaskExecutor.initialize();
        for (int i = 0; i < 25; i++) {
            threadPoolTaskExecutor.execute(new MessagePrintTask("Message : " + i));
        }
    }

    private class MessagePrintTask implements Runnable {

        private String message;

        public MessagePrintTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println(message);
        }
    }
}
