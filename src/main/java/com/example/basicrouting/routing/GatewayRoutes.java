package com.example.basicrouting.routing;

import com.example.basicrouting.config.Constants;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutes {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(Constants.SERVICE, r ->
                        r.path("/sv/**", "/reg/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://" + Constants.SERVICE))
                .build();
    }
}
