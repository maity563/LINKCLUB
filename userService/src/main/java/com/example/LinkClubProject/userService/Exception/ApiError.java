package com.example.LinkClubProject.userService.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiError {

     public LocalDateTime localDateTime;
    public String error;
    public HttpStatus httpStatus;

    public ApiError(){
        this.localDateTime=LocalDateTime.now();
    }

    public ApiError(HttpStatus httpStatus, String error) {
        this();
        this.httpStatus = httpStatus;
        this.error = error;
    }
    
}
