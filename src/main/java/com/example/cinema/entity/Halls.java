package com.example.cinema.entity;

import java.util.Objects;

public class Halls {
    private Integer ID;
    private Integer Cinema_id;
    private String Name;
    private Integer Number_seats;

    public Halls(Integer ID, Integer cinema_id, String name, Integer number_seats) {
        this.ID = ID;
        Cinema_id = cinema_id;
        Name = name;
        Number_seats = number_seats;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCinema_id() {
        return Cinema_id;
    }

    public void setCinema_id(Integer cinema_id) {
        Cinema_id = cinema_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getNumber_seats() {
        return Number_seats;
    }

    public void setNumber_seats(Integer number_seats) {
        Number_seats = number_seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Halls halls = (Halls) o;
        return Objects.equals(ID, halls.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Halls{" +
                "ID=" + ID +
                ", Cinema_id=" + Cinema_id +
                ", Name='" + Name + '\'' +
                ", Number_seats=" + Number_seats +
                '}';
    }
}
