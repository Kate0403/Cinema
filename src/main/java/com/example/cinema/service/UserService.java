package com.example.cinema.service;

import com.example.cinema.dao.UsersDao;
import com.example.cinema.dto.CreateUsersDto;
import com.example.cinema.dto.UsersDto;
import com.example.cinema.exeption.RegistrationExeption;
import com.example.cinema.mapper.RegistrationUserMapper;
import com.example.cinema.mapper.UsersMapper;
import com.example.cinema.validation.RegistrationValidator;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final RegistrationUserMapper registrationUserMapper = RegistrationUserMapper.getInstance();
    private final RegistrationValidator registrationValidator = RegistrationValidator.getInstance();
    private final UsersDao usersDao = UsersDao.getInstance();

    private final UsersMapper usersMapper = UsersMapper.getInstance();
    public Optional<UsersDto> login(String login_phone, String password){
return  usersDao.findByPhoneAndPassword(login_phone, password)
        .map(usersMapper::mapFrom);
    }


    private UserService() {
    }

    public Integer registration(CreateUsersDto usersDto){
        var validationResult = registrationValidator.isValide(usersDto);
        if(validationResult.isValid()){
            throw new RegistrationExeption(validationResult.getErrors());
        }
        var userEntity = registrationUserMapper.mapFrom(usersDto);
        usersDao.save(userEntity);
        return userEntity.getID();
        //validation
        //map
        //userDto.save
        //return id
    }

    public List<UsersDto> findAll(){
        return usersDao.findAll().stream().map(Users -> UsersDto.builder()
                                .ID(Users.getID())
                                .Full_name(Users.getFull_name())
                                .Login_phone(Users.getLogin_phone())
                        .Password(Users.getPassword())
                .build()
        ).collect(toList());
    }
    public static UserService getInstance() {
        return INSTANCE;
    }
}
