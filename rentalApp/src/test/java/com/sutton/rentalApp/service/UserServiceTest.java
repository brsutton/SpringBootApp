package com.sutton.rentalApp.service;

import com.sutton.rentalApp.dao.UserDao;
import com.sutton.rentalApp.dao.UserDaoImpl;
import com.sutton.rentalApp.model.User;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {


    @Test
    public void shouldAddUserToDataBaseAndThenReturnTrue() {
        UserDao userDao = mock(UserDaoImpl.class);
        User user = new User();
        user.setLogin("john");
        user.setPassword("hello");
        when(userDao.addUser(user)).thenReturn(true);
        UserService userService = new UserServiceImpl(userDao);
        Assert.assertEquals(true, userService.addUser(user));
    }

    @Test
    public void shouldReturnFalseWhenAddingUserWithNoPassword(){
        UserDao userDao = mock(UserDaoImpl.class);
        User user = new User();
        user.setLogin("john");
        when(userDao.addUser(user)).thenReturn(true);
        UserService userService = new UserServiceImpl(userDao);
        Assert.assertEquals(false, userService.addUser(user));
    }

    @Test
    public void shouldReturnFalseWhenAddingUserWithLogin(){
        UserDao userDao = mock(UserDaoImpl.class);
        User user = new User();
        when(userDao.addUser(user)).thenReturn(true);
        UserService userService = new UserServiceImpl(userDao);
        Assert.assertEquals(false, userService.addUser(user));
    }

    @Test
    public void shouldGetUserFromTheDataBaseAndVerifyTheUser(){
        UserDao userDao = mock(UserDaoImpl.class);
        User user = new User();
        user.setLogin("brian");
        user.setPassword("�گ�+˩n�����\u001A������!���k�\u000B��");
        user.setSalt("J!f%GSUOh^h");
        when(userDao.getUserByLogin("brian")).thenReturn(user);
        User loggingInUser = new User();
        loggingInUser.setLogin("brian");
        loggingInUser.setPassword("root");
        UserService userService = new UserServiceImpl(userDao);
        Assert.assertEquals("brian", userService.getUserByLogin(loggingInUser).getLogin());
    }

    @Test
    public void shouldGetUserFromTheDataBaseAndVerifyTheUserTheUserPasswordIsWrongAndReturnsNull(){
        UserDao userDao = mock(UserDaoImpl.class);
        User user = new User();
        user.setLogin("brian");
        user.setPassword("�گ�+˩n�����\u001A������!���k�\u000B��");
        user.setSalt("J!f%GSUOh^h");
        when(userDao.getUserByLogin("brian")).thenReturn(user);
        User loggingInUser = new User();
        loggingInUser.setLogin("brian");
        loggingInUser.setPassword("wrongPassword");
        UserService userService = new UserServiceImpl(userDao);
        Assert.assertEquals(null, userService.getUserByLogin(loggingInUser));
    }
}
