package com.example.WareWing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WareWing.entity.PurchaseOrderEntity;
import com.example.WareWing.exception.ResourceNotFoundException;
import com.example.WareWing.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository repo;

    public PurchaseOrderEntity save(PurchaseOrderEntity order) {

        return repo.save(order);
    }

    public List<PurchaseOrderEntity> getAll() {

        return repo.findAll();
    }

    public PurchaseOrderEntity getById(Long id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Purchase Order not found"));
    }

    public PurchaseOrderEntity update(Long id, PurchaseOrderEntity order) {

        PurchaseOrderEntity existing = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Purchase Order not found"));

        existing.setPoNumber(order.getPoNumber());
        existing.setSupplierId(order.getSupplierId());
        existing.setOrderedBy(order.getOrderedBy());
        existing.setTotalAmount(order.getTotalAmount());
        existing.setStatus(order.getStatus());
        existing.setOrderDate(order.getOrderDate());
        existing.setExpectedDelivery(order.getExpectedDelivery());

        return repo.save(existing);
    }

    public void delete(Long id) {

        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Purchase Order not found");
        }

        repo.deleteById(id);
    }
}