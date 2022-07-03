package com.abidevel.oauth.gatewayservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@PropertySource(value = "classpath:services.properties")
@Data
public class ServiceConfiguration {
    private final String oauthServicehURL;
    private final String healthServiceURL;

    public ServiceConfiguration (@Value("${healthx.oauth.url}") String oauthServicehURL, @Value("${healthx.oauth.url}") String healthServiceURL) {
        this.oauthServicehURL = oauthServicehURL;
        this.healthServiceURL = healthServiceURL;
    }
}
