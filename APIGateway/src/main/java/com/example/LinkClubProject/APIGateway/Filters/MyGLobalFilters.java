package com.example.LinkClubProject.APIGateway.Filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j  
public class MyGLobalFilters implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // TODO Auto-generated method stub

        log.error("This is PRefilter  "+exchange.getRequest().getURI().toString());
        return chain.filter(exchange).then(
            Mono.fromRunnable(()->{

                log.error("This is Postfilter ");
            })
        );
    }
    
}
