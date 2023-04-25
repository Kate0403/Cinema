package com.example.cinema.service;

import com.example.cinema.dao.TicketsDao;
import com.example.cinema.dto.TicketsDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TicketService {

    private static final TicketService INSTANCE = new TicketService();

    private final TicketsDao ticketsDao = TicketsDao.getInstance();
    public TicketService() {
    }

    public List<TicketsDto> findAll(){
        return ticketsDao.findAll().stream().map(Tickets -> TicketsDto.builder()
                        .ID(Tickets.getID())
                        .Session_id(Tickets.getSession_id())
                        .Price(Tickets.getPrice())
                .User_id(Tickets.getUser_id())
                .build()
        ).collect(toList());
    }
    public static TicketService getInstance() {
        return INSTANCE;
    }
}
