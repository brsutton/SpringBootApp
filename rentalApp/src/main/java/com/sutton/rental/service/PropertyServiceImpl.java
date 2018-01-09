package com.sutton.rental.service;

import com.sutton.rental.dao.PropertyDao;
import com.sutton.rental.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyDao propertyDao;

    public PropertyServiceImpl() {

    }

    protected PropertyServiceImpl(PropertyDao propertyDao) {
        this.propertyDao = propertyDao;
    }

    public boolean addProperty(Property property) {
        return propertyDao.addProperty(property);
    }

    @Override
    public List<Property> getPropertiesByOwnerId(int i) {
        return propertyDao.getPropertiesByOwnerId(i);
    }
}
