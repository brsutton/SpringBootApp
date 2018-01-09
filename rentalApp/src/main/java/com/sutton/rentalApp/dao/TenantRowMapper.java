package com.sutton.rentalApp.dao;

import com.sutton.rentalApp.model.Tenant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TenantRowMapper implements RowMapper<Tenant> {
    @Override
    public Tenant mapRow(ResultSet resultSet, int i) throws SQLException {
        Tenant tenant = new Tenant();
        tenant.setId(resultSet.getInt("id"));
        tenant.setUnitId(resultSet.getInt("unitId"));
        tenant.setFirstName(resultSet.getString("firstName"));
        tenant.setLastName(resultSet.getString("lastName"));
        tenant.setPhoneNumber(resultSet.getString("phoneNumber"));
        tenant.setEmail(resultSet.getString("email"));
        tenant.setMoveInDate(resultSet.getDate("moveInDate").toString());
        tenant.setLeaseExpires(resultSet.getDate("leaseExpires").toString());
        return tenant;
    }
}
