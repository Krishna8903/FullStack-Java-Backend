package com.example.WareWing.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.WareWing.entity.PurchaseOrderEntity;
import com.example.WareWing.service.PurchaseOrderService;

@RestController
@RequestMapping("/orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService service;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PurchaseOrderEntity> save(
            @Valid @RequestBody PurchaseOrderEntity order) {

        return new ResponseEntity<>(
                service.save(order),
                HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','VIEWER')")
    @GetMapping
    public ResponseEntity<List<PurchaseOrderEntity>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','VIEWER')")
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderEntity> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getById(id));
    }
    @PreAuthorize("hasRole('ADMIN','MANAGER')")
    
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderEntity> update(
            @PathVariable Long id,
            @Valid @RequestBody PurchaseOrderEntity order) {

        return ResponseEntity.ok(
                service.update(id, order));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok("Purchase Order Deleted Successfully");
    }
}