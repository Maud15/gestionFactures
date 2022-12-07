package com.m2i.gestionfactures.servlet.product;

import com.m2i.gestionfactures.model.Product;
import com.m2i.gestionfactures.service.ProductService;
import com.m2i.gestionfactures.servlet.customer.CustomersListServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = AddProductServlet.URL)
public class AddProductServlet extends HttpServlet {
    public static final String URL = "/products/add";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/product/add-product.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String reference = req.getParameter("reference");
        String description = req.getParameter("description");
        String strPriceTaxFree = req.getParameter("priceTaxFree");
        Float priceTaxFree = Float.parseFloat(strPriceTaxFree);
        String strTaxRate = req.getParameter("taxRate");
        Float taxRate = Float.parseFloat(strTaxRate);
        String unit = req.getParameter("unit");

        Product product = new Product(reference, description, unit, priceTaxFree, taxRate);
        try{
            new ProductService().create(product);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        resp.sendRedirect(req.getContextPath() + CustomersListServlet.URL);

    }
}
