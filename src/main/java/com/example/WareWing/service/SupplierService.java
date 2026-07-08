package com.example.WareWing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WareWing.entity.SupplierEntity;
import com.example.WareWing.exception.ResourceNotFoundException;
import com.example.WareWing.repository.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository repo;

    public SupplierEntity save(SupplierEntity supplier) {
        return repo.save(supplier);
    }

    public List<SupplierEntity> getAll() {
        return repo.findAll();
    }

    public SupplierEntity getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found"));
    }

    public SupplierEntity update(Long id, SupplierEntity supplier) {

        SupplierEntity existing = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found"));

        existing.setName(supplier.getName());
        existing.setContactEmail(supplier.getContactEmail());
        existing.setPhone(supplier.getPhone());
        existing.setLeadTimeDays(supplier.getLeadTimeDays());
        existing.setReliabilityScore(supplier.getReliabilityScore());
        existing.setStatus(supplier.getStatus());

        return repo.save(existing);
    }

    public void delete(Long id) {

        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Supplier not found");
        }

        repo.deleteById(id);
    }
}