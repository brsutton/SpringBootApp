package com.sutton.rental.dao;

import com.sutton.rental.model.Tenant;

public interface TenantDao {

    public boolean addTenant(Tenant tenant);

    public Tenant getTenantById(int id);
}
