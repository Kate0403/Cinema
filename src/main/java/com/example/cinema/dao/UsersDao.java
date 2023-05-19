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
    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL = """
            SELECT * FROM users WHERE login_phone= ? AND password = ?;
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

    @SneakyThrows
    public Optional<Users> findByPhoneAndPassword(String login_phone, String password) {
        try(var connection = ConnectionDB.get();
        var prepareStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL)){
        prepareStatement.setString(1, login_phone);
        prepareStatement.setString(2, password);

        var resultSet = prepareStatement.executeQuery();
        Users user = null;
        if(resultSet.next()){
    user = Users.builder()
            .ID(resultSet.getObject("ID", Integer.class))
            .Full_name(resultSet.getObject("Full_name", String.class))
            .Login_phone(resultSet.getObject("Login_phone", Integer.class))
            .Password(resultSet.getObject("Password", String.class))
            .build();
        }
        return Optional.ofNullable(user);
        }
      //  return Optional.empty();
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
//может быть поьребуется дописать .name() для преобразоапния в строку
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
