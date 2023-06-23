package org.example.webclient.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Benutzersitzung löschen
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.setAttribute("loggedIn", false);

        // Weiterleitung zur Login-Seite
        request.getRequestDispatcher("login.jsp").include(request, response);

        Cookie ck = new Cookie("name", "");
        ck.setMaxAge(0);
        response.addCookie(ck);

        out.print("You are successfully logged out!");
    }
}
