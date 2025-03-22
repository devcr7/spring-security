package com.shukldi.spring_secuirty.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {

    @Value("${security.jwt.secret-key}")
    private static String SECRET_KEY;

    public String extractUserName(String token) {
        return null;
    }

    private Claims extractAllClaims(String token) {
       return Jwts.parser()
               .setSigningKey(getSigningKey())
               .build()
               .parseClaimsJws(token)
               .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
