package com.example.LinkClubProject.posts_service.Exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> notfoundresource(ResourceNotFoundException exception){
        ApiError apiError=new ApiError(HttpStatus.NOT_FOUND,exception.getLocalizedMessage());

        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> badrequestexceptionerror(BadRequestException exception){
        ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST,exception.getLocalizedMessage());

        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleruntime(RuntimeException exception){

        ApiError apiError=new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,exception.getLocalizedMessage());
        return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
}
