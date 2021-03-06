package com.innowise.duvalov.command.impl;

import com.innowise.duvalov.command.Command;
import com.innowise.duvalov.command.PageList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OpenSessionCommand implements Command {
    private static int CURRENT_USERS_NUM = 0;
    private final String HOME_PAGE = PageList.HOME_FILE.getPath();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("current_user", request.getParameter("login"));
    }
}
