package com.m2i.gestionfactures.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Product")
    private Long id;

    @Column(nullable = false)
    private String reference;
    private String description;
    private String unit;
    @Column(nullable = false)
    private Float priceTaxFree;
    @Column(nullable = false)
    private Float taxRate;


    public Product(String reference, String description, String unit, Float priceTaxFree, Float taxRate) {
        this.reference = reference;
        this.description = description;
        this.unit = unit;
        this.priceTaxFree = priceTaxFree;
        this.taxRate = taxRate;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getPriceTaxFree() {
        return priceTaxFree;
    }
    public void setPriceTaxFree(Float priceTaxFree) {
        this.priceTaxFree = priceTaxFree;
    }

    public Float getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }
    public Float getPriceWithTax(){
        return ((float) Math.round(priceTaxFree * (1 + taxRate) * 100)) / 100;
    }
}
