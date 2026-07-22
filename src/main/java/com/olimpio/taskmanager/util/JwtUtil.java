package com.olimpio.taskmanager.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.key}")
    private String jwtKey;

    private SecretKey keyToken;

    @PostConstruct
    public void init() {
        keyToken = Keys.hmacShaKeyFor(jwtKey.getBytes());
    }


    public String gerarToken(String nameBody) {
        String token = Jwts.builder()
                .subject(nameBody)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3600000)) // 1h
                .signWith(keyToken)
                .compact();

        return token;
    }

    public Claims validarToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(keyToken)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims;
    }
}