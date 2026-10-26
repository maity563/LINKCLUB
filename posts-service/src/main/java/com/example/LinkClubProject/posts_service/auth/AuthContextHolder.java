package com.example.LinkClubProject.posts_service.auth;

import org.springframework.stereotype.Component;

@Component 
public class AuthContextHolder {

    private static final ThreadLocal<Long> currentuserId = new ThreadLocal<>();

    public static Long getuserId(){
       return  currentuserId.get();
    }

    static void currentsetuserId(Long userid){
          currentuserId.set(userid);
    }

    static void clear(){
        currentuserId.remove();
    }
    
}
