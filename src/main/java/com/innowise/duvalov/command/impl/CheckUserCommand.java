package com.innowise.duvalov.command.impl;

import com.innowise.duvalov.command.Command;
import com.innowise.duvalov.command.PageList;
import com.innowise.duvalov.factory.CommandFactory;
import com.innowise.duvalov.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckUserCommand implements Command {
    private static final CommandFactory COMMAND_FACTORY = new CommandFactory();
    private final String SIGN_IN_PAGE = PageList.SIGNIN_FILE.getPath();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Feedback",
                UserService.INSTANCE.signIn(
                        request.getParameter("login"),
                        request.getParameter("pass")));
        if (request.getAttribute("Feedback").equals("Signed In!")) {
            Command command = COMMAND_FACTORY.getCommand("OPEN_SESSION");
            command.execute(request, response);
        } else {
            request.getRequestDispatcher(SIGN_IN_PAGE).forward(request, response);
        }
    }
}
