package com.innowise.duvalov.servlet;

import com.innowise.duvalov.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Feedback",
                UserService.INSTANCE.signUp(
                        request.getParameter("login"),
                        request.getParameter("pass"),
                        request.getParameter("role"),
                        request.getParameter("email")));
        doGet(request, response);
    }
}
