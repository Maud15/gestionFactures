package com.m2i.gestionfactures.service;

import com.m2i.gestionfactures.dao.CustomerDao;
import com.m2i.gestionfactures.model.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerService implements Service<Customer>{

    @Override
    public Optional<Customer> get(Long id) {
        Optional<Customer> optCustomer;

        CustomerDao customerDao = new CustomerDao();
        optCustomer = customerDao.get(id);

        if(optCustomer.isPresent()) {
            setCustomerNumber(optCustomer.get());
        }

        return optCustomer;
    }

    @Override
    public List<Customer> getAll() {
        CustomerDao customerDao = new CustomerDao();
        List<Customer> customers = customerDao.getAll();
        customers.forEach(c -> setCustomerNumber(c));

        return customers;
    }

    private void setCustomerNumber (Customer customer) {
        if(customer != null) {
            StringBuilder customerNumber = new StringBuilder("C");
            String idStr = customer.getId().toString();
            while (customerNumber.length() + idStr.length() < 6) {
                customerNumber.append("0");
            }
            customerNumber.append(idStr);
            customer.setCustomerNumber(customerNumber.toString());
        }
    }

    @Override
    public Customer create(Customer customer) {
        return new CustomerDao().create(customer);
    }

    @Override
    public void update(Customer customer) {
        new CustomerDao().update(customer);
    }

    @Override
    public void delete(Long id) {
        new CustomerDao().delete(id);
    }
}
