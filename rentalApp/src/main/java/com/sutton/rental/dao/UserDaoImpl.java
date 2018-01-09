package com.sutton.rental.dao;

import com.sutton.rental.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {

    }

    protected UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private DataSource dataSource;

    public JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public User getUserByLogin(String login) {
        String sql = "select * from users where login = ?";
        List<User> users = null;
        User user = null;
        try {
            users = jdbcTemplate.query(sql, new UserRowMapper(), new Object[]{login});
            if (users.size() != 0) {
                user = users.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean addUser(User user) {
        boolean success = true;
        String sql = "INSERT INTO users (login, password, salt, name, email) VALUES (?, ?, ?, ?, ?)";
        int result = 0;
        try {
            result = jdbcTemplate.update(sql, user.getLogin(), user.getPassword(), user.getSalt(), user.getName(), user.getEmail());
            if (result == 0) {
                success = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }

        return success;
    }

    @Override
    public boolean updateUserPassword(User user) {
        boolean success = true;
        String sql = "UPDATE `users` SET `password`= ?, `salt`= ? WHERE `id`= ?;";
        int result = 0;
        try {
            result = jdbcTemplate.update(sql, user.getPassword(), user.getSalt(), user.getId());
            if (result == 0) {
                success = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }

        return success;
    }

    @Override
    public boolean updateUserNameAndEmail(User user) {
        boolean success = true;
        String sql = "UPDATE `users` SET `name`= ?, `email`= ? WHERE `id`= ?;";
        int result = 0;
        try {
            result = jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());
            if (result == 0) {
                success = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }

        return success;
    }
}
