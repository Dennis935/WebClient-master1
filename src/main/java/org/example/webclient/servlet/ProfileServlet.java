package org.example.webclient.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            // Überprüfen Sie, ob der Benutzer auf den Wishlist-Button geklickt hat
            String wishlistButton = request.getParameter("wishlistButton");
            if (wishlistButton != null && wishlistButton.equals("true")) {
                request.getRequestDispatcher("wishlist.jsp").forward(request, response);
                return; // Beenden Sie die Methode nach dem Weiterleiten zur Wishlist-Seite
            }
            request.getRequestDispatcher("cart.jsp").include(request, response);
        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Please login</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    background-color: #f1f1f1;");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    text-align: center;");
            out.println("}");
            out.println("h1 {");
            out.println("    color: #333333;");
            out.println("}");
            out.println("</style>");

            // JavaScript-Code für das Anzeigen des Modalfensters
            out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
            out.println("<script>");
            out.println("window.onload = function() {");
            out.println("    swal({");
            out.println("        title: 'Please login first',");
            out.println("        text: 'You need to be logged in to access this page.',");
            out.println("        icon: 'info',");
            out.println("        confirmButtonColor: '#235da8',");
            out.println("        button: 'Login',");
            out.println("    }).then(function() {");
            out.println("        window.location.href = 'login.jsp';");
            out.println("    });");
            out.println("};");
            out.println("</script>");


            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        }
        out.close();
    }
}


