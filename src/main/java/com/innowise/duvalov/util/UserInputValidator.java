package com.innowise.duvalov.util;

import com.innowise.duvalov.dao.UserDAO;
import com.innowise.duvalov.settings.DatabaseParameters;
import lombok.Data;
import lombok.Getter;

import java.util.regex.Pattern;

public final class UserInputValidator {
    private final int MAX_LOGIN = DatabaseParameters.MAX_LOGIN.getSize();
    private final int MAX_PASS = DatabaseParameters.MAX_PASS.getSize();
    private final int MAX_EMAIL = DatabaseParameters.MAX_EMAIL.getSize();

    @Getter
    private String feedback = "";

    public boolean isInputIncorrect(String login, String pass) {
        return (!checkLogin(login) || !checkPass(pass));
    }
    public boolean isInputIncorrect(String login, String pass, String role, String email) {
        return (!checkLogin(login) || !checkPass(pass) || !checkRole(role) || !checkEmail(email));
    }

    private boolean checkLogin(String login) {
        if (login.length() > MAX_LOGIN) {
            feedback = "Max login length is " + MAX_LOGIN + " symbols";
            return false;
        }
        String correctLoginForm = "\\b[\\w.]+\\b";
        if (!Pattern.matches(correctLoginForm, login)) {
            feedback = "Use latin letters, numerics, '.' or '_'";
            return false;
        }
        return true;
    }

    private boolean checkPass(String pass) {
        if (pass.length() > MAX_PASS) {
            int maxPassForInput = MAX_PASS / 2 - MAX_LOGIN;
            feedback = "Max password length is " + maxPassForInput + " symbols";
            return false;
        }
        String correctPassForm = "\\b[\\w.]+\\b";
        if (!Pattern.matches(correctPassForm, pass)) {
            feedback = "Use latin letters, numerics, '.' or '_'";
            return false;
        }
        return true;
    }

    private boolean checkRole(String role) {
        if (role == null || (!role.equals("0") && !role.equals("1"))) {
            feedback = "Incorrect role value";
            return false;
        }
        return true;
    }

    private boolean checkEmail(String email) {

        if (email.length() > MAX_EMAIL) {
            feedback = "Max email length is " + MAX_EMAIL + " symbols";
            return false;
        }
        String correctEmailForm = "\\b[A-Za-z0-9._]+@[A-Za-z]+\\.[A-Za-z]{2,4}\\b";
        if (!Pattern.matches(correctEmailForm, email)) {
            feedback = "Incorrect email form";
            return false;
        }
        return true;
    }

    public boolean isLoginTaken(String login) {
        if (UserDAO.INSTANCE.findUserByLogin(login) == 0) {
            return false;
        }
        feedback += "Login '" + login + "' is already taken";
        return true;
    }
}
