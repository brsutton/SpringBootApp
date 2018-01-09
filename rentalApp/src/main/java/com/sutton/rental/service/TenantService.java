package com.sutton.rental.service;

import com.sutton.rental.model.Tenant;

public interface TenantService {

    public boolean addTenant(Tenant tenant);

    public Tenant getTenantById(int id);

}
