package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;
import io.jsonwebtoken.security.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static MacAlgorithm alg = Jwts.SIG.HS512;
    private static String secretKey = "itheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheimaitheima";
    private static SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
//    private static SecretKey key = Jwts.SIG.HS512.key().build();
    private static Long expire = 43200000L;

    public static String generateJwt(Map<String, Object> claims) {
        claims.put("id", 1);
        claims.put("name", "Tom");


//        return Jwts.builder()
//                .claims(claims)
//                .expiration(new Date(System.currentTimeMillis() + expire))
//                .signWith(key, Jwts.SIG.HS512)
//                .compact();

        return Jwts.builder()
                .signWith(key)
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + expire))
                .compact();
    }

    public static Claims parseJwt(String jwt) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }
}
