package com.m2i.gestionfactures.service;

import com.m2i.gestionfactures.dao.BillDao;
import com.m2i.gestionfactures.dao.CustomerDao;
import com.m2i.gestionfactures.model.Bill;
import com.m2i.gestionfactures.model.Customer;

import java.util.List;
import java.util.Optional;

public class BillService implements Service<Bill>{
    @Override
    public Optional<Bill> get(Long id) {
        Optional<Bill> optBill;

        BillDao billDao = new BillDao();
        optBill = billDao.get(id);

        if(optBill.isPresent()) {
            setBillNumber(optBill.get());
        }

        return optBill;
    }

    @Override
    public List<Bill> getAll() {
        return null;
    }

    private void setBillNumber (Bill bill) {
        if(bill != null) {
            StringBuilder billNumber = new StringBuilder("F");
            String idStr = bill.getId().toString();
            while (billNumber.length() + idStr.length() < 10) {
                billNumber.append("0");
            }
            billNumber.append(idStr);
            bill.setBillNumber(billNumber.toString());
        }
    }


    @Override
    public Bill create(Bill bill) {
        return new BillDao().create(bill);
    }

    @Override
    public void update(Bill bill) {
        new BillDao().update(bill);

    }

    @Override
    public void delete(Long id) {
        new BillDao().delete(id);
    }
}
