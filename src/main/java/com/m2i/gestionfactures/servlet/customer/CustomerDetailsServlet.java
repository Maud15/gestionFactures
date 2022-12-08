package com.m2i.gestionfactures.servlet.customer;

import com.m2i.gestionfactures.model.Bill;
import com.m2i.gestionfactures.model.Customer;
import com.m2i.gestionfactures.service.BillService;
import com.m2i.gestionfactures.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet(urlPatterns = CustomerDetailsServlet.URL)
public class CustomerDetailsServlet extends HttpServlet {
    public static final String URL = "/customers/details";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("customerId");
        if (idStr == null){
            idStr = (String) req.getAttribute("customerId");
        }

        Long id = Long.parseLong(idStr);
        Optional<Customer> optCust = new CustomerService().get(id);
        req.setAttribute("customer", optCust.get());
        Map<Bill, Float> withoutTax = new HashMap<>();
        Map<Bill, Float> withTax = new HashMap<>();
        for(Bill bill : optCust.get().getBillList()){
            withoutTax.put(bill, bill.getAmountTaxFree());
            withTax.put(bill, bill.getAmountWithTax());
        }
        req.setAttribute("withTax", withTax);
        req.setAttribute("withoutTax", withoutTax);
        req.getRequestDispatcher("/WEB-INF/customer/customer-details.jsp").forward(req,resp);
    }
}
