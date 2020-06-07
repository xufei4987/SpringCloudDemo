package com.youxu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder){
//        RouteLocatorBuilder.Builder routes = builder.routes();
////        routes.route("path_route_1", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
////                .route("path_route_2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji"));
//        routes.route("path_route_1", r -> r.path("/provider/payment/get/**").uri("http://localhost:8001/provider/payment/get/**"))
//                .route("path_route_2", r -> r.path("/provider/payment/lb/**").uri("http://localhost:8001/provider/payment/lb/**"));
//        return routes.build();
//    }
}
