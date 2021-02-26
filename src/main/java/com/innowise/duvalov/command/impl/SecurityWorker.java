package com.innowise.duvalov.command.impl;

import javax.servlet.http.HttpServletRequest;

enum SecurityWorker {
    INSTANCE;

    String hashPass(HttpServletRequest request, int iterationsAmount) {
        String mix = request.getParameter("pass") + request.getParameter("login");
        StringBuilder pass = new StringBuilder(mix);
        for (int j = 0; j < iterationsAmount; j++) {
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
        }
        StringBuilder s = new StringBuilder(pass.substring(pass.length() / 4));
        pass.insert(0, s);
        s.reverse();
        pass.insert(pass.length(), s);
        return pass.toString();
    }
}
