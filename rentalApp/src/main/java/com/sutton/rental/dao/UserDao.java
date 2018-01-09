package com.sutton.rental.dao;

import com.sutton.rental.model.User;

public interface UserDao {

    public User getUserByLogin(String login);

    public boolean addUser(User user);

    public boolean updateUserPassword(User user);
}
