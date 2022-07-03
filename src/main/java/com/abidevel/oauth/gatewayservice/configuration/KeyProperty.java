package com.abidevel.oauth.gatewayservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@PropertySource("classpath:key.properties")
@ConfigurationProperties(prefix = "spring.auth")
@Data
public class KeyProperty {
    private String publicKey;
}
