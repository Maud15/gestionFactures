package com.m2i.gestionfactures.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Bill")
    private Long id;

    //@Column(nullable = false, unique = true)
    @Transient
    private String billNumber;

    @Column(nullable = false)
    private LocalDate dateBill;

    @ManyToOne
    @JoinColumn(name = "idCustomer")
    private Customer customer;

    @OneToMany(targetEntity = ProductBill.class, mappedBy = "bill", fetch = FetchType.LAZY)
    private List<ProductBill> productsBillsList;

    public Bill(LocalDate dateBill, Customer customer) {
        this.dateBill = dateBill;
        this.customer = customer;
        this.productsBillsList = new ArrayList<>();
    }

    public Bill() {

    }
    public Bill(Long id, LocalDate dateBill, Customer customer) {
        this.id = id;
        this.dateBill = dateBill;
        this.customer = customer;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getBillNumber() {
        return billNumber;
    }
    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public LocalDate getDateBill() {
        return dateBill;
    }
    public void setDateBill(LocalDate dateBill) {
        this.dateBill = dateBill;
    }

    public List<ProductBill> getProductsBillsList() {
        return productsBillsList;
    }
    public void setProductsBillsList(List<ProductBill> productsBillsList) {
        this.productsBillsList = productsBillsList;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    public Float getAmountTaxFree(){
        Float result = 0f;
        for(ProductBill pb : productsBillsList){
            result += pb.getQuantity() * pb.getProduct().getPriceTaxFree();
        }
        return result;
    }
    public Float getAmountWithTax(){
        Float result = 0f;
        for(ProductBill pb : productsBillsList){
            result += pb.getQuantity() * pb.getProduct().getPriceWithTax();
        }
        return result;
    }
}
