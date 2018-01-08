package com.sutton.rentalApp.service;

import com.sutton.rentalApp.dao.PropertyDao;
import com.sutton.rentalApp.dao.PropertyDaoImpl;
import com.sutton.rentalApp.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
