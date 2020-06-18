package com.maodun;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api")
@Slf4j
public class FeignApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignApp.class);
    }

    @GetMapping("/get")
    public String get(String str1, String str2) {
        log.info("Str1 {}, Str2 {}", str1, str2);
        return "ok";
    }

    @GetMapping("/get/{str}")
    public String getPath(@PathVariable String str){
        log.info("get pathV {}", str);
        return "ok";
    }

    @GetMapping("/getform")
    public String getForm(@RequestParam String str){
        log.info("form data {}", str);
        return "ok";
    }

    @GetMapping("/getheader")
    public String getHeader(@RequestHeader("test") String test){
        log.info("header test {}", test);
        return "ok";
    }

    @PostMapping("/post")
    public String post(@RequestBody Pay pay) {
        log.info(pay.toString());
        return "ok";
    }

}
