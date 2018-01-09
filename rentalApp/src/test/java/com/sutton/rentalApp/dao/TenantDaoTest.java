package com.sutton.rentalApp.dao;

import com.sutton.rentalApp.model.Tenant;
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
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TenantDaoTest {

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
        jdbcTemplate.execute("CREATE TABLE `tenant` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `unitId` INT NULL,\n" +
                "  `firstName` VARCHAR(45) NOT NULL,\n" +
                "  `lastName` VARCHAR(45) NOT NULL,\n" +
                "  `phoneNumber` VARCHAR(20) NULL,\n" +
                "  `email` VARCHAR(45) NULL,\n" +
                "  `moveInDate` DATE NULL,\n" +
                "  `leaseExpires` DATE NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC));");

        jdbcTemplate.execute("INSERT INTO `tenant` (`unitId`, `firstName`, `lastName`, `phoneNumber`, `email`," +
                " `moveInDate`, `leaseExpires`) VALUES ('1', 'John', 'Doe', '555-555-5555', 'John@Doe.com'," +
                " '2018-01-15', '2018-07-15');");
    }

    @After
    public void clearDataBase() {
        jdbcTemplate.execute("drop table tenant");
    }

    @Test
    public void shouldGetTenantFromDatabase() {
        TenantDao tenantDao = new TenantDaoImpl(jdbcTemplate);
        Assert.assertEquals("John", tenantDao.getTenantById(1).getFirstName());
    }

    @Test
    public void shouldAddTenantToDatabase() {
        TenantDao tenantDao = new TenantDaoImpl(jdbcTemplate);
        Tenant tenant = new Tenant();
        tenant.setUnitId(1);
        tenant.setFirstName("John");
        tenant.setLastName("Doe");
        tenant.setPhoneNumber("34");
        tenant.setEmail("jo@jo");
        Assert.assertEquals(true, tenantDao.addTenant(tenant));
    }

}
