package com.example.WareWing.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "stock_items")
public class StockItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "SKU is required")
    @Column(nullable = false, unique = true)
    private String sku;

    @NotBlank(message = "Item name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Category is required")
    @Column(nullable = false)
    private String category;

    @NotNull(message = "Current quantity is required")
    @Column(nullable = false)
    private Integer currentQuantity;

    @NotBlank(message = "Unit is required")
    @Column(nullable = false)
    private String unit;

    @NotNull(message = "Minimum threshold is required")
    @Column(nullable = false)
    private Integer minimumThreshold;

    @NotNull(message = "Reorder quantity is required")
    @Column(nullable = false)
    private Integer reorderQuantity;

    @NotNull(message = "Unit price is required")
    @DecimalMin(value = "0.0")
    @Column(nullable = false)
    private BigDecimal unitPrice;

    @NotNull(message = "Preferred supplier is required")
    @Column(nullable = false)
    private Long preferredSupplierId;

    @NotNull
    @Column(nullable = false)
    private Boolean autoReorderEnabled;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StockStatus status;

    public enum StockStatus {
        ACTIVE,
        INACTIVE
    }

    public StockItemEntity() {
    }

    public StockItemEntity(Long id, String sku, String name, String category,
            Integer currentQuantity, String unit,
            Integer minimumThreshold, Integer reorderQuantity,
            BigDecimal unitPrice, Long preferredSupplierId,
            Boolean autoReorderEnabled, StockStatus status) {

        this.id = id;
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.currentQuantity = currentQuantity;
        this.unit = unit;
        this.minimumThreshold = minimumThreshold;
        this.reorderQuantity = reorderQuantity;
        this.unitPrice = unitPrice;
        this.preferredSupplierId = preferredSupplierId;
        this.autoReorderEnabled = autoReorderEnabled;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(Integer currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getMinimumThreshold() {
        return minimumThreshold;
    }

    public void setMinimumThreshold(Integer minimumThreshold) {
        this.minimumThreshold = minimumThreshold;
    }

    public Integer getReorderQuantity() {
        return reorderQuantity;
    }

    public void setReorderQuantity(Integer reorderQuantity) {
        this.reorderQuantity = reorderQuantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getPreferredSupplierId() {
        return preferredSupplierId;
    }

    public void setPreferredSupplierId(Long preferredSupplierId) {
        this.preferredSupplierId = preferredSupplierId;
    }

    public Boolean getAutoReorderEnabled() {
        return autoReorderEnabled;
    }

    public void setAutoReorderEnabled(Boolean autoReorderEnabled) {
        this.autoReorderEnabled = autoReorderEnabled;
    }

    public StockStatus getStatus() {
        return status;
    }

    public void setStatus(StockStatus status) {
        this.status = status;
    }
}