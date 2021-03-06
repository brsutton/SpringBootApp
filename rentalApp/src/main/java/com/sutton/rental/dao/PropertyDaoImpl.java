package com.sutton.rental.dao;

import com.sutton.rental.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PropertyDaoImpl implements PropertyDao {

    public PropertyDaoImpl() {

    }

    protected PropertyDaoImpl(JdbcTemplate jdbcTemplate) {
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
    public boolean addProperty(Property property) {
        boolean success = true;
        String sql = "INSERT INTO `property` (`name`, `streetAddress`, `city`, `state`, `zipCode`, `numberOfUnits`, `managerId`, `ownerId`, `openUnits`, `occupiedUnits`, `maintenanceCost`, `currentIncome`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        int result = 0;
        try {
            result = jdbcTemplate.update(sql, property.getName(), property.getStreetAddress(), property.getCity(), property.getState(), property.getZipCode(), property.getNumberOfUnits(), property.getManagerId(), property.getOwnerId(), property.getOpenUnits(), property.getOccupiedUnits(), property.getMaintenanceCost(), property.getCurrentIncome());
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
    public List<Property> getPropertiesByOwnerId(int i) {
        List<Property> properties = null;
        String sql = "SELECT * FROM property where ownerId = ?;";
        try {
            properties = jdbcTemplate.query(sql, new PropertyRowMapper(), new Object[]{i});
        }catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }
}
