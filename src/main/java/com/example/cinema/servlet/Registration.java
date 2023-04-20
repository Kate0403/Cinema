package com.example.cinema.servlet;


import com.example.cinema.dto.CreateUsersDto;
import com.example.cinema.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registration")
public class Registration  extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        var usersDto = CreateUsersDto.builder()
                .Full_name(req.getParameter("Full_name"))
                .Login_phone(Integer.valueOf(req.getParameter("Login_phone")))
                .Password(req.getParameter("Password"))
                        .build();

        userService.registration(usersDto);
        resp.sendRedirect("/login");
    }
}
