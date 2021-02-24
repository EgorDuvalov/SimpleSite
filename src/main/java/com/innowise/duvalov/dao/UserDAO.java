package com.innowise.duvalov.dao;

import com.innowise.duvalov.command.SQLCommandList;
import com.innowise.duvalov.entity.User;
import com.innowise.duvalov.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum UserDAO {
    INSTANCE;

    public void writeToDB(User user) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQLCommandList.WRITE_USER_TO_DB.getCommand())
        ) {
            int parameterIndex = 0;
            ps.setString(++parameterIndex, user.getLogin());
            ps.setString(++parameterIndex, user.getPassword());
            ps.setInt(++parameterIndex, user.getRole().getRoleNumber());
            ps.setString(++parameterIndex, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns amount of users with provided login
     */
    public int findUserByLogin(String login) {
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQLCommandList.TAKE_USER_BY_LOGIN.getCommand())
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
