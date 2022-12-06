package com.m2i.gestionfactures.dao;

import com.m2i.gestionfactures.model.Bill;

import java.util.List;
import java.util.Optional;

public class BillDao implements Dao<Bill>{
    @Override
    public Optional<Bill> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Bill> getAll() {
        return null;
    }

    @Override
    public void update(Bill bill) {

    }

    @Override
    public void delete(Long id) {

    }
}
