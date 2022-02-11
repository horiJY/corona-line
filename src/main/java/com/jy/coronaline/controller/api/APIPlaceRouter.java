package com.jy.coronaline.controller.api;

import static org.springframework.web.servlet.function.RequestPredicates.path;
import static org.springframework.web.servlet.function.RouterFunctions.route;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * APIPlaceRouter
 */

@Configuration
public class APIPlaceRouter {

    @Bean
    // public RouterFunction<ServerResponse> placeRouter() {
    // routerFunction
    // return route().nest(path("/api/places"), builder -> builder
    // .GET("", req -> ServerResponse.ok().body(List.of("place1", "place2")))
    // .POST("", req -> ServerResponse.ok().body(true))
    // //아래 라인은 길다, 처리 로직이 길어지게되면 보는 것이 불편하다 -> handler분리
    // .GET("/{placeId}", req -> ServerResponse.ok().body("place "
    // + req.pathVariable("placeId")))
    // .PUT("/{placeId}", req -> ServerResponse.ok().body(true))
    // .DELETE("/{placeId}", req -> ServerResponse.ok().body(true))
    // ).build();

    // router + handler Function
    public RouterFunction<ServerResponse> placeRouter(APIPlaceHandler apiPlaceHandler) {
        return route().nest(path("/api/places"), builder -> builder
                .GET("", apiPlaceHandler::getPlaces)
                .POST("", apiPlaceHandler::createPlace)
                .GET("/{placeId}", apiPlaceHandler::getPlace)
                .PUT("/{placeId}", apiPlaceHandler::modifyPlace)
                .DELETE("/{placeId}", apiPlaceHandler::deletePlace)).build();
    }
}