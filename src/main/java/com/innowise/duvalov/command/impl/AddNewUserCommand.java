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
                        hashPass(request),
                        request.getParameter("role"),
                        request.getParameter("email")));
    }

    private String hashPass(HttpServletRequest request) {
        StringBuilder pass = new StringBuilder(request.getParameter("pass"));
        pass.reverse();
        for (int i = 0; i < pass.length(); i++) {
            byte tmp = (byte) pass.charAt(i);
            tmp += i;
            pass.setCharAt(i, (char) tmp);
        }
        StringBuilder s = new StringBuilder(pass.substring(pass.length() / 2));
        pass.insert(0, s);
        s.reverse();
        pass.append(s);
        return pass.toString();
    }
}

