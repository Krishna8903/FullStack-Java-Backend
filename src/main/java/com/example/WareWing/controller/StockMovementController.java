package com.example.WareWing.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.WareWing.entity.StockMovementEntity;
import com.example.WareWing.service.StockMovementService;

@RestController
@RequestMapping("/movements")
public class StockMovementController {

    @Autowired
    private StockMovementService service;
    @PreAuthorize("hasRole('ADMIN')")
    
    @PostMapping
    public ResponseEntity<StockMovementEntity> save(
            @Valid @RequestBody StockMovementEntity movement) {

        return new ResponseEntity<>(
                service.save(movement),
                HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    
    @GetMapping
    public ResponseEntity<List<StockMovementEntity>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }
    @PreAuthorize("hasRole('ADMIN')")
    
    @GetMapping("/{id}")
    public ResponseEntity<StockMovementEntity> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getById(id));
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PutMapping("/{id}")
    public ResponseEntity<StockMovementEntity> update(
            @PathVariable Long id,
            @Valid @RequestBody StockMovementEntity movement) {

        return ResponseEntity.ok(
                service.update(id, movement));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok("Stock Movement Deleted Successfully");
    }
}