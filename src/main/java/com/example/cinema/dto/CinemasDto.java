package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({"id", "name", "phone", "address"})
public class CinemasDto {

    private final Integer ID;
    private final String Name;
    private final Integer Phone;
    private final String Address;

    public CinemasDto(Integer ID, String name, Integer phone, String address) {
        this.ID = ID;
        Name = name;
        Phone = phone;
        Address = address;
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public Integer getPhone() {
        return Phone;
    }

    public String getAddress() {
        return Address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemasDto that = (CinemasDto) o;
        return Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "CinemasDto{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Phone=" + Phone +
                ", Address='" + Address + '\'' +
                '}';
    }
}
