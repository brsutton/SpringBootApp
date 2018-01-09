package com.sutton.rental.dao;

import com.sutton.rental.model.User;
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
        jdbcTemplate.execute("CREATE TABLE `users` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `login` VARCHAR(20) NOT NULL,\n" +
                "  `password` VARCHAR(45) NULL,\n" +
                "  `salt` VARCHAR(15) NULL,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `email` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC),\n" +
                "  UNIQUE INDEX `login_UNIQUE` (`login` ASC));");
        jdbcTemplate.execute("insert into users (login, password, salt, name, email) " +
                "values('john', '�گ�+˩n�����\\u001a������!���k�\\u000b��', 'J!f%GSUOh^h', " +
                "'John', 'John@Doe')");
    }

    @After
    public void clearDataBase() {
        jdbcTemplate.execute("drop table users");
    }

    @Test
    public void shouldGetUserFromDatabaseByUserLogin() {
        UserDao userDao = new UserDaoImpl(jdbcTemplate);
        User user = userDao.getUserByLogin("john");
        Assert.assertEquals("john", user.getLogin());
    }

    @Test
    public void shouldReturnNullIfUserIsNotInDatabase() {
        UserDao userDao = new UserDaoImpl(jdbcTemplate);
        User user = userDao.getUserByLogin("joe");
        Assert.assertEquals(null, user);
    }
    @Test
    public void shouldAddUserToDatabase(){
        UserDao userDao = new UserDaoImpl(jdbcTemplate);
        User user = new User();
        user.setLogin("john2");
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
