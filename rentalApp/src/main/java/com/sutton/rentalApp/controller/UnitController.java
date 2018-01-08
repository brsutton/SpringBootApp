package com.sutton.rentalApp.controller;

import com.sutton.rentalApp.model.Unit;
import com.sutton.rentalApp.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitController {

    @Autowired
    UnitService unitService;

    @RequestMapping(value = Urls.UNIT_URL + "/{id}", method = RequestMethod.GET)
    public Unit getUnitById(@PathVariable("id") int id) {
        return unitService.getUnitById(id);
    }
}
