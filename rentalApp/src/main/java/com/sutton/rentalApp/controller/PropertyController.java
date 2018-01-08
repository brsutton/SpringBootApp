package com.sutton.rentalApp.controller;

import com.sutton.rentalApp.model.Property;
import com.sutton.rentalApp.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @RequestMapping(value = Urls.PROPERTY_URL, method = RequestMethod.PUT)
    public boolean addProperty(@RequestBody Property property) {
        return propertyService.addProperty(property);
    }

    @RequestMapping(value = Urls.PROPERTY_URL + "/{id}", method = RequestMethod.GET)
    public List<Property> getPropertiesByOwnerId(@PathVariable("id") int id) {
        return propertyService.getPropertiesByOwnerId(id);
    }
}
