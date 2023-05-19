package com.example.cinema.mapper;

import com.example.cinema.entity.Users;
import com.example.cinema.dto.UsersDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsersMapper implements Mapper<Users, UsersDto>{

    private static final UsersMapper INSTANCE = new UsersMapper();
    @Override
    public UsersDto mapFrom(Users object) {
        return UsersDto.builder()
                .ID(object.getID())
                .Full_name(object.getFull_name())
                .Login_phone(object.getLogin_phone())
                .build();
    }
    public static UsersMapper getInstance(){
        return INSTANCE;
    }

}
