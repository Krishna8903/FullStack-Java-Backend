package com.example.WareWing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WareWing.entity.StockItemEntity;
import com.example.WareWing.exception.ResourceNotFoundException;
import com.example.WareWing.repository.StockItemRepository;

@Service
public class StockItemService {

    @Autowired
    private StockItemRepository repo;

    public StockItemEntity save(StockItemEntity item) {
        return repo.save(item);
    }

    public List<StockItemEntity> getAll() {
        return repo.findAll();
    }

    public StockItemEntity getById(Long id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Stock Item not found"));
    }

    public StockItemEntity update(Long id, StockItemEntity item) {

        StockItemEntity existing = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Stock Item not found"));

        existing.setSku(item.getSku());
        existing.setName(item.getName());
        existing.setCategory(item.getCategory());
        existing.setCurrentQuantity(item.getCurrentQuantity());
        existing.setUnit(item.getUnit());
        existing.setMinimumThreshold(item.getMinimumThreshold());
        existing.setReorderQuantity(item.getReorderQuantity());
        existing.setUnitPrice(item.getUnitPrice());
        existing.setPreferredSupplierId(item.getPreferredSupplierId());
        existing.setAutoReorderEnabled(item.getAutoReorderEnabled());
        existing.setStatus(item.getStatus());

        return repo.save(existing);
    }

    public void delete(Long id) {

        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Stock Item not found");
        }

        repo.deleteById(id);
    }
}