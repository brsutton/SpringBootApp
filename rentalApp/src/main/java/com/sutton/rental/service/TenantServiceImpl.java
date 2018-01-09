package com.sutton.rental.service;

import com.sutton.rental.dao.TenantDao;
import com.sutton.rental.model.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    TenantDao tenantDao;

    @Override
    public boolean addTenant(Tenant tenant) {
        return tenantDao.addTenant(tenant);
    }

    @Override
    public Tenant getTenantById(int id) {
        return tenantDao.getTenantById(id);
    }

    @Override
    public List<Tenant> getTenantsByProperty(int propertyId){
        return tenantDao.getTenantsByProperty(propertyId);
    }

    @Override
    public Tenant getTenantByUnitId(int unitId) {
        return tenantDao.getTenantByUnitId(unitId);
    }
}
