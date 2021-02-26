package com.innowise.duvalov.servlet;

import com.innowise.duvalov.command.Command;
import com.innowise.duvalov.command.PageList;
import com.innowise.duvalov.factory.CommandFactory;
import com.innowise.duvalov.pool.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private static final CommandFactory COMMAND_FACTORY = new CommandFactory();
    private final String SIGN_IN_PAGE = PageList.SIGNIN_FILE.getPath();

    @Override
    public void init() throws ServletException {
        ConnectionPool.INSTANCE.openPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(SIGN_IN_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = COMMAND_FACTORY.getCommand("CHECK_USER");
        command.execute(request, response);
        doGet(request, response);
    }
}
