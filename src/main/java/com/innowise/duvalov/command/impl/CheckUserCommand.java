package com.innowise.duvalov.command.impl;

import com.innowise.duvalov.command.Command;
import com.innowise.duvalov.command.PageList;
import com.innowise.duvalov.config.UserInputConfig;
import com.innowise.duvalov.factory.CommandFactory;
import com.innowise.duvalov.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckUserCommand implements Command {
    private static final CommandFactory COMMAND_FACTORY = new CommandFactory();
    private final String SIGN_IN_PAGE = PageList.SIGNIN_FILE.getPath();
    private final int iterationsAmount = UserInputConfig.HASH_PASS_ITERATIONS.getValue();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Feedback",
                UserService.INSTANCE.signIn(
                        request.getParameter("login"),
                        SecurityWorker.INSTANCE.hashPass(request, iterationsAmount)));
        if (request.getAttribute("Feedback").equals("Signed In!")) {
            Command command = COMMAND_FACTORY.getCommand("OPEN_SESSION");
            command.execute(request, response);
        }
    }
}
