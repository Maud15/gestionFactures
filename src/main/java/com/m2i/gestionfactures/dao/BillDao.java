package com.m2i.gestionfactures.dao;

import com.m2i.gestionfactures.model.Bill;
import com.m2i.gestionfactures.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class BillDao implements Dao<Bill>{
    @Override
    public Optional<Bill> get(Long id) {
        Optional<Bill> optBill = Optional.empty();
        EntityManager em = ConnectionManager.getEntityManager();
        try {
            optBill = Optional.of(em.find(Bill.class, id));
        } catch(EntityNotFoundException e) {
            e.printStackTrace();
        }
        return optBill;
    }

    @Override
    public List<Bill> getAll() {
        return null;
    }

    @Override
    public void update(Bill bill) {

        EntityManager em = ConnectionManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(bill);
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

    }
}
