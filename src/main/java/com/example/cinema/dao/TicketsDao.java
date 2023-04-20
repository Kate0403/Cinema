package com.example.cinema.dao;

import com.example.cinema.entity.Tickets;
import com.example.cinema.util.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketsDao implements Dao<Integer, Tickets>{

    public static final TicketsDao INSTANCE = new TicketsDao();
    private static final String FIND_ALL= """
            SELECT *
            FROM Tickets;
            """;

    private TicketsDao() {}

    @Override
    public List<Tickets> findAll() {
        try(var connection = ConnectionDB.get();
            var preparedStarement = connection.prepareStatement(FIND_ALL)
        ){
            var resultSet = preparedStarement.executeQuery();
            List<Tickets> tickets = new ArrayList<>();

            while(resultSet.next()){
                tickets.add(buildTickets(resultSet));
            }

            return tickets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Tickets> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Tickets entity) {

    }

    @Override
    public Tickets save(Tickets entity) {
        return null;
    }

    public static TicketsDao getInstance(){
        return INSTANCE;
    }

    private Tickets buildTickets(ResultSet resultSet) throws SQLException{

        return Tickets(
                resultSet.getObject("ID", Integer.class),
                resultSet.getObject("Session_id", Integer.class),
                resultSet.getObject("Price", DecimalFormat.class),
                resultSet.getObject("User_id", Integer.class)
        );
    }


}
