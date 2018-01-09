package com.sutton.rentalApp.service;


import com.sutton.rentalApp.model.User;

public interface UserService {
    public User getUserByLogin(User user);

    public boolean addUser(User user);

}
