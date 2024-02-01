package com.example.java12.service;

import com.example.java12.model.Tenant;
import com.example.java12.repository.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {
    private final TenantRepo tenantRepo;

    @Autowired
    public TenantService(TenantRepo tenantRepo) {
        this.tenantRepo = tenantRepo;
    }

    public void addTenant(String name) {
        Tenant tenant = new Tenant();
        tenant.setName(name);

        tenantRepo.save(tenant);
    }

    public List<Tenant> getAllTenants() {
        return tenantRepo.findAll();
    }
}
