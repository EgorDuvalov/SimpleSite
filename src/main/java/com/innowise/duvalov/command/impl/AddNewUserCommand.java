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
        String mix = request.getParameter("pass") + request.getParameter("login");
        StringBuilder pass = new StringBuilder(mix);
        pass.reverse();
        for (int i = 0; i < pass.length(); i++) {
            int symb = pass.charAt(i);
            if (symb > 47 && symb < 58) {
                symb = 58 - symb + 47;
            } else if (symb > 64 && symb < 91) {
                symb = 91 - symb + 64 + 32; // switch letters and cast to Upper Case
            } else if (symb > 96 && symb < 123) {
                symb = 123 - symb + 96 - 32;
            }
            pass.setCharAt(i, (char) symb);
        }
        StringBuilder s = new StringBuilder(pass.substring(pass.length() / 4));
        pass.insert(0, s);
        s.reverse();
        pass.insert(pass.length(), s);
        return pass.toString();
    }
}

