package com.example.WareWing.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "stock_movements")
public class StockMovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Stock Item ID is required")
    @Column(nullable = false)
    private Long stockItemId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovementType movementType;

    @NotNull(message = "Quantity is required")
    @Column(nullable = false)
    private Integer quantityDelta;

    @Column(nullable = false)
    private Integer previousQuantity;

    @Column(nullable = false)
    private Integer newQuantity;

    private Long referencePoId;

    @NotBlank(message = "Performed By is required")
    @Column(nullable = false)
    private String performedBy;

    @Column(nullable = false)
    private LocalDateTime movementDate;

    private String notes;

    public enum MovementType {
        STOCK_IN,
        STOCK_OUT,
        ADJUSTMENT
    }

    public StockMovementEntity() {
    }

    public StockMovementEntity(Long id, Long stockItemId,
            MovementType movementType,
            Integer quantityDelta,
            Integer previousQuantity,
            Integer newQuantity,
            Long referencePoId,
            String performedBy,
            LocalDateTime movementDate,
            String notes) {

        this.id = id;
        this.stockItemId = stockItemId;
        this.movementType = movementType;
        this.quantityDelta = quantityDelta;
        this.previousQuantity = previousQuantity;
        this.newQuantity = newQuantity;
        this.referencePoId = referencePoId;
        this.performedBy = performedBy;
        this.movementDate = movementDate;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(Long stockItemId) {
        this.stockItemId = stockItemId;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public Integer getQuantityDelta() {
        return quantityDelta;
    }

    public void setQuantityDelta(Integer quantityDelta) {
        this.quantityDelta = quantityDelta;
    }

    public Integer getPreviousQuantity() {
        return previousQuantity;
    }

    public void setPreviousQuantity(Integer previousQuantity) {
        this.previousQuantity = previousQuantity;
    }

    public Integer getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(Integer newQuantity) {
        this.newQuantity = newQuantity;
    }

    public Long getReferencePoId() {
        return referencePoId;
    }

    public void setReferencePoId(Long referencePoId) {
        this.referencePoId = referencePoId;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public LocalDateTime getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(LocalDateTime movementDate) {
        this.movementDate = movementDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}