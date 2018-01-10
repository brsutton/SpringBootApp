package com.sutton.rental.dao;


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
public class PhotoDaoTest {

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
        jdbcTemplate.execute("CREATE TABLE `property_photos` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `propertyId` INT NULL,\n" +
                "  `photoFileLocation` VARCHAR(100) NULL,\n" +
                "  PRIMARY KEY (`id`));");
        jdbcTemplate.execute("INSERT INTO `property_photos` (`propertyId`, `photoFileLocation`) \n" +
                "  VALUES ('1', 'C:/Users/Brian Sutton/Pictures/285651-computer-backgrounds.jpg');");
    }

    @After
    public void clearDataBase() {
        jdbcTemplate.execute("drop table property_photos");
    }

    @Test
    public void getPropertyPhotoFromDatabaseByPropertyId() {
        PhotoDao photoDao = new PhotoDaoImpl(jdbcTemplate);
        Assert.assertEquals(1, photoDao.getPropertyPhotoByPropertyId(1).getPropertyId());
    }

}
