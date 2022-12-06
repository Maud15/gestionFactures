package com.m2i.gestionfactures.servlet.bill;

import com.m2i.gestionfactures.model.Bill;
import com.m2i.gestionfactures.model.Customer;
import com.m2i.gestionfactures.service.BillService;
import com.m2i.gestionfactures.service.CustomerService;
import com.m2i.gestionfactures.servlet.customer.CustomerDetailsServlet;
import com.m2i.gestionfactures.servlet.customer.CustomersListServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@WebServlet(urlPatterns = AddBillServlet.URL)
public class AddBillServlet extends HttpServlet {
    public static final String URL = "/bill/add";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("customerId");
        Long customerId = Long.parseLong(idStr);
        req.setAttribute("customerId", customerId);
        req.getRequestDispatcher("/WEB-INF/bill/add-bill.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateStr = req.getParameter("date");
        LocalDate date = LocalDate.parse(dateStr);
        String idStr = req.getParameter("customerId");

        Long idCustomer = Long.parseLong(idStr);
        req.setAttribute("customerId", idStr);
        Optional<Customer> optCust = new CustomerService().get(idCustomer);
        if(optCust.isPresent()){
            Bill bill = new Bill(date, optCust.get());
            new BillService().create(bill);
        }
        //TODO : rediriger vers le détail du client choisi précédemment
        resp.sendRedirect(req.getContextPath() + CustomersListServlet.URL);
    }
}
