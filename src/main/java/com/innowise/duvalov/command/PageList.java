package com.innowise.duvalov.command;

import lombok.Getter;

public enum PageList {
    HOME_FILE("/index.jspjsp"),
    SIGNIN_FILE("/views/signin.jsp"),
    SIGNUP_FILE("/views/signup.jsp");
    @Getter
    String path;

    PageList(String path) {
        this.path = path;
    }

}
