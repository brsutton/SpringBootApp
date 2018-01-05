package com.sutton.rentalApp.dao;

import com.sutton.rentalApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    public UserDaoImpl(){

    }
    protected UserDaoImpl(JdbcTemplate jdbcTemplate){
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
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(), new Object[]{login});
        if (users.size()==0){
            users.add(new User());
        }
        return users.get(0);
    }

    @Override
    public boolean addUser(User user) {
        boolean success = true;
        String sql = "INSERT INTO users (login, password, salt, name, email) VALUES (?, ?, ?, ?, ?)";
        try{
            jdbcTemplate.update(sql, new Object[]{user.getLogin(), user.getPassword(), user.getSalt(), user.getName(), user.getEmail() });
        }catch (Exception e){
            success = false;
        }

        return success;
    }
}
