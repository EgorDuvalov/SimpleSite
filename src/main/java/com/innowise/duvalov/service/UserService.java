package com.innowise.duvalov.service;

import com.innowise.duvalov.dao.UserDAO;
import com.innowise.duvalov.entity.User;
import com.innowise.duvalov.util.UserInputValidator;

public enum UserService {
    INSTANCE;

    public String signIn(String login, String pass) {
        UserInputValidator validator = new UserInputValidator();
        if (validator.isInputIncorrect(login, pass)) {
            return validator.getFeedback();
        }
        if (!validator.isLoginTaken(login)) {
            return validator.getFeedback();
        }
        if (!UserDAO.INSTANCE.isPassCorrect(login, pass)) {
            return "Wrong password!";
        }
        return "Signed In!";
    }

    public String signUp(String login, String pass, String role, String email) {
        UserInputValidator validator = new UserInputValidator();

        if (validator.isInputIncorrect(login, pass, role, email)) {
            return validator.getFeedback();
        }

        if (validator.isLoginTaken(login)) {
            return validator.getFeedback();
        }

        int roleNumber = Integer.parseInt(role);
        User user = new User(roleNumber, login, pass, email);
        UserDAO.INSTANCE.writeToDB(user);
        return "User '" + login + "' added successfully";
    }

}
