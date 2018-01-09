package com.sutton.rental.service;

import com.sutton.rental.dao.UnitDao;
import com.sutton.rental.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitDao unitDao;

    @Override
    public Unit getUnitById(int id) {
        return unitDao.getUnitById(id);
    }

    @Override
    public boolean addUnit(Unit unit) {
        return unitDao.addUnit(unit);
    }

    @Override
    public List<Unit> getAllUnitsInPropertyByPropertyId(int propertyId) {
        return unitDao.getAllUnitsInPropertyByPropertyId(propertyId);
    }
}
