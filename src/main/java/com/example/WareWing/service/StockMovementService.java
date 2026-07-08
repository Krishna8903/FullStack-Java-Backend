package com.example.WareWing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WareWing.entity.StockMovementEntity;
import com.example.WareWing.exception.ResourceNotFoundException;
import com.example.WareWing.repository.StockMovementRepository;

@Service
public class StockMovementService {

    @Autowired
    private StockMovementRepository repo;

    public StockMovementEntity save(StockMovementEntity movement) {

        return repo.save(movement);
    }

    public List<StockMovementEntity> getAll() {

        return repo.findAll();
    }

    public StockMovementEntity getById(Long id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Stock Movement not found"));
    }

    public StockMovementEntity update(Long id, StockMovementEntity movement) {

        StockMovementEntity existing = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Stock Movement not found"));

        existing.setStockItemId(movement.getStockItemId());
        existing.setMovementType(movement.getMovementType());
        existing.setQuantityDelta(movement.getQuantityDelta());
        existing.setPreviousQuantity(movement.getPreviousQuantity());
        existing.setNewQuantity(movement.getNewQuantity());
        existing.setReferencePoId(movement.getReferencePoId());
        existing.setPerformedBy(movement.getPerformedBy());
        existing.setMovementDate(movement.getMovementDate());
        existing.setNotes(movement.getNotes());

        return repo.save(existing);
    }

    public void delete(Long id) {

        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Stock Movement not found");
        }

        repo.deleteById(id);
    }
}