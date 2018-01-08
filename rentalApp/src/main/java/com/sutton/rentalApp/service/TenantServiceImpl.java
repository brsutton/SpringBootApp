package com.sutton.rentalApp.service;

import com.sutton.rentalApp.dao.TenantDao;
import com.sutton.rentalApp.model.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
