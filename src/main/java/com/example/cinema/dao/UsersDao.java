package com.example.cinema.dao;

import com.example.cinema.entity.Users;
import com.example.cinema.util.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDao implements Dao<Integer, Users>{

    public static final UsersDao INSTANCE = new UsersDao();
    private static final String FIND_ALL= """
            SELECT *
            FROM Users;
            """;

    private UsersDao() {}

    @Override
    public List<Users> findAll() {
        try(var connection = ConnectionDB.get();
            var preparedStarement = connection.prepareStatement(FIND_ALL)
        ){
            var resultSet = preparedStarement.executeQuery();
            List<Users> users = new ArrayList<>();

            while(resultSet.next()){
                users.add(buildUsers(resultSet));
            }

            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Users> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Users entity) {

    }

    @Override
    public Users save(Users entity) {
        return null;
    }

    public static UsersDao getInstance(){
        return INSTANCE;
    }

    private Users buildUsers(ResultSet resultSet) throws SQLException{

        return new Users(
                resultSet.getObject("ID", Integer.class),
                resultSet.getObject("Full_name", String.class),
                resultSet.getObject("Login_phone", Integer.class),
                resultSet.getObject("Password", String.class)
        );
    }
}
