package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({"id", "full_name", "login_phone", "password"})
public class UsersDto {
    private final Integer ID;
    private final String Full_name;
    private final Integer Login_phone;
    private final String Password;

    public UsersDto(Integer ID, String full_name, Integer login_phone, String password) {
        this.ID = ID;
        Full_name = full_name;
        Login_phone = login_phone;
        Password = password;
    }

    public Integer getID() {
        return ID;
    }

    public String getFull_name() {
        return Full_name;
    }

    public Integer getLogin_phone() {
        return Login_phone;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersDto usersDto = (UsersDto) o;
        return Objects.equals(ID, usersDto.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "UsersDto{" +
                "ID=" + ID +
                ", Full_name='" + Full_name + '\'' +
                ", Login_phone=" + Login_phone +
                ", Password='" + Password + '\'' +
                '}';
    }
}
