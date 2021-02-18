package com.innowise.duvalov.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class User {

    private int id;
    private String login;
    private Role role;
    private String password;

    public User() {

    }

    public User(String role, String login, String password) {
        this.role = (role.equals("1")) ? Role.Admin : Role.Client;
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + login + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}
