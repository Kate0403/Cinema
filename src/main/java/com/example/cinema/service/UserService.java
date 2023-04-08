package com.example.cinema.service;

import com.example.cinema.dao.UsersDao;
import com.example.cinema.dto.UsersDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final UsersDao usersDao = UsersDao.getInstance();

    public UserService() {
    }

    public List<UsersDto> findAll(){
        return usersDao.findAll().stream().map(Users -> new UsersDto(Users.getID(), Users.getFull_name(), Users.getLogin_phone(), Users.getPassword())).collect(toList());
    }
    public static UserService getInstance() {
        return INSTANCE;
    }
}
