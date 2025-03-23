package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.MacAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.*;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    public void testUuid() {
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "Tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheimatesttestestestsetestsetestestestestsetestestestestsetestestestestestestestest")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        MacAlgorithm alg = Jwts.SIG.HS256;
        SecretKey key = alg.key().build();
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTc0MTg4ODU2MX0.XXbOlY0uZUgSwCTw9s08sFOUsTmewbVznzOxRBHd6KA")
                .getPayload();
    }

}
