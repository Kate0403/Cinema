package com.example.cinema.entity;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Cinemas {
    private Integer ID;
    private String Name;
    private Integer Phone;
    private String Address;


}
