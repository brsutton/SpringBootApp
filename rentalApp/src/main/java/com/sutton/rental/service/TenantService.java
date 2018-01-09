package com.sutton.rental.service;

import com.sutton.rental.model.Tenant;

import java.util.List;

public interface TenantService {

    public boolean addTenant(Tenant tenant);

    public Tenant getTenantById(int id);

    public List<Tenant> getTenantsByProperty(int propertyId);

}
