package com.maodun.single;

import feign.Param;
import feign.RequestLine;

public interface SingleFeign {
    @RequestLine("GET /get/{str}")
    String getP(@Param("str") String str);
}
