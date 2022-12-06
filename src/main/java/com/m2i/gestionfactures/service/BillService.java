package com.m2i.gestionfactures.service;

import com.m2i.gestionfactures.dao.BillDao;
import com.m2i.gestionfactures.model.Bill;

import java.util.List;
import java.util.Optional;

public class BillService implements Service<Bill>{
    @Override
    public Optional<Bill> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Bill> getAll() {
        return null;
    }

    @Override
    public Bill create(Bill bill) {
        return new BillDao().create(bill);
    }

    @Override
    public void update(Bill bill) {

    }

    @Override
    public void delete(Long id) {

    }
}
