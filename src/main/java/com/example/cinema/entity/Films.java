package com.example.cinema.entity;

import lombok.Builder;
import lombok.Value;

import java.sql.Time;

@Builder
@Value
public class Films {
    private Integer ID;
    private String Title;
    private String Description;
    private String Genre;
    private Time Duration;
    private String Country;


}
