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
        return cinemasDao.findAll().stream().map(Cinemas -> CinemasDto.builder()
                .ID(Cinemas.getID())
                .Name(Cinemas.getName())
                .Phone(Cinemas.getPhone())
                .Address(Cinemas.getAddress())
                        .build()
                ).collect(toList());
    }
    public static CinemaService getInstance() {
        return INSTANCE;
    }
}
