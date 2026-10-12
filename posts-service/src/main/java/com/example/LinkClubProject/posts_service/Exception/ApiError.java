package com.example.LinkClubProject.posts_service.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.Data;

@Data 
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
