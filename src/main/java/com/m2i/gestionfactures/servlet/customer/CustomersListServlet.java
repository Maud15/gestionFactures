package com.m2i.gestionfactures.servlet.customer;

import com.m2i.gestionfactures.model.Customer;
import com.m2i.gestionfactures.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = CustomersListServlet.URL)
public class CustomersListServlet extends HttpServlet {
    public static final String URL = "/customers";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = new CustomerService().getAll();
        req.setAttribute("customers", customers);
        req.setAttribute("error", "Je suis une grosse patate !");
        req.getRequestDispatcher("/WEB-INF/customer/list-customer.jsp").forward(req,resp);
    }
}
