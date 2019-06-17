package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    boolean findByUsername(String username, String password);
    Long insert(User user);
    List<User> all(String username);

}
