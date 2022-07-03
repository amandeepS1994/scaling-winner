package com.abidevel.oauth.gatewayservice.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {
    private final RouteLocatorBuilder routeLocatorBuilder;
    private final ServiceConfiguration serviceConfiguration;


    public RouteConfiguration(RouteLocatorBuilder routeLocatorBuilder, ServiceConfiguration serviceConfiguration) {
        this.routeLocatorBuilder = routeLocatorBuilder;
        this.serviceConfiguration = serviceConfiguration;
    }


    @Bean
    RouteLocator configureRoutes( RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
            .route("oauth", r -> 
                r.path("/api/authentication/**")
                .uri(serviceConfiguration.getOauthServicehURL()) 
            ).route("oauth", r -> 
                r.path("/api/user/**")
                .uri(serviceConfiguration.getOauthServicehURL()) 
            ).route("oauth", r -> 
                r.path("/api/client/**")
                .uri(serviceConfiguration.getOauthServicehURL()) 
            ).route("oauth", r -> 
                r.path("/api/oauth/**")
                .uri(serviceConfiguration.getOauthServicehURL()) 
            ).route("health", r -> 
                r.path("/api/health/**")
                .uri(serviceConfiguration.getHealthServiceURL())
            ).route("health", r -> 
                r.path("/api/advice/**")
                .uri(serviceConfiguration.getHealthServiceURL())
            ).route("health", r -> 
                r.path("/api/metric/**")
                .uri(serviceConfiguration.getHealthServiceURL())
        ).build();
    }

}
