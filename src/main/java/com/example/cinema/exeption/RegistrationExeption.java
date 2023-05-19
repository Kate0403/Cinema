package com.example.cinema.exeption;

import lombok.Getter;
import com.example.cinema.validation.Error;
import java.util.List;

public class RegistrationExeption extends RuntimeException{

    @Getter
    private final List<Error> errors;

    public RegistrationExeption(List<Error> errors){
        this.errors=errors;
    }

}
