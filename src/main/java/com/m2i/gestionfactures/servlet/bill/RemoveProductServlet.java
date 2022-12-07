package com.m2i.gestionfactures.servlet.bill;

import com.m2i.gestionfactures.dao.ProductBillDao;
import com.m2i.gestionfactures.model.Bill;
import com.m2i.gestionfactures.model.Product;
import com.m2i.gestionfactures.service.BillService;
import com.m2i.gestionfactures.service.ProductService;
import com.m2i.gestionfactures.servlet.customer.CustomersListServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = RemoveProductServlet.URL)
public class RemoveProductServlet extends HttpServlet {
    public static final String URL = "/bill/removeProduct";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strBillId = req.getParameter("billId");
        Long billId = Long.parseLong(strBillId);
        Optional<Bill> bill = new BillService().get(billId);
        String strProductId = req.getParameter("productId");
        Long productId = Long.parseLong(strProductId);
        Optional<Product> product = new ProductService().get(productId);
        if(bill.isPresent() && product.isPresent()){
            new ProductBillDao().delete(product.get(), bill.get());
        }
        resp.sendRedirect(req.getContextPath() + CustomersListServlet.URL);
    }
}
