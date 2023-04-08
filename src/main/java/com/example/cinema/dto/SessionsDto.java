package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({"id", "film_id", "hall_id", "date", "number_tickets"})
public class SessionsDto {
    private final Integer ID;
    private final Integer Film_id;
    private final Integer Hall_id;
    private final java.sql.Date Date;
    private final Integer Number_tikets;

    public SessionsDto(Integer ID, Integer film_id, Integer hall_id, java.sql.Date date, Integer number_tikets) {
        this.ID = ID;
        Film_id = film_id;
        Hall_id = hall_id;
        Date = date;
        Number_tikets = number_tikets;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getFilm_id() {
        return Film_id;
    }

    public Integer getHall_id() {
        return Hall_id;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public Integer getNumber_tikets() {
        return Number_tikets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionsDto that = (SessionsDto) o;
        return Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "SessionsDto{" +
                "ID=" + ID +
                ", Film_id=" + Film_id +
                ", Hall_id=" + Hall_id +
                ", Date=" + Date +
                ", Number_tikets=" + Number_tikets +
                '}';
    }
}
