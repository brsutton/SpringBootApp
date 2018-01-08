package com.sutton.rentalApp.dao;

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
public class UnitDaoTest {

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
        jdbcTemplate.execute("CREATE TABLE `units` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `tenantId` INT NULL,\n" +
                "  `bedrooms` INT NULL,\n" +
                "  `bathrooms` INT NULL,\n" +
                "  `squareFeet` INT NULL,\n" +
                "  `unitName` VARCHAR(45) NOT NULL,\n" +
                "  `unitDescription` LONGTEXT NULL,\n" +
                "  `unitRent` DOUBLE NULL,\n" +
                "  `backRent` DOUBLE NULL,\n" +
                "  `occupied` TINYINT NULL,\n" +
                "  `maintenanceNeeded` TINYINT NULL,\n" +
                "  `maintenanceDescription` LONGTEXT NULL,\n" +
                "  `maintenanceCost` DOUBLE NULL,\n" +
                "  `depositHeld` DOUBLE NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC));");
        jdbcTemplate.execute("INSERT INTO `units` (`tenantId`, `bedrooms`, `bathrooms`, `squareFeet`," +
                " `unitName`, `unitDescription`, `unitRent`, `backRent`, `occupied`, `maintenanceNeeded`, " +
                " `maintenanceDescription`, `maintenanceCost`, `depositHeld`) " +
                "VALUES ('1', '1', '1', '600', '10', 'Apartment', '500', '0', '1', '0', 'None', '0', '500');");
    }

    @After
    public void clearDataBase() {
        jdbcTemplate.execute("drop table units");
    }

    @Test
    public void shouldGetUnitFromDatabase() {
        UnitDao unitDao = new UnitDaoImpl(jdbcTemplate);
        Assert.assertEquals("10", unitDao.getUnitById(1).getUnitName());
    }

    @Test
    public void shouldReturnEmptyList() {
        UnitDao unitDao = new UnitDaoImpl(jdbcTemplate);
        Assert.assertEquals(null, unitDao.getUnitById(0));
    }

}
