package com.example.cinema.validation;

import com.example.cinema.dao.UsersDao;
import com.example.cinema.dto.CreateUsersDto;
import com.example.cinema.entity.Users;

public class RegistrationValidator implements Validation<CreateUsersDto>{


    private static final RegistrationValidator INSTANCE = new RegistrationValidator();

    private final RegistrationValidator registrationValidator = RegistrationValidator.getInstance();
    private final UsersDao usersDao = UsersDao.getInstance();
    @Override
    public ValidationResult isValide(CreateUsersDto object) {
        var validationResult = new ValidationResult();
        if (Users.getFull_name() == null){
            validationResult.add(Error.of("invalid.format", "Full name is invalid"));
        }
        return null;
    }

    public static RegistrationValidator getInstance(){
        return INSTANCE;
    }
}
