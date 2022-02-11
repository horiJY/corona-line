package com.jy.coronaline.controller.api;

import static org.springframework.web.servlet.function.ServerResponse.ok;
import static org.springframework.web.servlet.function.ServerResponse.created;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class APIPlaceHandler { // 메서드 형식은 HandlerFunction을 implements하면 기본 형식이 나옴

    public ServerResponse getPlaces(ServerRequest request) {
        return ok().body(List.of("place1", "place2"));
    }

    public ServerResponse getPlace(ServerRequest request) {
        return ok().body("place " + request.pathVariable("placeId"));
    }

    public ServerResponse createPlace(ServerRequest request) {
        // http create 성공 시 201 코드 return하기 위함
        return created(URI.create("/api/places/1")).body(List.of("place1", "place2")); // TODO
    }

    public ServerResponse modifyPlace(ServerRequest request) {
        return ok().body(true);
    }

    public ServerResponse deletePlace(ServerRequest request) {
        return ok().body(true);
    }

}
