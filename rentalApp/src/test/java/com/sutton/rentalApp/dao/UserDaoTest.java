package com.sutton.rentalApp.dao;

import com.sutton.rentalApp.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserDaoTest {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }


    @Before
    public void setUpDatabase() {
        jdbcTemplate.execute("create table users(login varchar(10) NOT NULL, password varchar(60) NOT NULL, salt varchar(12) NOT NULL, name varchar(50), email varchar(40), PRIMARY KEY(login))");
        jdbcTemplate.execute("insert into users (login, password, salt, name, email) values('brian', '�گ�+˩n�����\\u001a������!���k�\\u000b��', 'J!f%GSUOh^h', 'Brian Sutton', 'brian@yash')");
    }

    @After
    public void clearDataBase() {
        jdbcTemplate.execute("drop table users");
    }

    @Test
    public void shouldGetUserFromDatabaseByUserLogin() {
        UserDao userDao = new UserDaoImpl(jdbcTemplate);
        User user = userDao.getUserByLogin("brian");
        Assert.assertEquals("brian", user.getLogin());
    }

    @Test
    public void shouldReturnBlankUserIfUserIsNotInDatabase() {
        UserDao userDao = new UserDaoImpl(jdbcTemplate);
        User user = userDao.getUserByLogin("bran");
        Assert.assertEquals(null, user.getName());
    }
    @Test
    public void shouldAddUserToDatabase(){
        UserDao userDao = new UserDaoImpl(jdbcTemplate);
        User user = new User();
        user.setLogin("john");
        user.setPassword("�گ�+˩n�����\u001A������!���k�\u000B��");
        user.setSalt("J!f%GSUOh^h");
        user.setName("John Doe");
        user.setEmail("john@john.com");
        Assert.assertEquals(true, userDao.addUser(user));

    }

    @Test
    public void shouldReturnFalseIfUserLoginIsMissing(){
        UserDao userDao = new UserDaoImpl(jdbcTemplate);
        User user = new User();
        user.setPassword("�گ�+˩n�����\u001A������!���k�\u000B��");
        user.setSalt("J!f%GSUOh^h");
        user.setName("John Doe");
        user.setEmail("john@john.com");
        Assert.assertEquals(false, userDao.addUser(user));
    }
}