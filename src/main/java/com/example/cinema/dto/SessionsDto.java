package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

@JsonPropertyOrder({"id", "film_id", "hall_id", "date", "number_tickets"})
@Builder
@Value
public class SessionsDto {
    private final Integer ID;
    private final Integer Film_id;
    private final Integer Hall_id;
    private final java.sql.Date Date;
    private final Integer Number_tikets;


}
