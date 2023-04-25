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
        return hallsDao.findAll().stream().map(Halls -> HallsDto.builder()
                        .ID(Halls.getID())
                        .Cinema_id(Halls.getCinema_id())
                        .Name(Halls.getName())
                .Number_seats(Halls.getNumber_seats()).build()
        ).collect(toList());
    }
    public static HallService getInstance() {
        return INSTANCE;
    }
}
