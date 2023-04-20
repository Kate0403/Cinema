package com.example.cinema.validation;

public interface Validation<T> {

    ValidationResult isValide(T object);


}
