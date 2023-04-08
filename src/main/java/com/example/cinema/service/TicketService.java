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
        return ticketsDao.findAll().stream().map(Tickets -> new TicketsDto(Tickets.getID(), Tickets.getSession_id(), Tickets.getPrice(), Tickets.getUser_id())).collect(toList());
    }
    public static TicketService getInstance() {
        return INSTANCE;
    }
}
