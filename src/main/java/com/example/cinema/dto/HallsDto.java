package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({"id", "cinema_id", "name", "number_seats"})
public class HallsDto {
    private final Integer ID;
    private final Integer Cinema_id;
    private final String Name;
    private final Integer Number_seats;

    public HallsDto(Integer ID, Integer cinema_id, String name, Integer number_seats) {
        this.ID = ID;
        Cinema_id = cinema_id;
        Name = name;
        Number_seats = number_seats;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getCinema_id() {
        return Cinema_id;
    }

    public String getName() {
        return Name;
    }

    public Integer getNumber_seats() {
        return Number_seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HallsDto hallsDto = (HallsDto) o;
        return Objects.equals(ID, hallsDto.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "HallsDto{" +
                "ID=" + ID +
                ", Cinema_id=" + Cinema_id +
                ", Name='" + Name + '\'' +
                ", Number_seats=" + Number_seats +
                '}';
    }
}
