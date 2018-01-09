package com.sutton.rental.controller;

import com.sutton.rental.model.Tenant;
import com.sutton.rental.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TenantController {

    @Autowired
    TenantService tenantService;

    @RequestMapping(value = Urls.TENANT_URL, method = RequestMethod.POST)
    public Boolean addTenant(@RequestBody Tenant tenant) {
        return tenantService.addTenant(tenant);
    }

    @RequestMapping(value = Urls.TENANT_URL + "/{id}", method = RequestMethod.GET)
    public Tenant getTenantById(@PathVariable("id") int id) {
        return tenantService.getTenantById(id);
    }

    @RequestMapping(value = Urls.TENANT_BY_UNIT_URL + "/{UnitId}", method = RequestMethod.GET)
    public Tenant getTenantByUnitId(@PathVariable("UnitId") int unitId) {
        return tenantService.getTenantByUnitId(unitId);
    }

    @RequestMapping(value = Urls.TENANT_BY_PROPERTY_URL + "/{propertyId}", method = RequestMethod.GET)
    public List<Tenant> getTenantsByProperty(@PathVariable("propertyId") int propertyId) {
        return tenantService.getTenantsByProperty(propertyId);
    }
}
