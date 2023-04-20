package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.sql.Time;

@JsonPropertyOrder({"id", "title", "description", "genre", "duration", "country"})
@Builder
@Value
public class FilmDto {

    private final Integer ID;
    private final String Title;
    private final String Description;
    private final String Genre;
    private final Time Duration;
    private final String Country;

}
