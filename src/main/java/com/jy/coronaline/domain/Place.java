package com.jy.coronaline.domain;

import java.time.LocalDateTime;

import com.jy.coronaline.constant.PlaceType;

import lombok.Data;

@Data
public class Place {
    private Long id;

    private PlaceType placeType;
    private String placeName;
    private String address;
    private String phoneNumber;
    private Integer capacity;
    private String memo;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    // private enum PlaceType {
    // COMMON, SPORTS, RESTAURANT, PARTY
    // }
}
