package com.innowise.duvalov.service;

import com.innowise.duvalov.dao.UserDAO;
import com.innowise.duvalov.entity.Role;
import com.innowise.duvalov.entity.User;
import com.innowise.duvalov.pool.ConnectionPool;
import com.innowise.duvalov.util.InputValidator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum UserService {
    INSTANCE;


    public String signUp(String login, String pass, String roleNumber, String email) {
        InputValidator validator = new InputValidator(login, pass, roleNumber, email);

        if (validator.isInputIncorrect()) {
            return validator.getFeedback();
        }

        if (validator.isLoginTaken()) {
            return validator.getFeedback();
        }

        User user = new User(roleNumber, login, pass, email);
        UserDAO.INSTANCE.writeToDB(user);
        return "User '" + login + "' added successfully";
    }

}
