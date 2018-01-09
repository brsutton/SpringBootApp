package com.sutton.rentalApp.dao;

import com.sutton.rentalApp.model.Tenant;

public interface TenantDao {

    public boolean addTenant(Tenant tenant);

    public Tenant getTenantById(int id);
}
