package com.innowise.duvalov.dao;

import com.innowise.duvalov.entity.User;
import com.innowise.duvalov.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum UserDAO {
    INSTANCE;
    private static final String WRITE_USER_TO_DB =
            "INSERT INTO USERS (login, password, role,email) VALUES (?,?,?,?)";

    private static final String TAKE_USER_BY_LOGIN =
            "SELECT COUNT(id) FROM users WHERE login = ?";

    public void writeToDB(User user) {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(WRITE_USER_TO_DB)) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRole().getRoleNumber());
            ps.setString(4, user.getEmail());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns amount of users with provided login
     */
    public int findUserByLogin(String login) {
        ConnectionPool.INSTANCE.openPool();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement ps = connection.prepareStatement(TAKE_USER_BY_LOGIN)
        ) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 1;
    }
}
