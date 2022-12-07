package com.m2i.gestionfactures.servlet.bill;

import com.m2i.gestionfactures.model.Bill;
import com.m2i.gestionfactures.service.BillService;
import com.m2i.gestionfactures.servlet.customer.CustomerDetailsServlet;
import com.m2i.gestionfactures.servlet.customer.CustomersListServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = DeleteBillServlet.URL)
public class DeleteBillServlet extends HttpServlet {
    public static final String URL = "/bill/delete";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Optional<Bill> optBill = new BillService().get(id);
        if(optBill.isPresent()) {
            new BillService().delete(id);
        } else {
            req.setAttribute("error","Erreur suppression de facture : Impossible de trouver la facture d'id :" + id);
            System.out.println("DeleteBill error: Impossible de trouver la facture d'id :" + id);
        }
        //todo: vérifier que ça renvoie au bon endroit, et chercher comment lui passer le bon customer à afficher ?
        // doit-on se passer l'id du client à afficher en paramètre de la requète post ?

        resp.sendRedirect(req.getContextPath() + CustomersListServlet.URL);
    }
}
