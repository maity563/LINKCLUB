package com.example.LinkClubProject.APIGateway.Service;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service 
public class JwtService {

    @Value("${jwt.secretKey}")
    private String secretKey;

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public Long getuserid(String token){

        Claims claim= Jwts.parser()
                          .verifyWith(getSecretKey())
                          .build()
                          .parseSignedClaims(token)
                          .getPayload();
                        
         String userid=claim.getSubject();
         
         return Long.valueOf(userid);
    }
    
}
