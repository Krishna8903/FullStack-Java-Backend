package com.example.WareWing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WareWing.entity.StockItemEntity;

public interface StockItemRepository extends JpaRepository<StockItemEntity, Long> {

    Optional<StockItemEntity> findBySku(String sku);

    long countByCurrentQuantityLessThanEqual(Integer minimumThreshold);
}