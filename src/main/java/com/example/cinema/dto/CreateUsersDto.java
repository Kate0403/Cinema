package com.example.cinema.dto;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUsersDto {
     String Full_name;
     Integer Login_phone;
     String Password;
}
