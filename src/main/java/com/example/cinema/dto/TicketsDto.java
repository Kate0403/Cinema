package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

import java.text.DecimalFormat;

@JsonPropertyOrder({"id", "session_id", "price", "user_id"})
@Builder
@Value
public class TicketsDto {
    private final Integer ID;
    private final Integer Session_id;
    private final DecimalFormat Price;
    private final Integer User_id;


}
