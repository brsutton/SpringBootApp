package com.sutton.rentalApp.service;

import com.sutton.rentalApp.dao.UnitDao;
import com.sutton.rentalApp.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitDao unitDao;

    @Override
    public Unit getUnitById(int id) {
        return unitDao.getUnitById(id);
    }
}
