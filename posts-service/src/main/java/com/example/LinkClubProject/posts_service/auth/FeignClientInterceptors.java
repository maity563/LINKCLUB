package com.example.LinkClubProject.posts_service.auth;

import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;


@Component 
public class FeignClientInterceptors implements RequestInterceptor{

    

    @Override
    public void apply(RequestTemplate requestTemplate) {
        
         Long userid=AuthContextHolder.getuserId();

          if(userid != null){

             requestTemplate.header("X-User-Id", userid.toString());
          }
    }
    
}
