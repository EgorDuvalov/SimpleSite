package com.innowise.duvalov.command.impl;

import com.innowise.duvalov.command.Command;
import com.innowise.duvalov.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewUserCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("Feedback",
                UserService.INSTANCE.signUp(
                        request.getParameter("login"),
                        SecurityWorker.INSTANCE.hashPass(request),
                        request.getParameter("role"),
                        request.getParameter("email")));
    }
}

