package com.example.cinema.entity;
import java.sql.*;
import java.util.Objects;

public class Sessions {
    private Integer ID;
    private Integer Film_id;
    private Integer Hall_id;
    private Date Date;
    private Integer Number_tikets;

    public Sessions(Integer ID, Integer film_id, Integer hall_id, java.sql.Date date, Integer number_tikets) {
        this.ID = ID;
        Film_id = film_id;
        Hall_id = hall_id;
        Date = date;
        Number_tikets = number_tikets;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getFilm_id() {
        return Film_id;
    }

    public void setFilm_id(Integer film_id) {
        Film_id = film_id;
    }

    public Integer getHall_id() {
        return Hall_id;
    }

    public void setHall_id(Integer hall_id) {
        Hall_id = hall_id;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public Integer getNumber_tikets() {
        return Number_tikets;
    }

    public void setNumber_tikets(Integer number_tikets) {
        Number_tikets = number_tikets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sessions sessions = (Sessions) o;
        return Objects.equals(ID, sessions.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Sessions{" +
                "ID=" + ID +
                ", Film_id=" + Film_id +
                ", Hall_id=" + Hall_id +
                ", Date=" + Date +
                ", Number_tikets=" + Number_tikets +
                '}';
    }
}
