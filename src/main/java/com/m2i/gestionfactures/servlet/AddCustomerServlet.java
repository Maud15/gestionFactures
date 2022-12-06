package com.m2i.gestionfactures.servlet;

import com.m2i.gestionfactures.model.Customer;
import com.m2i.gestionfactures.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = AddCustomerServlet.URL)
public class AddCustomerServlet extends HttpServlet {

    public static final String URL = "/customers/add";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/add-customer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String designation = req.getParameter("designation");
        String address = req.getParameter("address");
        String postCode = req.getParameter("postCode");
        String city = req.getParameter("city");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");

        Customer newCustomer = new Customer(designation, address, postCode,city, phoneNumber, email);
        CustomerService customerService = new CustomerService();

        customerService.create(newCustomer);

    }
}
