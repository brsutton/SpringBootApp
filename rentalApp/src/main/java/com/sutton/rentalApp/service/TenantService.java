package com.sutton.rentalApp.service;

import com.sutton.rentalApp.model.Tenant;

public interface TenantService {

    public boolean addTenant(Tenant tenant);

    public Tenant getTenantById(int id);

}
