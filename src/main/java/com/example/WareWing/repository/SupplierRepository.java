package com.example.WareWing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.WareWing.entity.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    long countByStatus(SupplierEntity.SupplierStatus status);

}