package com.example.cinema.dao;

import com.example.cinema.entity.Cinemas;
import com.example.cinema.util.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CinemasDao implements Dao<Integer, Cinemas>{

    public static final CinemasDao INSTANCE = new CinemasDao();
    private static final String FIND_ALL= """
            SELECT *
            FROM Cinemas;
            """;
    private CinemasDao() {}

    @Override
    public List<Cinemas> findAll(){
        try(var connection = ConnectionDB.get();
            var preparedStarement = connection.prepareStatement(FIND_ALL)
        ){
            var resultSet = preparedStarement.executeQuery();
            List<Cinemas> cinemas = new ArrayList<>();

            while(resultSet.next()){
                cinemas.add(buildCinemas(resultSet));
            }

            return cinemas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Cinemas> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Cinemas entity) {

    }

    @Override
    public Cinemas save(Cinemas entity) {
        return null;
    }

    public static CinemasDao getInstance(){
        return INSTANCE;
    }

    private Cinemas buildCinemas(ResultSet resultSet) throws SQLException{

        return new Cinemas(
                resultSet.getObject("ID", Integer.class),
                resultSet.getObject("Name", String.class),
                resultSet.getObject("Phone", Integer.class),
                resultSet.getObject("Address", String.class)
        );
    }
}
