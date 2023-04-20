package com.example.cinema.mapper;

import com.example.cinema.dto.CreateUsersDto;
import com.example.cinema.entity.Users;


public class RegistrationUserMapper implements Mapper<CreateUsersDto, Users> {

    private static final RegistrationUserMapper INSTANCE = new RegistrationUserMapper();


    public static RegistrationUserMapper getInstance(){
        return INSTANCE;
    }

    @Override
    public Users mapFrom(CreateUsersDto object) {
        return Users.builder()
                .Full_name(object.getFull_name())
                .Login_phone(object.getLogin_phone())
                .Password(object.getPassword())
                .build();
    }
}
