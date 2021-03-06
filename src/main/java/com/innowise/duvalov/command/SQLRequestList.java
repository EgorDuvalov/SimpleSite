package com.innowise.duvalov.command;

import lombok.Getter;

public enum SQLRequestList {
    WRITE_USER_TO_DB("INSERT INTO USERS (login, password, role,email) VALUES (?,?,?,?)"),
    TAKE_USER_BY_LOGIN("SELECT COUNT(id) FROM users WHERE login = ?"),
    TAKE_PASS_BY_LOGIN("SELECT password FROM users WHERE login = ?");

    @Getter
    private final String command;

    SQLRequestList(String command) {
        this.command = command;
    }
}

