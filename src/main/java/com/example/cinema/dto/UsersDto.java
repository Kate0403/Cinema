package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

@JsonPropertyOrder({"id", "full_name", "login_phone", "password"})
@Builder
@Value
public class UsersDto {
    private final Integer ID;
    private final String Full_name;
    private final Integer Login_phone;
    private final String Password;


}
