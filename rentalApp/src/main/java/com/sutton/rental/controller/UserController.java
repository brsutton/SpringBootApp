package com.sutton.rental.controller;

import com.sutton.rental.model.User;
import com.sutton.rental.service.UserService;
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

    @RequestMapping(value = Urls.UPDATE_USER_URL, method = RequestMethod.PUT)
    public boolean updateUserPassword(@RequestBody User user) {
        return userService.updateUserPassword(user);
    }

    @RequestMapping(value = Urls.UPDATE_USER_URL, method = RequestMethod.POST)
    public boolean updateUserNameAndEmail(@RequestBody User user) {
        return userService.updateUserNameAndEmail(user);
    }
}
