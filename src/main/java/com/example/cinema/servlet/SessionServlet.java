package com.example.cinema.servlet;

import com.example.cinema.dto.UsersDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    private static final String USER = "user";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        var user = (UsersDto) session.getAttribute(USER);
        if(user == null){
            user = UsersDto.builder()
                    .ID(25)
                    .Full_name("Test Tester")
                    .Login_phone(28054137)
                    .build();
        }

        System.out.println(session.isNew());
    }
}
