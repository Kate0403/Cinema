package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.sql.Time;
import java.util.Objects;

@JsonPropertyOrder({"id", "title", "description", "genre", "duration", "country"})
public class FilmDto {

    private final Integer ID;
    private final String Title;
    private final String Description;
    private final String Genre;
    private final Time Duration;
    private final String Country;


    public FilmDto(Integer id, String title, String description, String genre, Time duration, String country) {
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
    public String getDescription() {
        return Description;
    }
    public String getTitle() {return Title;}
    public String getGenre() {return Genre;}

    public Time getDuration() {
        return Duration;
    }
    public String getCountry() {
        return Country;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmDto filmDto = (FilmDto) o;
        return Objects.equals(ID, filmDto.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "FilmDto{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Duration=" + Duration +
                ", Country='" + Country + '\'' +
                '}';
    }
}
