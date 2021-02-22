package com.innowise.duvalov.command.sql;

import lombok.Getter;

public enum SQLCommands {
    WRITE_USER_TO_DB("INSERT INTO USERS (login, password, role,email) VALUES (?,?,?,?)"),
    TAKE_USER_BY_LOGIN("SELECT COUNT(id) FROM users WHERE login = ?");

    @Getter
    private String command;

    SQLCommands(String command) {
        this.command = command;
    }

}
