package com.example.cinema.dao;


import com.example.cinema.entity.Users;
import com.example.cinema.util.ConnectionDB;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDao implements Dao<Integer, Users>{

    public static final UsersDao INSTANCE = new UsersDao();
    private static final String FIND_ALL= """
            SELECT *
            FROM Users;
            """;
    private static final String REGISTER_USER = """
            INSERT INTO Users ("Full_name", "Login_phone", "Password")
            VALUES (?, ?, ?)
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
    @SneakyThrows
    public Users save(Users entity) {
        try(var connection = ConnectionDB.get();
            var preparedStarement = connection.prepareStatement(REGISTER_USER, Statement.RETURN_GENERATED_KEYS)
        ){
          preparedStarement.setObject(1, entity.getFull_name());
          preparedStarement.setObject(2, entity.getLogin_phone());
          preparedStarement.setObject(3, entity.getPassword());

          preparedStarement.executeUpdate();

          var generatedKeys = preparedStarement.getGeneratedKeys();
          generatedKeys.next();
          entity.builder().ID(generatedKeys.getObject("id", Integer.class));

          return entity;
        }

    }

    public static UsersDao getInstance(){
        return INSTANCE;
    }

    private Users buildUsers(ResultSet resultSet) throws SQLException{

        return Users.builder().
                ID(resultSet.getObject("ID", Integer.class)).
                Full_name(resultSet.getObject("Full_name", String.class)).
                Login_phone(resultSet.getObject("Login_phone", Integer.class)).
                Password(resultSet.getObject("Password", String.class)).
                build();
    }
}
