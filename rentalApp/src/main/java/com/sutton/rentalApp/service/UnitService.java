package com.sutton.rentalApp.service;

import com.sutton.rentalApp.model.Unit;

import java.util.List;

public interface UnitService {

    public Unit getUnitById(int id);

    public boolean addUnit(Unit unit);

    public List<Unit> getAllUnitsInPropertyByPropertyId(int propertyId);

}
