package com.sutton.rentalApp.controller;

import com.sutton.rentalApp.model.User;
import com.sutton.rentalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = Urls.USER_URL, method = RequestMethod.POST)
    public User verifyAndReturnUserFromDatabase(@RequestBody User user) {
        return userService.getUserByLogin(user);
    }

    @RequestMapping(value = Urls.USER_URL, method = RequestMethod.PUT)
    public boolean addUserToDataBase(@RequestBody User user) {
        return userService.addUser(user);
    }
}
