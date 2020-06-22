package com.maodun.feign;

import com.maodun.model.Pay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "demo", url = "http://localhost:1888/api")
public interface SpringBootFeign {

    @GetMapping("/get")
    public String get(@RequestParam String str1, @RequestParam String str2);

    @GetMapping("/get/{str}")
    public String getPath(@PathVariable String str);

    @GetMapping("/getform")
    public String getForm(@RequestParam String str);

    @GetMapping("/getheader")
    public String getHeader(@RequestHeader("test") String test);

    @PostMapping("/post")
    public String post(@RequestBody Pay pay);

    @PostMapping("/postfrom")
    public String postForm(@RequestParam("testform") String str);
}
