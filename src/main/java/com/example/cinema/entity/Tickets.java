package com.example.cinema.entity;

import lombok.Builder;
import lombok.Value;

import java.text.DecimalFormat;

@Builder
@Value
public class Tickets {
    private Integer ID;
    private Integer Session_id;
    private DecimalFormat Price;
    private Integer User_id;


}
