package com.example.LinkClubProject.userService.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration 
public class AiConfig {
    
    @Bean 
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    
}


