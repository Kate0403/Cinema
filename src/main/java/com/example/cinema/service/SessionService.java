package com.example.cinema.service;

import com.example.cinema.dao.SessionsDao;
import com.example.cinema.dto.SessionsDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SessionService {
    private static final SessionService INSTANCE = new SessionService();

    private final SessionsDao sessionsDao = SessionsDao.getInstance();

    public SessionService() {
    }

    public List<SessionsDto> findAll(){
        return sessionsDao.findAll().stream().map(Sessions -> new SessionsDto(Sessions.getID(), Sessions.getFilm_id(), Sessions.getHall_id(), Sessions.getDate(), Sessions.getNumber_tikets())).collect(toList());
    }
    public static SessionService getInstance() {
        return INSTANCE;
    }
}


