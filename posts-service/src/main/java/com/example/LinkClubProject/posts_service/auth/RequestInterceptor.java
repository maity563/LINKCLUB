package com.example.LinkClubProject.posts_service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
public class RequestInterceptor implements HandlerInterceptor {


    @Autowired AuthContextHolder authContextHolder;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String userid=request.getHeader("X-User-Id");
        AuthContextHolder.currentsetuserId(Long.valueOf(userid));
        return HandlerInterceptor.super.preHandle(request, response, handler);
	}

    @Override 
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


                AuthContextHolder.clear();
                HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
                
	}
    
}
