package com.sutton.rental.dao;

import com.sutton.rental.model.Property;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyRowMapper implements RowMapper<Property> {
    @Override
    public Property mapRow(ResultSet resultSet, int i) throws SQLException {
        Property property = new Property();
        property.setId(resultSet.getInt("id"));
        property.setName(resultSet.getString("name"));
        property.setStreetAddress(resultSet.getString("streetAddress"));
        property.setCity(resultSet.getString("city"));
        property.setState(resultSet.getString("state"));
        property.setZipCode(resultSet.getString("zipCode"));
        property.setNumberOfUnits(resultSet.getInt("numberOfUnits"));
        property.setManagerId(resultSet.getInt("managerId"));
        property.setOwnerId(resultSet.getInt("ownerId"));
        property.setOpenUnits(resultSet.getInt("openUnits"));
        property.setOccupiedUnits(resultSet.getInt("occupiedUnits"));
        property.setMaintenanceCost(resultSet.getDouble("maintenanceCost"));
        property.setCurrentIncome(resultSet.getDouble("currentIncome"));
        return property;
    }
}
