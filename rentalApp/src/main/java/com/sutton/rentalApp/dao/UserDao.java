package com.sutton.rentalApp.dao;

import com.sutton.rentalApp.model.User;

public interface UserDao {
    public User getUserByLogin(String login);
    public boolean addUser(User user);
}
