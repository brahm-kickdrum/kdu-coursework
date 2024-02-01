package com.example.java12.controller;

import com.example.java12.model.Tenant;
import com.example.java12.service.TenantService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TenantController {

    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/tenant")
    public ResponseEntity<String> createTenant(@RequestBody String name) {
        tenantService.addTenant(name);
        return new ResponseEntity<>("Tenant created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/tenant")
    public ResponseEntity<List<Tenant>> getAllTenants() {
        List<Tenant> allTenants = tenantService.getAllTenants();
        return new ResponseEntity<>(allTenants, HttpStatus.OK);
    }
}

