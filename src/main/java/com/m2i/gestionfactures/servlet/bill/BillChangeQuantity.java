package com.m2i.gestionfactures.servlet.bill;

import com.m2i.gestionfactures.dao.ProductBillDao;
import com.m2i.gestionfactures.model.Bill;
import com.m2i.gestionfactures.model.Product;
import com.m2i.gestionfactures.model.ProductBill;
import com.m2i.gestionfactures.service.BillService;
import com.m2i.gestionfactures.service.ProductBillService;
import com.m2i.gestionfactures.service.ProductService;
import com.m2i.gestionfactures.servlet.customer.CustomersListServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = BillChangeQuantity.URL)
public class BillChangeQuantity extends HttpServlet {
    public static final String URL = "/bill/changeQuantity";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strBillId = req.getParameter("billId");
        String strProductId = req.getParameter("productId");
        Long productId = Long.parseLong(strProductId);
        Product product = new ProductService().get(productId).get();
        req.setAttribute("billId", req.getParameter("billId"));
        req.setAttribute("product", product);
        req.setAttribute("quantity", req.getParameter("quantity"));
        req.getRequestDispatcher("/WEB-INF/bill/change-quantity.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strBillId = req.getParameter("billId");
        Long billId = Long.parseLong(strBillId);
        Optional<Bill> bill = new BillService().get(billId);
        String strProductId = req.getParameter("productId");
        Long productId = Long.parseLong(strProductId);
        Optional<Product> product = new ProductService().get(productId);
        String strQuantity = req.getParameter("quantity");
        Float qty = Float.parseFloat(strQuantity);
        if(bill.isPresent() && product.isPresent()){
            if(qty > 0){
                ProductBill pb = new ProductBill(bill.get(), product.get(), qty);
                new ProductBillDao().update(pb);
            } else{
                new ProductBillDao().delete(product.get(), bill.get());
            }
        }
        resp.sendRedirect(req.getContextPath() + CustomersListServlet.URL);

    }
}
