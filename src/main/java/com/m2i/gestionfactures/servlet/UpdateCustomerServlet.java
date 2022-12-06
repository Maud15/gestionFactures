package com.m2i.gestionfactures.servlet;

import com.m2i.gestionfactures.model.Customer;
import com.m2i.gestionfactures.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = UpdateCustomerServlet.URL)
public class UpdateCustomerServlet extends HttpServlet {
    public static final String URL = "/customers/update";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Long id = Long.parseLong(idStr);
        Optional<Customer> optCust = new CustomerService().get(id);
        if(optCust.isPresent()){
            req.setAttribute("customer", optCust.get());
            req.getRequestDispatcher("/WEB-INF/update-customers.jsp").forward(req,resp);
        } else{
            req.setAttribute("error", "L'identifiant choisi ne correspond à aucun client");
            req.getRequestDispatcher("/WEB-INF/list-customer.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Long id = Long.parseLong(idStr);
        String designation = req.getParameter("designation");
        String address = req.getParameter("address");
        String postCode = req.getParameter("postCode");
        String city = req.getParameter("city");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");

        Customer customer = new Customer(id, designation, address, postCode, city, phoneNumber, email);
        new CustomerService().update(customer);
        resp.sendRedirect(req.getContextPath() + CustomersListServlet.URL);
    }
}
