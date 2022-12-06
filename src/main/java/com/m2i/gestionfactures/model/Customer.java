package com.m2i.gestionfactures.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCustomer")
    private Long id;

    //@Column(unique = true, nullable = false)
    @Transient
    private String customerNumber;

    @Column(nullable = false)
    private String designation;
    private String address;
    private String postCode;
    private String city;
    private String phoneNumber;
    private String email;

    @OneToMany(targetEntity = Bill.class, mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Bill> billList;

    public Customer() {
    }

    public Customer(String designation, String address, String postCode, String city, String phoneNumber, String email) {
        this.designation = designation;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.billList= new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bill> getBillList() {
        return billList;
    }
    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
}
