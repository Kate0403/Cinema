package com.example.cinema.entity;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Halls {
    private Integer ID;
    private Integer Cinema_id;
    private String Name;
    private Integer Number_seats;


}
