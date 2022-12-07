package com.m2i.gestionfactures.service;

import com.m2i.gestionfactures.dao.ProductBillDao;
import com.m2i.gestionfactures.model.Bill;
import com.m2i.gestionfactures.model.Product;
import com.m2i.gestionfactures.model.ProductBill;

import java.util.Optional;

public class ProductBillService {
    public Float getQuantity(Product product, Bill bill){
        Optional<ProductBill> optPb = new ProductBillDao().get(product, bill);
        if(optPb.isPresent()){
            return optPb.get().getQuantity();
        }
        return 0f;
    }
}
