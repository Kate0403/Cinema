package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

@JsonPropertyOrder({"id", "name", "phone", "address"})
@Builder
@Value
public class CinemasDto {

    private final Integer ID;
    private final String Name;
    private final Integer Phone;
    private final String Address;


}
