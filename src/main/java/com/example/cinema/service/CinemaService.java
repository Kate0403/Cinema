package com.example.cinema.service;

import com.example.cinema.dao.CinemasDao;
import com.example.cinema.dto.CinemasDto;


import java.util.List;

import static java.util.stream.Collectors.toList;

public class CinemaService {

    private static final CinemaService INSTANCE = new CinemaService();

    private final CinemasDao cinemasDao = CinemasDao.getInstance();

    private CinemaService() {
    }

    public List<CinemasDto> findAll(){
        return cinemasDao.findAll().stream().map(Cinemas -> new CinemasDto(Cinemas.getID(), Cinemas.getName(), Cinemas.getPhone(), Cinemas.getAddress())).collect(toList());
    }
    public static CinemaService getInstance() {
        return INSTANCE;
    }
}
