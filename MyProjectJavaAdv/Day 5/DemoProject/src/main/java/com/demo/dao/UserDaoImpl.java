package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.User;

public class UserDaoImpl implements UserDao {

    @Override
    public User login(String email, String password) {

        User user = null;
        Connection conn = DBconnection.getMyConnection();

        if (conn == null) {
            System.out.println("❌ Database Connection Failed");
            return null;
        }

        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error in UserDaoImpl login()");
            e.printStackTrace();
        }

        return user;
    }
}