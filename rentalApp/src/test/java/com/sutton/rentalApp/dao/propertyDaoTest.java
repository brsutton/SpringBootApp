package com.sutton.rentalApp.dao;

import com.sutton.rentalApp.model.Property;
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
import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class propertyDaoTest {

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
        jdbcTemplate.execute("CREATE TABLE `property` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `streetAddress` VARCHAR(45) NULL,\n" +
                "  `city` VARCHAR(45) NULL,\n" +
                "  `state` VARCHAR(45) NULL,\n" +
                "  `zipCode` VARCHAR(45) NULL,\n" +
                "  `numberOfUnits` INT NULL,\n" +
                "  `managerId` INT NULL,\n" +
                "  `ownerId` INT NULL,\n" +
                "  `openUnits` INT NULL,\n" +
                "  `occupiedUnits` INT NULL,\n" +
                "  `maintenanceCost` DOUBLE NULL,\n" +
                "  `currentIncome` DOUBLE NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC));");
        jdbcTemplate.execute("INSERT INTO `property` (`name`, `streetAddress`, `city`, `state`, `zipCode`, `numberOfUnits`, `managerId`, `ownerId`, `openUnits`, `occupiedUnits`, `maintenanceCost`, `currentIncome`) VALUES ('HouseOne', '212 W Quarry', 'Maquoketa', 'Iowa', '52060', '1', '1', '1', '0', '1', '100', '500');");
    }

    @After
    public void clearDataBase() {
        jdbcTemplate.execute("drop table property");
    }


    @Test
    public void shouldAddPropertyToDatabaseAndReturnTrue() {
        PropertyDao propertyDao = new PropertyDaoImpl(jdbcTemplate);
        Property property = new Property();
        property.setName("house2");
        property.setStreetAddress("1234 3rd Street");
        property.setCity("Moline");
        property.setState("Illinois");
        property.setZipCode("54322");
        property.setNumberOfUnits(2);
        property.setManagerId(1);
        property.setOwnerId(1);
        property.setOpenUnits(1);
        property.setOccupiedUnits(1);
        property.setMaintenanceCost(100);
        property.setCurrentIncome(500);
        Assert.assertEquals(true, propertyDao.addProperty(property));
    }

    @Test
    public void shouldTryToAddPropertyAndReturnFalse() {
        PropertyDao propertyDao = new PropertyDaoImpl(jdbcTemplate);
        Property property = new Property();
        property.setName("house2xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        Assert.assertEquals(false, propertyDao.addProperty(property));
    }

    @Test
    public void shouldGetAllPropertiesByOwnerId() {
        PropertyDao propertyDao = new PropertyDaoImpl(jdbcTemplate);
        List<Property> list = propertyDao.getPropertiesByOwnerId(1);
        Assert.assertEquals("HouseOne", list.get(0).getName());
    }

    @Test
    public void shouldReturnEmptyListIfNoPropertiesWithOwnerId() {
        PropertyDao propertyDao = new PropertyDaoImpl(jdbcTemplate);
        List<Property> list = propertyDao.getPropertiesByOwnerId(3);
        Assert.assertEquals(0, list.size());
    }
}
