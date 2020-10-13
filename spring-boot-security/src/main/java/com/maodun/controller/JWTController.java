package com.maodun.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tongjian
 * @date 2020/10/12 17:48
 */
@RestController
public class JWTController {


    @GetMapping("/api/test")
    public ResponseEntity test(String username) {
        return ResponseEntity.ok("OK");
    }
}
