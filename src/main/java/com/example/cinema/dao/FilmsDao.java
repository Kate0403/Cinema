package com.example.cinema.dao;

import com.example.cinema.entity.Films;
import com.example.cinema.util.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilmsDao implements Dao<Integer, Films>{

    public static final FilmsDao INSTANCE = new FilmsDao();
    private static final String FIND_ALL= """
            SELECT *
            FROM Films;
            """;


    private FilmsDao(){}
    @Override
    public List<Films> findAll() {
       try(var connection = ConnectionDB.get();
       var preparedStarement = connection.prepareStatement(FIND_ALL)
       ){
        var resultSet = preparedStarement.executeQuery();
       List<Films> films = new ArrayList<>();

       while(resultSet.next()){
          films.add(buildFilms(resultSet));
       }

       return films;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }



    @Override
    public Optional<Films> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Films entity) {

    }

    @Override
    public Films save(Films entity) {
        return null;
    }

public static FilmsDao getInstance(){
        return INSTANCE;
}

    private Films buildFilms(ResultSet resultSet) throws SQLException{

        return new Films(
                resultSet.getObject("ID", Integer.class),
                resultSet.getObject("Title", String.class),
                resultSet.getObject("Description", String.class),
                resultSet.getObject("Genre", String.class),
                resultSet.getObject("Duration", Time.class),
                resultSet.getObject("Country", String.class)
        );
    }
}
