package com.m2i.gestionfactures.servlet.bill;

import com.m2i.gestionfactures.dao.ProductBillDao;
import com.m2i.gestionfactures.model.Bill;
import com.m2i.gestionfactures.model.Product;
import com.m2i.gestionfactures.model.ProductBill;
import com.m2i.gestionfactures.service.BillService;
import com.m2i.gestionfactures.service.ProductService;
import com.m2i.gestionfactures.servlet.customer.CustomersListServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = AddProductToBillServlet.URL)
public class AddProductToBillServlet extends HttpServlet {
    public static final String URL = "/bill/add-product";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("billId");
        Long id = Long.parseLong(idStr);
        Optional<Bill> optBill = new BillService().get(id);
        if(optBill.isPresent()){
            req.setAttribute("bill", optBill.get());
            List<Product> products = new ProductService().getAll();
            req.setAttribute("products", products);
            req.getRequestDispatcher("/WEB-INF/bill/add-product-to-bill.jsp").forward(req,resp);
        } else{
            resp.sendRedirect(req.getContextPath() + CustomersListServlet.URL);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String billIdStr = req.getParameter("billId");
        Long billId = Long.parseLong(billIdStr);
        String productIdStr = req.getParameter("productId");
        Long productId = Long.parseLong(productIdStr);
        String quantityStr = req.getParameter("quantity");
        Float quantity = Float.parseFloat(quantityStr);
        BillService billService = new BillService();
        Optional<Bill> optBill = billService.get(billId);

        ProductService productService = new ProductService();
        Optional<Product> optProduct = productService.get(productId);

        if(optBill.isPresent() && optProduct.isPresent()){
            ProductBill productBill = new ProductBill(optBill.get(), optProduct.get(), quantity);
            new ProductBillDao().create(productBill);
        }
        resp.sendRedirect(req.getContextPath() + CustomersListServlet.URL);
    }
}
