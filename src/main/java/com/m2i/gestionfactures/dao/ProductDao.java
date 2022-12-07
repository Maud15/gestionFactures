package com.m2i.gestionfactures.dao;
import com.m2i.gestionfactures.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao implements Dao<Product>{
    @Override
    public Optional<Product> get(Long id) {
        Optional<Product> optProduct = Optional.empty();
        EntityManager em = ConnectionManager.getEntityManager();
        try {
            optProduct = Optional.of(em.find(Product.class, id));
        } catch(EntityNotFoundException e) {
            e.printStackTrace();
        }
        return optProduct;
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        EntityManager em = ConnectionManager.getEntityManager();
        try {
            productList = em.createQuery("select c from Product c", Product.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ( em != null ) em.close();
        }
        return productList;
    }

    @Override
    public void update(Product product) {
        EntityManager em = ConnectionManager.getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(product);
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
            Optional<Product> optProduct = Optional.of(em.find(Product.class, id));
            optProduct.ifPresent(em::remove);
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
