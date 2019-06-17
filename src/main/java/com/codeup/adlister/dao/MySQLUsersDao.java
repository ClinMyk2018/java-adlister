package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    private String createInsertQuery(User user) {
        return "INSERT INTO users(id, username, email, password) VALUES "
                + "(" + user.getId() + ", "
                + "'" + user.getUsername() + "', "
                + "'" + user.getEmail() + "', "
                + "'" + user.getPassword() + "')";
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getLong(1),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }


    @Override
    public User findByUsername(String username) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("select * from users where username = ?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            return extractUser(rs);

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving User.", e);
        }
    }

    @Override
    public Long insert(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createInsertQuery(user));
            preparedStatement.executeUpdate(createInsertQuery(user), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    private List<User> createUserFromResults(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(extractUser(rs));
        }
        return users;
    }

    @Override
    public List<User> all() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = preparedStatement.executeQuery();
            return createUserFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

}
