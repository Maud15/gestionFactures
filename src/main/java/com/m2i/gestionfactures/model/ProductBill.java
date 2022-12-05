package com.m2i.gestionfactures.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductBill")
public class ProductBill {

    @ManyToOne
    @JoinColumn(name = "Id_Bill")
    @Id
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "Id_Product")
    @Id
    private Product product;

    private Float quantity;



    public Bill getBill() {
        return bill;
    }
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public Float getQuantity() {
        return quantity;
    }
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
}
