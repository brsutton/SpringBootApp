package com.sutton.rentalApp.service;

import com.sutton.rentalApp.dao.PropertyDao;
import com.sutton.rentalApp.dao.PropertyDaoImpl;
import com.sutton.rentalApp.model.Property;
import org.junit.Assert;
import org.junit.Test;

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

}
