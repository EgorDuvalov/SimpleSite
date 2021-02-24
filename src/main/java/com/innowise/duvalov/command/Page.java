package com.innowise.duvalov.command;

import lombok.Getter;

public enum Page {
    SIGN_UP("Sign Up");

    @Getter
    private String commandName;


    Page(String commandName) {
        this.commandName=commandName;
    }

}
