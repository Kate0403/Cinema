package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

@JsonPropertyOrder({"id", "cinema_id", "name", "number_seats"})
@Builder
@Value
public class HallsDto {
    private final Integer ID;
    private final Integer Cinema_id;
    private final String Name;
    private final Integer Number_seats;


}
