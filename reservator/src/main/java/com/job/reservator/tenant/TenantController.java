package com.job.reservator.tenant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TenantController {

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    private final TenantService tenantService;

    @GetMapping("/tenants")
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }
}
