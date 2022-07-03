package com.abidevel.oauth.gatewayservice.configuration;

import java.security.interfaces.RSAPublicKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class WebConfiguration {
    
    private final RSAPublicKey rKey;

    public WebConfiguration (RSAPublicKey rsaPublicKey) {
        this.rKey = rsaPublicKey;
    }

    @Bean
    SecurityWebFilterChain securityFilterChain (ServerHttpSecurity httpSecurity) throws Exception {
      return httpSecurity.authorizeExchange()
        .anyExchange()
        .authenticated()
        .and()
        .oauth2ResourceServer()
        .jwt((t) -> t.publicKey(rKey))
        .and()
        .csrf()
        .disable()
        .build();

    } 

}
