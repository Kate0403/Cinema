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
    return filmDao.findAll().stream().map(Films -> new FilmDto(Films.getID(), Films.getTitle(), Films.getDescription(), Films.getGenre(), Films.getDuration(), Films.getCountry())).collect(toList());
    }
    public static FilmService getInstance() {
        return INSTANCE;
    }
}
