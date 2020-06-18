package com.maodun.single;

import feign.Feign;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.StringDecoder;
import org.junit.jupiter.api.Test;
import org.springframework.http.codec.json.Jackson2SmileDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

import static org.junit.jupiter.api.Assertions.*;

class SingleFeignTest {

    @Test
    void getP() {
        SingleFeign target = Feign.builder().target(SingleFeign.class, "http://localhost:8080/api");
        target.getP("kjkds");
    }
}