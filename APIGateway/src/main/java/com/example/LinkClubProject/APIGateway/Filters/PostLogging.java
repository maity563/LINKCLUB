package com.example.LinkClubProject.APIGateway.Filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component 
@Slf4j 
public class PostLogging extends AbstractGatewayFilterFactory<Object> {

    public PostLogging(){
        super(Object.class);
    }


    @Override
    public GatewayFilter apply(Object config) {
         return (exchange,chain)->{

              log.warn("This is User Microservice");

              return chain.filter(exchange);
              
             
         };
      
    }

    

}
