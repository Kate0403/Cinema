package com.example.cinema.entity;

import java.util.Objects;

public class Cinemas {
    private Integer ID;
    private String Name;
    private Integer Phone;
    private String Address;

    public Cinemas(Integer ID, String name, Integer phone, String address) {
        this.ID = ID;
        Name = name;
        Phone = phone;
        Address = address;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinemas cinemas = (Cinemas) o;
        return Objects.equals(ID, cinemas.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Cinemas{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Phone=" + Phone +
                ", Address='" + Address + '\'' +
                '}';
    }
}
