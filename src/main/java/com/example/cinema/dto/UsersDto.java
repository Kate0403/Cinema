package com.example.cinema.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

@JsonPropertyOrder({"id", "full_name", "login_phone", "password"})
@Value
public final class UsersDto {
    private final Integer ID;
    private final String Full_name;
    private final Integer Login_phone;
    private final String Password;

    UsersDto(Integer ID, String Full_name, Integer Login_phone, String Password) {
        this.ID = ID;
        this.Full_name = Full_name;
        this.Login_phone = Login_phone;
        this.Password = Password;
    }

    public static UsersDtoBuilder builder() {
        return new UsersDtoBuilder();
    }


    public static class UsersDtoBuilder {
        private Integer ID;
        private String Full_name;
        private Integer Login_phone;
        private String Password;

        UsersDtoBuilder() {
        }

        public UsersDtoBuilder ID(Integer ID) {
            this.ID = ID;
            return this;
        }

        public UsersDtoBuilder Full_name(String Full_name) {
            this.Full_name = Full_name;
            return this;
        }

        public UsersDtoBuilder Login_phone(Integer Login_phone) {
            this.Login_phone = Login_phone;
            return this;
        }

        public UsersDtoBuilder Password(String Password) {
            this.Password = Password;
            return this;
        }

        public UsersDto build() {
            return new UsersDto(ID, Full_name, Login_phone, Password);
        }

        public String toString() {
            return "UsersDto.UsersDtoBuilder(ID=" + this.ID + ", Full_name=" + this.Full_name + ", Login_phone=" + this.Login_phone + ", Password=" + this.Password + ")";
        }
    }
}
