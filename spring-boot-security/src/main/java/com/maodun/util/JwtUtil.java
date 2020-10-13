package com.maodun.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Map;

/**
 * @author tongjian
 * @date 2020/10/12 19:24
 */
public class JwtUtil {
    private static String SING = "123";

    public static String getToken(Map<String, String> claim) throws UnsupportedEncodingException {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);
        JWTCreator.Builder builder = JWT.create();
        claim.forEach((k, v) -> builder.withClaim(k, v));
        String sign = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SING));
        return sign;
    }

    public static void verify(String token) throws UnsupportedEncodingException {
        JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }


    public static DecodedJWT getTokenInfo(String token) throws UnsupportedEncodingException {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
        return verify;
    }

}
