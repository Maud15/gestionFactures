package com.m2i.gestionfactures.servlet.bill;

import com.m2i.gestionfactures.model.Bill;
import com.m2i.gestionfactures.model.Product;
import com.m2i.gestionfactures.model.ProductBill;
import com.m2i.gestionfactures.service.BillService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet(urlPatterns = BillDetailsServlet.URL)
public class BillDetailsServlet extends HttpServlet {
    public static final String URL = "/bill/details";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("billId");
        Long id = Long.parseLong(idStr);
        Optional<Bill> optBill = new BillService().get(id);
        if(optBill.isPresent()){
            req.setAttribute("bill", optBill.get());
            req.setAttribute("amountTaxFree", Math.round(optBill.get().getAmountTaxFree() * 100) / 100);
            req.setAttribute("amountWithTax", optBill.get().getAmountWithTax());
            //ProductBillService pbService = new ProductBillService();
            Map<Product, Float> quantities = new HashMap<>();
            List<ProductBill> productBillList = optBill.get().getProductsBillsList();
            for(ProductBill pb : productBillList){
                quantities.put(pb.getProduct(), pb.getQuantity());
            }
            req.setAttribute("quantities", quantities);
            req.getRequestDispatcher("/WEB-INF/bill/bill-details.jsp").forward(req,resp);
        }
    }
}
