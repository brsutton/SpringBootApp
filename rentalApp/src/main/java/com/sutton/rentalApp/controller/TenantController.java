package com.sutton.rentalApp.controller;

import com.sutton.rentalApp.model.Tenant;
import com.sutton.rentalApp.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantController {

    @Autowired
    TenantService tenantService;

    @RequestMapping(value = Urls.TENANT_URL, method = RequestMethod.POST)
    public Boolean addTenant(@RequestBody Tenant tenant) {
        return tenantService.addTenant(tenant);
    }

}
