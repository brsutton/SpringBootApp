package com.sutton.rental.dao;

import com.sutton.rental.model.PropertyPhoto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyPhotoRowMapper implements RowMapper<PropertyPhoto> {
    @Override
    public PropertyPhoto mapRow(ResultSet resultSet, int i) throws SQLException {
        PropertyPhoto propertyPhoto = new PropertyPhoto();
        propertyPhoto.setId(resultSet.getInt("id"));
        propertyPhoto.setPropertyId(resultSet.getInt("propertyId"));
        propertyPhoto.setPhotoFileLocation(resultSet.getString("photoFileLocation"));
        return propertyPhoto;
    }
}
