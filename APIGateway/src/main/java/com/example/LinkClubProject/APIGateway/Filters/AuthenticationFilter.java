package com.example.LinkClubProject.APIGateway.Filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.example.LinkClubProject.APIGateway.Service.JwtService;

import lombok.extern.slf4j.Slf4j;

@Component 
@Slf4j 
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    public AuthenticationFilter(){
        super(Config.class);
    }



    public static  class Config{

    }


    @Autowired JwtService jwtService;

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange,chain) ->{

            String path= exchange.getRequest().getURI().getPath();

            
            log.error("Path = "+path);
            if(path.equals("/api/v1/user/auth/signup") || path.equals("/api/v1/user/auth/login")){

                
                return chain.filter(exchange);
            }


              final String tokenheader=exchange.getRequest().getHeaders().getFirst("Authorization");
              if(tokenheader == null || !tokenheader.startsWith("Bearer ") ){
                  return exchange.getResponse().setComplete();
              }
              String token= tokenheader.split("Bearer ")[1];

              log.error("Token = "+token);

              Long userid=jwtService.getuserid(token);

             ServerHttpRequest httprequest=exchange.getRequest().mutate().header("X-User-Id", String.valueOf(userid)).build();

             ServerWebExchange webexchange=exchange.mutate().request(httprequest).build();

             return chain.filter(webexchange);
        };
        
    }
    
}
