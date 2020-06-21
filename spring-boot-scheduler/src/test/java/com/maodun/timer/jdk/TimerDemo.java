package com.maodun.timer.jdk;


import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

    public static void main(String[] args) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 1000, 1000);
    }

}
