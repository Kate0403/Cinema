package com.example.cinema.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
private static final String URL_KEY="db.url";
private static final String USER_KEY="db.user";
private static final String PASSWORD_KEY="db.password";

static {
    loadDriver();
}

    private static void loadDriver() {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            // handle the error
        }
    }

    private ConnectionDB(){
    }

    public static Connection get(){
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USER_KEY),
                    PropertiesUtil.get(PASSWORD_KEY));
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
