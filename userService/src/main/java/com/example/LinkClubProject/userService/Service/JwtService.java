package com.example.LinkClubProject.userService.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.LinkClubProject.userService.Entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service 
public class JwtService {

    @Value("${jwt.secretKey}")
    private  String JwtSecretKey;
    
    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(JwtSecretKey.getBytes(StandardCharsets.UTF_8));

    }
    
    public String generatetoken(User user){
        return Jwts.builder()
                   .subject(user.getId().toString())
                   .claim("Email",user.getEmail())
                   .claim("Roles",Set.of("ADMIN","USER"))
                   .issuedAt(new Date())
                   .expiration(new Date(System.currentTimeMillis()+1000*60*10))
                   .signWith(getSecretKey())
                   .compact();
    }
}
