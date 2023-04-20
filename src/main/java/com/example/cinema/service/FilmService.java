package com.example.cinema.service;

import com.example.cinema.dao.FilmsDao;
import com.example.cinema.dto.FilmDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilmService {



    private static final FilmService INSTANCE = new FilmService();

    private final FilmsDao filmDao = FilmsDao.getInstance();

    private FilmService(){

    }
    public List<FilmDto> findAll(){
    return filmDao.findAll().stream().map(Films -> FilmDto.builder()
            .ID(Films.getID())
            .Title(Films.getTitle())
            .Description(Films.getDescription())
            .Genre(Films.getGenre())
            .Duration(Films.getDuration())
            .Country(Films.getCountry()).build())
            .collect(toList());
    }
    public static FilmService getInstance() {
        return INSTANCE;
    }
}
