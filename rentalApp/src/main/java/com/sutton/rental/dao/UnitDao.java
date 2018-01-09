package com.sutton.rental.dao;

import com.sutton.rental.model.Unit;

import java.util.List;

public interface UnitDao {

    public Unit getUnitById(int id);

    public boolean addUnit(Unit unit);

    public List<Unit> getAllUnitsInPropertyByPropertyId(int propertyId);
}
