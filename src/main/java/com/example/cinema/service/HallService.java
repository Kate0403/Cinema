package com.example.cinema.service;

import com.example.cinema.dao.HallsDao;
import com.example.cinema.dto.HallsDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class HallService {

    private static final HallService INSTANCE = new HallService();

    private final HallsDao hallsDao = HallsDao.getInstance();

    private HallService() {
    }

    public List<HallsDto> findAll(){
        return hallsDao.findAll().stream().map(Halls -> new HallsDto(Halls.getID(), Halls.getCinema_id(), Halls.getName(), Halls.getNumber_seats())).collect(toList());
    }
    public static HallService getInstance() {
        return INSTANCE;
    }
}
