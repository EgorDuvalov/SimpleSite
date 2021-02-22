package com.innowise.duvalov.entity;

import lombok.Data;

@Data
public class User {

    private int id;
    private String login;
    private Role role;
    private String password;
    private String email;

    public User(int role, String login, String password, String email) {
        this.role = Role.getRoleByNumber(role);
        this.login = login;
        this.password = password;
        this.email = email;
    }
}
