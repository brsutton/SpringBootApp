package com.sutton.rentalApp.service;

import com.sutton.rentalApp.dao.PropertyDao;
import com.sutton.rentalApp.dao.PropertyDaoImpl;
import com.sutton.rentalApp.model.Property;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PropertyServiceTest {

    @Test
    public void shouldAddPropertyToDatabase() {
        PropertyDao propertyDao = mock(PropertyDaoImpl.class);
        Property property = new Property();
        when(propertyDao.addProperty(property)).thenReturn(true);
        PropertyService propertyService = new PropertyServiceImpl(propertyDao);
        Assert.assertEquals(true, propertyService.addProperty(property));
    }

    @Test
    public void shouldGetAllPropertiesByOwnerId(){
        PropertyDao propertyDao = mock(PropertyDaoImpl.class);
        Property property = new Property();
        List<Property> propertyList = new ArrayList<>();
        property.setOwnerId(1);
        property.setId(1);
        property.setName("House");
        propertyList.add(property);
        when(propertyDao.getPropertiesByOwnerId(1)).thenReturn(propertyList);
        PropertyService propertyService = new PropertyServiceImpl(propertyDao);
        Assert.assertEquals("House", propertyService.getPropertiesByOwnerId(1).get(0).getName());
    }

}
