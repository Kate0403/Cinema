package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.text.DecimalFormat;
import java.util.Objects;

@JsonPropertyOrder({"id", "session_id", "price", "user_id"})
public class TicketsDto {
    private final Integer ID;
    private final Integer Session_id;
    private final DecimalFormat Price;
    private final Integer User_id;

    public TicketsDto(Integer ID, Integer session_id, DecimalFormat price, Integer user_id) {
        this.ID = ID;
        Session_id = session_id;
        Price = price;
        User_id = user_id;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getSession_id() {
        return Session_id;
    }

    public DecimalFormat getPrice() {
        return Price;
    }

    public Integer getUser_id() {
        return User_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketsDto that = (TicketsDto) o;
        return Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "TicketsDto{" +
                "ID=" + ID +
                ", Session_id=" + Session_id +
                ", Price=" + Price +
                ", User_id=" + User_id +
                '}';
    }
}
