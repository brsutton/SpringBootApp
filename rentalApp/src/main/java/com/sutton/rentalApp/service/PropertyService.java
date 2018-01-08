package com.sutton.rentalApp.service;

import com.sutton.rentalApp.model.Property;

import java.util.List;

public interface PropertyService {

    public boolean addProperty(Property property);

    List<Property> getPropertiesByOwnerId(int i);
}
