package com.sutton.rentalApp.dao;

import com.sutton.rentalApp.model.Property;

import java.util.List;

public interface PropertyDao {

    public boolean addProperty(Property property);

    List<Property> getPropertiesByOwnerId(int i);
}
