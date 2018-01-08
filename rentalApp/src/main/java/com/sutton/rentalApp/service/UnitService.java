package com.sutton.rentalApp.service;

import com.sutton.rentalApp.model.Unit;

public interface UnitService {

    public Unit getUnitById(int id);

    public boolean addUnit(Unit unit);

}
