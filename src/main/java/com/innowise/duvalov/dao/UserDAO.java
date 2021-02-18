package com.innowise.duvalov.dao;

import com.innowise.duvalov.entity.User;
import com.innowise.duvalov.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private static final String WRITE_USER_TO_DB =
            "INSERT INTO USERS (login, password, role) VALUES (?,?,?)";

    public void writeToDB(User user) {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(WRITE_USER_TO_DB)) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRole().getRoleNumber());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
