package com.maodun.shell;

import com.maodun.controller.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author tongjian
 * @date 2020/7/31 10:55
 */
@ShellComponent
public class HelloCommands {

    @ShellMethod("输出Hello")
    public String hello() {
        return "hello";
    }

    @ShellMethod(value = "多参数输入")
    public String echo(int a, int b, int c) {
        return String.format("输入参数为 a=%d, b=%d, c=%d", a, b, c);
    }

    @Autowired
    private Demo demo;

    @ShellMethod(value = "日志与Sout")
    public void print() {
        demo.print();
    }
}
