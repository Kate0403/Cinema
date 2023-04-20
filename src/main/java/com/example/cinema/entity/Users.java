package com.example.cinema.entity;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Users {
    private Integer ID;
    private String Full_name;
    private Integer Login_phone;
    private String Password;


}
