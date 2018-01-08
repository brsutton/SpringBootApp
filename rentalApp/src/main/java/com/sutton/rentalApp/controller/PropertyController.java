package com.sutton.rentalApp.controller;

import com.sutton.rentalApp.model.Property;
import com.sutton.rentalApp.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @RequestMapping(value = Urls.PROPERTY_URL, method = RequestMethod.PUT)
    public boolean addProperty(@RequestBody Property property){
        return propertyService.addProperty(property);
    }
}
