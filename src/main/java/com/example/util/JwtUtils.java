package com.example.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JwtUtils {

    private static final String secret = "xiaoading03302116";

    private JwtUtils() {
    }

    public static String createJwt(String userInfo, List<String> authList) {
        Date issDate = new Date();
        Date expireDate = new Date(issDate.getTime() + 1000 * 60 * 60 * 24 * 3);
        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("alg", "HS256");
        headerClaims.put("typ", "JWT");
        return JWT.create().withHeader(headerClaims)
                .withIssuer("yunbowu")
                .withIssuedAt(issDate)
                .withExpiresAt(expireDate)
                .withClaim("user_info", userInfo)    // 自定义声明
                .withClaim("userAuth", authList)
                .sign(Algorithm.HMAC256(secret));   // 使用HS256进行签名，使用secret作为密钥
    }

    // 校验token
    public static boolean verifyToken(String token) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT verify = jwtVerifier.verify(token);
            log.info("token校验正确");
            /**
             *      获取自定义的声明参数
             * Integer userId = verify.getClaim("userId").asInt();
             * String username = verify.getClaim("username").asString();
             * List<String> userAuth = verify.getClaim("userAuth").asList(String.class);
             */
            return true;
        } catch (Exception e) {
            log.error("token校验不正确");
            return false;
        }
    }

    public static String getUserInfo(String token) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            return decodedJWT.getClaim("user_info").asString();
        } catch (IllegalArgumentException e) {
            return "";
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    public static List<String> getUserAuth(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT verify = verifier.verify(token);
            return verify.getClaim("userAuth").asList(String.class);
        } catch (IllegalArgumentException e) {
            return null;
        } catch (JWTVerificationException e) {
            return null;
        }

    }


}
