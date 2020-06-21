package com.maodun.feign;

import com.maodun.model.Pay;
import feign.*;

import java.util.Map;

public interface SingleFeign {
    @RequestLine("GET /get/{str}")
    String getP(@Param("str") String str);

    @RequestLine("GET /get")
    String getP1(@QueryMap Pay pay);

    @RequestLine("GET /getform")
    String getFrom(@QueryMap Map<String, Object> queryMap);

    @RequestLine("GET /getheader")
    @Headers("test: { teststr }")
    String getHeader(@Param("teststr") String teststr);

    @RequestLine("POST /post")
    @Headers("Content-Type: application/json")
    @Body("%7B\"str1\": \"{str1}\", \"str2\": \"{str2}\"%7D")
    String postBody(@Param("str1") String str1, @Param("str2") String str2);

    @RequestLine("POST /postform")
    String postForm(@QueryMap Map<String, Object> form);

}
