package com.maodun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tongjian
 * @date 2020/6/3 9:04
 */
@Controller
public class HtmlController {
    @GetMapping("/htmlWithController1")
    public String htmlWithController1() {
        return "htmlWithController.html";
    }

    @GetMapping("/htmlWithController2")
    public String htmlWithController2() {
        return "demo/htmlWithController.html";
    }
}
