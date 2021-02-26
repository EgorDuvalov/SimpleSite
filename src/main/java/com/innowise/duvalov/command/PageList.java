package com.innowise.duvalov.command;

import lombok.Getter;

public enum PageList {
    HOME_FILE("/index.jsp"),
    SIGNIN_FILE("/views/signin.jsp"),
    SIGNUP_FILE("/views/signup.jsp"),
    SIGNOUT_FILE("/views/signout.jsp");
    @Getter
    String path;

    PageList(String path) {
        this.path = path;
    }

}
