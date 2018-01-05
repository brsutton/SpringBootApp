package com.sutton.rentalApp.service;

import com.sutton.rentalApp.dao.UserDao;
import com.sutton.rentalApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {

    }

    protected UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User getUserByLogin(User user) {
        User dataBaseUser = userDao.getUserByLogin(user.getLogin());
        String password = user.getPassword() + dataBaseUser.getSalt();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = messageDigest.digest(password.getBytes());
            user.setPassword(new String(hashedPassword));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (dataBaseUser.getPassword().equals(user.getPassword())) {
            dataBaseUser.setPassword("_");
            dataBaseUser.setSalt("_");
            return dataBaseUser;
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        if (user.getLogin() == null || user.getPassword() == null) {
            return false;
        }
        String chars = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()";
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < 11; x++) {
            sb.append(chars.charAt(random.nextInt(chars.length() - 1)));
        }
        user.setSalt(sb.toString());
        String password = user.getPassword() + user.getSalt();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = messageDigest.digest(password.getBytes());
            user.setPassword(new String(hashedPassword));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDao.addUser(user);
    }

}
