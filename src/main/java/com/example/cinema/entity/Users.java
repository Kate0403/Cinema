package com.example.cinema.entity;

import java.util.Objects;

public class Users {
    private Integer ID;
    private String Full_name;
    private Integer Login_phone;
    private String Password;

    public Users(Integer ID, String full_name, Integer login_phone, String password) {
        this.ID = ID;
        Full_name = full_name;
        Login_phone = login_phone;
        Password = password;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFull_name() {
        return Full_name;
    }

    public void setFull_name(String full_name) {
        Full_name = full_name;
    }

    public Integer getLogin_phone() {
        return Login_phone;
    }

    public void setLogin_phone(Integer login_phone) {
        Login_phone = login_phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(ID, users.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Users{" +
                "ID=" + ID +
                ", Full_name='" + Full_name + '\'' +
                ", Login_phone=" + Login_phone +
                ", Password='" + Password + '\'' +
                '}';
    }
}
