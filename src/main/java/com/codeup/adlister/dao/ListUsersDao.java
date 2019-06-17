package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.ArrayList;
import java.util.List;

public class ListUsersDao implements Users {
    private List<User> users;

    public List<User> all() {
        if (users == null) {
            users = generateUser();
        }
        return users;
    }


    @Override
    public Long insert(User user) {
        if (users == null) {
            users = generateUser();
        }
        user.setId(users.size());
        users.add(user);
        return user.getId();
    }

    private List<User> generateUser() {
        List<User> user = new ArrayList<>();
        users.add(new User(
                1,
                "BigDude",
                "BigDude@live.com",
                "codeup"
        ));
        users.add(new User(
                2,
                "BigGirl",
                "BigGirl@live.com",
                "codeup"
        ));
        return users;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}