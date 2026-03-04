package com.example.gatewayserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }

    @Bean
    public RouteLocator hrmsRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/hrms/trainings/**")
                        .filters(f -> f.rewritePath("/hrms/trainings/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://TRAINING-SERVICE"))
                .route(p -> p
                        .path("/hrms/users/**")
                        .filters(f -> f.rewritePath("/hrms/users/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://USER-SERVICE"))
                .route(p -> p
                        .path("/hrms/leaves/**")
                        .filters(f -> f.rewritePath("/hrms/leaves/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://LEAVE-SERVICE"))
                .route(p -> p
                .path("/hrms/reporting/**")
                .filters(f -> f.rewritePath("/hrms/reporting/(?<segment>.*)", "/${segment}")
                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                .uri("lb://REPORTING-SERVICE")).build();


    }

}
