package com.sutton.rental.dao;

import com.sutton.rental.model.Unit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitRowMapper implements RowMapper<Unit> {
    @Override
    public Unit mapRow(ResultSet resultSet, int i) throws SQLException {
        Unit unit = new Unit();
        unit.setId(resultSet.getInt("id"));
        unit.setPropertyId(resultSet.getInt("propertyId"));
        unit.setTenantId(resultSet.getInt("tenantID"));
        unit.setBedrooms(resultSet.getInt("bedrooms"));
        unit.setBathrooms(resultSet.getInt("bathrooms"));
        unit.setSquareFeet(resultSet.getInt("squareFeet"));
        unit.setUnitName(resultSet.getString("unitName"));
        unit.setUnitDescription(resultSet.getString("unitDescription"));
        unit.setUnitRent(resultSet.getDouble("unitRent"));
        unit.setBackRent(resultSet.getDouble("backRent"));
        unit.setOccupied(resultSet.getBoolean("occupied"));
        unit.setMaintenanceNeeded(resultSet.getBoolean("maintenanceNeeded"));
        unit.setMaintenanceDescription(resultSet.getString("maintenanceDescription"));
        unit.setMaintenanceCost(resultSet.getDouble("maintenanceCost"));
        unit.setDepositHeld(resultSet.getDouble("depositHeld"));
        return unit;
    }
}
