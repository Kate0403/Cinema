package com.example.cinema.dao;

import com.example.cinema.entity.Halls;
import com.example.cinema.util.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HallsDao implements Dao<Integer, Halls>{

    public static final HallsDao INSTANCE = new HallsDao();
    private static final String FIND_ALL= """
            SELECT *
            FROM Halls;
            """;

    private HallsDao() {}

    @Override
    public List<Halls> findAll() {
        try(var connection = ConnectionDB.get();
            var preparedStarement = connection.prepareStatement(FIND_ALL)
        ){
            var resultSet = preparedStarement.executeQuery();
            List<Halls> halls = new ArrayList<>();

            while(resultSet.next()){
                halls.add(buildHalls(resultSet));
            }

            return halls;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional<Halls> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Halls entity) {

    }

    @Override
    public Halls save(Halls entity) {
        return null;
    }

    public static HallsDao getInstance(){
        return INSTANCE;
    }

    private Halls buildHalls(ResultSet resultSet) throws SQLException{

        return  Halls.builder().
                ID(resultSet.getObject("ID", Integer.class)).
                Cinema_id(resultSet.getObject("Cinema_id", Integer.class)).
                Name(resultSet.getObject("Name", String.class)).
                Number_seats(resultSet.getObject("Number_seats", Integer.class)).
                build();

    }

}
