package com.innowise.duvalov.util;

import com.innowise.duvalov.dao.UserDAO;
import lombok.Getter;
import lombok.Setter;
import java.util.regex.Pattern;

public final class InputValidator {


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
        if (role == null || (!role.equals("0") && !role.equals("1"))) {
            feedback = "Incorrect role value";
            return false;
        }
        return true;
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
        if (UserDAO.INSTANCE.findUserByLogin(login) == 0) {
            return false;
        }
        feedback += "Login '" + login + "' is already taken";
        return true;
    }
}
