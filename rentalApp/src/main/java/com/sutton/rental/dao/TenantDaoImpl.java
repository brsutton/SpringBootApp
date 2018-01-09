package com.sutton.rental.dao;

import com.sutton.rental.model.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TenantDaoImpl implements TenantDao {

    public TenantDaoImpl() {

    }

    protected TenantDaoImpl(JdbcTemplate jdbcTemplate) {
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
    public boolean addTenant(Tenant tenant) {

        boolean success = true;
        String sql = "INSERT INTO `tenant` (`unitId`, `firstName`, `lastName`, `phoneNumber`, `email`, `moveInDate`, " +
                "`leaseExpires`) VALUES (?, ?, ?, ?, ?, ?, ?);";
        int result = 0;
        try {
            result = jdbcTemplate.update(sql, tenant.getUnitId(), tenant.getFirstName(), tenant.getLastName(),
                    tenant.getPhoneNumber(), tenant.getEmail(), tenant.getMoveInDate(), tenant.getLeaseExpires());
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
    public Tenant getTenantById(int id) {
        List<Tenant> units = null;
        Tenant tenant = null;
        String sql = "SELECT * FROM tenant where id = ?;";
        try {
            units = jdbcTemplate.query(sql, new TenantRowMapper(), new Object[]{id});
            if (units.size() != 0) {
                tenant = units.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenant;
    }
}
