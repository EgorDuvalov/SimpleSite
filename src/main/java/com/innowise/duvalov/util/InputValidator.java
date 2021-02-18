package com.innowise.duvalov.util;

import com.innowise.duvalov.pool.ConnectionPool;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class InputValidator {

    private static final String TAKE_USER_BY_LOGIN =
            "SELECT COUNT(id) FROM users WHERE login = ?";

    private final String login;
    private final String pass;
    private final String role;

    @Getter
    private String feedback = "";

    public InputValidator(String login, String pass, String role) {
        this.login = login;
        this.pass = pass;
        this.role = role;
    }

    public boolean isInputIncorrect() {
        return (!checkLogin() || !checkPass() || !checkRole());
    }

    private boolean checkLogin() {
        return true;
    }

    private boolean checkPass() {
        return true;
    }

    private boolean checkRole() {
        return true;
    }

    public boolean isLoginTaken() {
        ConnectionPool.INSTANCE.openPool();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement ps = connection.prepareStatement(TAKE_USER_BY_LOGIN)
        ) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        feedback += "Login '" + login + "' is already taken";
        return true;
    }
}
