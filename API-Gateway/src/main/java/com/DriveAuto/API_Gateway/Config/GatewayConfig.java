package com.DriveAuto.API_Gateway.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {
        @Bean
        public RouteLocator routeLocator(RouteLocatorBuilder builder) {
            return builder.routes()
                    .route(p -> p.path("/api/s1/users/**").uri("http://localhost:8081/api/s1"))
                    .route(p -> p.path("/api/s7/admin/**").uri("http://localhost:8087/api/s7"))
                    .route(p -> p.path("/api/s3/courses/**").uri("http://course-service:8083"))
                    .route(p -> p.path("/api/s5/quizzes/**").uri("http://quiz-service:8085"))
                    .route(p -> p.path("/api/s4/questions/**").uri("http://question-service:8084"))
                    .route(p -> p.path("/api/s6/notifications/**").uri("http://notification-service:8086"))
                    .build();
        }

}