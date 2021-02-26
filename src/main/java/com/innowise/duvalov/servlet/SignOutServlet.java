package com.innowise.duvalov.servlet;

import com.innowise.duvalov.command.PageList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignOutServlet extends HttpServlet {
    private static final String SIGN_OUT_PAGE = PageList.SIGNOUT_FILE.getPath();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(SIGN_OUT_PAGE).forward(request, response);
    }
}
