package com.example.cinema.entity;

import lombok.Builder;
import lombok.Value;

import java.sql.Date;

@Builder
@Value
public class Sessions {
    private Integer ID;
    private Integer Film_id;
    private Integer Hall_id;
    private Date Date;
    private Integer Number_tikets;


}
