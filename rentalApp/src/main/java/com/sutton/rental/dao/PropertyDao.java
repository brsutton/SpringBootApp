package com.sutton.rental.dao;

import com.sutton.rental.model.Property;

import java.util.List;

public interface PropertyDao {

    public boolean addProperty(Property property);

    List<Property> getPropertiesByOwnerId(int i);
}
