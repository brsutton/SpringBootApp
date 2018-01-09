package com.sutton.rental.service;


import com.sutton.rental.model.User;

public interface UserService {

    public User getUserByLogin(User user);

    public boolean addUser(User user);

    public boolean updateUserPassword(User user);

}
