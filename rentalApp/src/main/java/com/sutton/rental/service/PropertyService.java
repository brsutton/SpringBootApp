package com.sutton.rental.service;

import com.sutton.rental.model.Property;

import java.util.List;

public interface PropertyService {

    public boolean addProperty(Property property);

    List<Property> getPropertiesByOwnerId(int i);
}
