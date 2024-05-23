package com.js.polarbookshop.edgeservice.config;

import reactor.core.publisher.Mono;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver; // Import the missing KeyResolver class
import java.security.Principal;


@Configuration
public class RateLimiterConfig {

    @Bean
    public KeyResolver keyResolver(){
        return exchange -> exchange.getPrincipal()
            .map(Principal::getName)
            .defaultIfEmpty("anonymous");
    }
}
