package com.socialvista.socialmedia.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtProvider {
    private static SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
    
    public static String generateToken(Authentication auth){
        String jwt = Jwts.builder()
        .setIssuer("arpit_socialvista").setIssuedAt(new Date())
        .setExpiration(new Date(new Date().getTime()+86400000))
        .claim("email", auth.getName())
        .signWith(key)
        .compact();

        return jwt;
        
    }
}
