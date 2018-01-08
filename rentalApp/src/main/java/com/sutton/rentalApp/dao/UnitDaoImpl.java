package com.sutton.rentalApp.dao;

import com.sutton.rentalApp.model.Property;
import com.sutton.rentalApp.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UnitDaoImpl implements UnitDao {

    public UnitDaoImpl() {

    }

    protected UnitDaoImpl(JdbcTemplate jdbcTemplate) {
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
    public Unit getUnitById(int id) {
        List<Unit> units = null;
        Unit unit = null;
        String sql = "SELECT * FROM units where id = ?;";
        try {
            units = jdbcTemplate.query(sql, new UnitRowMapper(), new Object[]{id});
            if (units.size() != 0) {
                unit = units.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unit;
    }
}
