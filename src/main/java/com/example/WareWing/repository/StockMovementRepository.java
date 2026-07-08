package com.example.WareWing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WareWing.entity.StockMovementEntity;

public interface StockMovementRepository extends JpaRepository<StockMovementEntity, Long> {

    List<StockMovementEntity> findByStockItemId(Long stockItemId);

}