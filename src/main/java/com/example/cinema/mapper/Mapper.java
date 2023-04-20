package com.example.cinema.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);
}
