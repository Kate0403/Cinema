package com.example.cinema.entity;

import java.text.DecimalFormat;
import java.util.Objects;

public class Tickets {
    private Integer ID;
    private Integer Session_id;
    private DecimalFormat Price;
    private Integer User_id;

    public Tickets(Integer ID, Integer session_id, DecimalFormat price, Integer user_id) {
        this.ID = ID;
        Session_id = session_id;
        Price = price;
        User_id = user_id;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getSession_id() {
        return Session_id;
    }

    public void setSession_id(Integer session_id) {
        Session_id = session_id;
    }

    public DecimalFormat getPrice() {
        return Price;
    }

    public void setPrice(DecimalFormat price) {
        Price = price;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return Objects.equals(ID, tickets.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "ID=" + ID +
                ", Session_id=" + Session_id +
                ", Price=" + Price +
                ", User_id=" + User_id +
                '}';
    }
}
