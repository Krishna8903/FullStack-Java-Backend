package com.example.WareWing.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.WareWing.entity.SupplierEntity;
import com.example.WareWing.service.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService service;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<SupplierEntity> save(
            @Valid @RequestBody SupplierEntity supplier) {

        return new ResponseEntity<>(
                service.save(supplier),
                HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','VIEWER')")
    @GetMapping
    public ResponseEntity<List<SupplierEntity>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }
    
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','VIEWER')")
    @GetMapping("/{id}")
    public ResponseEntity<SupplierEntity> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getById(id));
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PutMapping("/{id}")
    public ResponseEntity<SupplierEntity> update(
            @PathVariable Long id,
            @Valid @RequestBody SupplierEntity supplier) {

        return ResponseEntity.ok(
                service.update(id, supplier));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        service.delete(id);
        
        return ResponseEntity.ok("Supplier Deleted Successfully");
    }
}