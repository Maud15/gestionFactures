package com.m2i.gestionfactures.dao;

import com.m2i.gestionfactures.model.Bill;
import com.m2i.gestionfactures.model.Customer;
import com.m2i.gestionfactures.model.Product;
import com.m2i.gestionfactures.model.ProductBill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductBillDao {
    public Optional<ProductBill> get(Product product, Bill bill){
        EntityManager em = ConnectionManager.getEntityManager();
        try {
            Query query = em.createQuery("select pb from ProductBill pb where pb.bill = :bill and pb.product = :product", ProductBill.class);
            query.setParameter("bill", bill);
            query.setParameter("product", product);
            List<ProductBill> results = query.getResultList();
            if(results != null && results.size() > 0){
                return Optional.of(results.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ( em != null ) em.close();
        }
        return Optional.empty();
    }

    public void create(ProductBill element){
        EntityManager em = ConnectionManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(element);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }
    public void update(ProductBill element){
        EntityManager em = ConnectionManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(element);
            et.commit();
        } catch(Exception e) {
            if(et.isActive()) {et.rollback();}
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void delete(Product product, Bill bill){
        EntityManager em = ConnectionManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Query query = em.createQuery("delete from ProductBill pb where pb.bill = :bill and pb.product = :product");
            query.setParameter("bill", bill);
            query.setParameter("product", product);
            query.executeUpdate();
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
