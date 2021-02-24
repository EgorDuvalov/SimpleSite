package com.innowise.duvalov.command;

import lombok.Getter;

public enum SQLCommandList {
    WRITE_USER_TO_DB("INSERT INTO USERS (login, password, role,email) VALUES (?,?,?,?)"),
    TAKE_USER_BY_LOGIN("SELECT COUNT(id) FROM users WHERE login = ?");

    @Getter
    private final String command;

    SQLCommandList(String command) {
        this.command = command;
    }
}

