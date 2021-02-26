package com.innowise.duvalov.command.impl;

import com.innowise.duvalov.command.Command;
import com.innowise.duvalov.command.PageList;
import com.innowise.duvalov.config.UserInputConfig;
import com.innowise.duvalov.service.UserService;
import com.innowise.duvalov.util.UserInputValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewUserCommand implements Command {
    private final int iterationsAmount = UserInputConfig.HASH_PASS_ITERATIONS.getValue();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("Feedback",
                UserService.INSTANCE.signUp(
                        request.getParameter("login"),
                        SecurityWorker.INSTANCE.hashPass(request, iterationsAmount),
                        request.getParameter("role"),
                        request.getParameter("email")));
    }
}

