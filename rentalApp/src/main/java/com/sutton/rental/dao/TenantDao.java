package com.sutton.rental.dao;

import com.sutton.rental.model.Tenant;

import java.util.List;

public interface TenantDao {

    public boolean addTenant(Tenant tenant);

    public Tenant getTenantById(int id);

    public List<Tenant> getTenantsByProperty(int propertyId);

    public Tenant getTenantByUnitId(int unitId);
}
