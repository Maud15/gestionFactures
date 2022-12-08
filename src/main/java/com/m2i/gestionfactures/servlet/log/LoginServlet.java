package com.m2i.gestionfactures.servlet.log;

import com.m2i.gestionfactures.servlet.customer.CustomersListServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = LoginServlet.URL)
public class LoginServlet extends HttpServlet {

    public static final String URL = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute("username") != null){
            resp.sendRedirect(CustomersListServlet.URL);
        }else {
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("admin") && password.equals("qwerty")) {
            HttpSession session = req.getSession(true);
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(30 * 60);

            Cookie cookieUser = new Cookie("username", username);
            resp.addCookie(cookieUser);

            resp.sendRedirect(CustomersListServlet.URL);
        }else {
            req.setAttribute("loginFail", true);
            doGet(req, resp);
        }
    }
}
