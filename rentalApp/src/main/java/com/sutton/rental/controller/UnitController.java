package com.sutton.rental.controller;

import com.sutton.rental.model.Unit;
import com.sutton.rental.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnitController {

    @Autowired
    UnitService unitService;

    @RequestMapping(value = Urls.UNIT_URL + "/{id}", method = RequestMethod.GET)
    public Unit getUnitById(@PathVariable("id") int id) {
        return unitService.getUnitById(id);
    }

    @RequestMapping(value = Urls.UNIT_URL, method = RequestMethod.PUT)
    public Boolean addUnit(@RequestBody Unit unit) {
        return unitService.addUnit(unit);
    }

    @RequestMapping(value = Urls.ALL_UNIT_IN_PROPERTY_URL + "/{propertyId}", method = RequestMethod.GET)
    public List<Unit> getAllUnitsInPropertyByPropertyId(@PathVariable("propertyId") int propertyId) {
        return unitService.getAllUnitsInPropertyByPropertyId(propertyId);
    }
}
