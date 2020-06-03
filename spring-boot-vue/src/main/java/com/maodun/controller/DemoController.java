package com.maodun.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tongjian
 * @date 2020/6/3 9:02
 */
@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/books")
    public ResponseEntity books() {
        return null;
    }
}
