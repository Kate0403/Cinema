package com.example.cinema.servlet;

import com.example.cinema.dto.UsersDto;
import com.example.cinema.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userService.login(req.getParameter("login_phone"), req.getParameter("password"))
                .ifPresentOrElse(
                        users -> onLoginSucces(users, req, resp),
                        () -> onLoginFail()
                );

    }
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp){
    resp.sendRedirect("/login");
    }
    @SneakyThrows
    private void onLoginSucces(UsersDto users, HttpServletRequest req, HttpServletResponse resp){
        req.getSession().getAttribute("users", users);
        resp.sendRedirect("/flights");
    }
}
