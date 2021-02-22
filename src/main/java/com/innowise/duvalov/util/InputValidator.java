package com.innowise.duvalov.util;

import com.innowise.duvalov.pool.ConnectionPool;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public final class InputValidator {

    private static final String TAKE_USER_BY_LOGIN =
            "SELECT COUNT(id) FROM users WHERE login = ?";

    private final String login;
    private final String pass;
    private final String role;
    private final String email;

    @Getter
    private String feedback = "";

    public InputValidator(String login, String pass, String role, String email) {
        this.login = login;
        this.pass = pass;
        this.role = role;
        this.email = email;
    }

    public boolean isInputIncorrect() {
        return (!checkLogin() || !checkPass() || !checkRole() || !checkEmail());
    }

    private boolean checkLogin() {
        if (login.length() > 25) {
            feedback = "Max login length is 65 symbols";
            return false;
        }
        String correctLoginForm = "\\b[\\w.]+\\b";
        if (!Pattern.matches(correctLoginForm, login)) {
            feedback = "Use latin letters, numerics, '.' or '_'";
            return false;
        }
        return true;
    }

    private boolean checkPass() {
        if (pass.length() > 25) {
            feedback = "Max password length is 25 symbols";
            return false;
        }
        String correctPassForm = "\\b[\\w.]+\\b";
        if (!Pattern.matches(correctPassForm, pass)) {
            feedback = "Use latin letters, numerics, '.' or '_'";
            return false;
        }
        return true;
    }

    private boolean checkRole() {
        if (role.equals("0") || role.equals("1")) {
            return true;
        }
        feedback = "Incorrect role value";
        return false;
    }

    private boolean checkEmail() {

        if (email.length() > 65) {
            feedback = "Max email length is 65 symbols";
            return false;
        }
        String correctEmailForm = "\\b[A-Za-z0-9._]+@[A-Za-z]+\\.[A-Za-z]{2,4}\\b";
        if (!Pattern.matches(correctEmailForm, email)) {
            feedback = "Incorrect email form";
            return false;
        }
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
