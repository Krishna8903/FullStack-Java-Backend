package com.example.WareWing.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.WareWing.entity.StockItemEntity;
import com.example.WareWing.service.StockItemService;

@RestController
@RequestMapping("/stock")
public class StockItemController {

    @Autowired
    private StockItemService service;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<StockItemEntity> save(
            @Valid @RequestBody StockItemEntity item) {

        return new ResponseEntity<>(
                service.save(item),
                HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','VIEWER')")
    @GetMapping
    public ResponseEntity<List<StockItemEntity>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','VIEWER')")
    @GetMapping("/{id}")
    public ResponseEntity<StockItemEntity> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getById(id));
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PutMapping("/{id}")
    public ResponseEntity<StockItemEntity> update(
            @PathVariable Long id,
            @Valid @RequestBody StockItemEntity item) {

        return ResponseEntity.ok(
                service.update(id, item));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok("Stock Item Deleted Successfully");
    }
}