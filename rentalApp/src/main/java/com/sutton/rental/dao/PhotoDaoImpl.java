package com.sutton.rental.dao;

import com.sutton.rental.model.Property;
import com.sutton.rental.model.PropertyPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PhotoDaoImpl implements PhotoDao {

    public PhotoDaoImpl() {

    }

    protected PhotoDaoImpl(JdbcTemplate jdbcTemplate) {
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
    public PropertyPhoto getPropertyPhotoByPropertyId(int propertyId) {

        String sql = "SELECT * FROM property_photos WHERE propertyId = ?;";
        PropertyPhoto propertyPhoto = new PropertyPhoto();
        List<PropertyPhoto> list;
        try {
            list = jdbcTemplate.query(sql,new PropertyPhotoRowMapper(), propertyId);
            if(list.size()!=0){
                propertyPhoto = list.get(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return propertyPhoto;
    }
}
