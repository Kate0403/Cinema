package com.example.cinema.entity;

import java.util.Objects;
import java.sql.*;

public class Films {
    private Integer ID;
    private String Title;
    private String Description;
    private String Genre;
    private Time Duration;
    private String Country;

    public Films(Integer id, String title, String description, String genre, Time duration, String country) {
        ID = id;
        Title = title;
        Description = description;
        Genre = genre;
        Duration = duration;
        Country = country;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getGenre() {
        return Genre;
    }

    public Time getDuration() {
        return Duration;
    }

    public void setDuration(Time duration) {
        Duration = duration;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Films films = (Films) o;
        return Objects.equals(ID, films.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Films{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Duration=" + Duration +
                ", Country='" + Country + '\'' +
                '}';
    }
}
