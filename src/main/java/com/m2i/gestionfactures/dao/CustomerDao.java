package com.m2i.gestionfactures.dao;

import com.m2i.gestionfactures.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao implements Dao<Customer> {

    @Override
    public Optional<Customer> get(Long id) {
        Optional<Customer> optRecipe = Optional.empty();
        EntityManager em = ConnectionManager.getEntityManager();
        try {
            optRecipe = Optional.of(em.find(Customer.class, id));
        } catch(EntityNotFoundException e) {
            e.printStackTrace();
        }
        return optRecipe;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        EntityManager em = ConnectionManager.getEntityManager();
        try {
            customerList = em.createQuery("select c from Customer c", Customer.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ( em != null ) em.close();
        }
        return customerList;
    }

    @Override
    public void update(Customer customer) {
        EntityManager em = ConnectionManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(customer);
            et.commit();
        } catch(Exception e) {
            if(et.isActive()) {et.rollback();}
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = ConnectionManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Optional<Customer> optCustomer = Optional.of(em.find(Customer.class, id));
            optCustomer.ifPresent(em::remove);
            et.commit();
        } catch(Exception e) {
            System.out.println("Impossible de supprimer l'élément choisi");
            e.printStackTrace();
            if (et.isActive()) { et.rollback(); }
        } finally {
            em.close();
        }
    }


}
