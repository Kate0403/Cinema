package com.example.cinema.dao;

import com.example.cinema.entity.Sessions;
import com.example.cinema.util.ConnectionDB;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SessionsDao implements Dao<Integer, Sessions>{
    public static final SessionsDao INSTANCE = new SessionsDao();
    private static final String FIND_ALL= """
            SELECT *
            FROM Sessions;
            """;

    private SessionsDao() {}

    @Override
    public List<Sessions> findAll() {
        try(var connection = ConnectionDB.get();
            var preparedStarement = connection.prepareStatement(FIND_ALL)
        ){
            var resultSet = preparedStarement.executeQuery();
            List<Sessions> sessions = new ArrayList<>();

            while(resultSet.next()){
                sessions.add(buildSessions(resultSet));
            }

            return sessions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional<Sessions> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Sessions entity) {

    }

    @Override
    public Sessions save(Sessions entity) {
        return null;
    }

    public static SessionsDao getInstance(){
        return INSTANCE;
    }


    private Sessions buildSessions(ResultSet resultSet) throws SQLException{

        return new Sessions(
                resultSet.getObject("ID", Integer.class),
                resultSet.getObject("Film_id", Integer.class),
                resultSet.getObject("Hall_id", Integer.class),
                resultSet.getObject("Date", Date.class),
                resultSet.getObject("Number_seats", Integer.class)
        );
    }
}
