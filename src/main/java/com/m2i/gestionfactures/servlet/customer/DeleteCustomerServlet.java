package com.m2i.gestionfactures.servlet.customer;

import com.m2i.gestionfactures.model.Customer;
import com.m2i.gestionfactures.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = DeleteCustomerServlet.URL)
public class DeleteCustomerServlet extends HttpServlet {
    public static final String URL = "/customers/delete";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Long id = Long.parseLong(idStr);
        Optional<Customer> optCust = new CustomerService().get(id);
        if(optCust.isPresent()){
            new CustomerService().delete(id);
        }
        resp.sendRedirect(req.getContextPath() + CustomersListServlet.URL);
    }
}
