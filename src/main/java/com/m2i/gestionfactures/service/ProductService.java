package com.m2i.gestionfactures.service;

import com.m2i.gestionfactures.dao.ProductDao;
import com.m2i.gestionfactures.model.Product;
import com.m2i.gestionfactures.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductService implements Service<Product>{
    @Override
    public Optional<Product> get(Long id) {
        Optional<Product> optProduct;

        ProductDao productDao = new ProductDao();
        optProduct = productDao.get(id);
        return optProduct;
    }

    @Override
    public List<Product> getAll() {
        return new ProductDao().getAll();
    }


    @Override
    public Product create(Product product) {
        return new ProductDao().create(product);
    }

    @Override
    public void update(Product product) {
        new ProductDao().update(product);

    }

    @Override
    public void delete(Long id) {
        new ProductDao().delete(id);
    }
}
