package com.maodun.test.controller;

import com.maodun.pojo.ResultResp;
import com.maodun.pojo.payload.UserPayload;
import com.maodun.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tongjian
 * @date 2020/10/13 10:22
 */
@RestController
@RequestMapping("/api")
@Slf4j
//@CrossOrigin
public class UserController {

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserPayload userPayload) throws UnsupportedEncodingException {
        log.info("login action");
        Map<String, String> objectObjectHashMap = new HashMap<>();
        String token = JwtUtil.getToken(objectObjectHashMap);
        ResultResp resultResp = new ResultResp(20000, "ok", token);
        return ResponseEntity.ok(resultResp);
    }

    @GetMapping("/user/info")
    public ResponseEntity info(String token) {
        ResultResp ok = new ResultResp(20000, "ok", "{\"name\":\"admin\", \"avatar\": null}");
        return ResponseEntity.ok(ok);
    }

    @PostMapping("/user/logout")
    public ResponseEntity logout(@RequestHeader(name = "X-token") String token) {
        log.info("Token is {}", token);
        ResultResp resultResp = new ResultResp(20000, "ok", "success");
        return ResponseEntity.ok(resultResp);
    }
}
