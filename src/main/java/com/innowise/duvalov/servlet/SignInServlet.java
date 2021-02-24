package com.innowise.duvalov.servlet;

import com.innowise.duvalov.command.Command;
import com.innowise.duvalov.factory.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private static final CommandFactory COMMAND_FACTORY = new CommandFactory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = COMMAND_FACTORY.getCommand("CHECK_USER");
        command.execute(request, response);
        //TODO incorrect pass or login
        command = COMMAND_FACTORY.getCommand("OPEN_SESSION");
        command.execute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
