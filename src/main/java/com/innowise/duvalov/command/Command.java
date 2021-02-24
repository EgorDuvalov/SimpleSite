package com.innowise.duvalov.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;

public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response);
}
