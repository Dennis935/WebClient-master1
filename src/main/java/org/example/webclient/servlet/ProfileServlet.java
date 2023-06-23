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
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Please login first</h1>");
            out.println("<p>You need to be logged in to access this page.</p>");
            out.println("<a href=\"login.jsp\">Login</a>");
            out.println("</body>");
            out.println("</html>");
        }

        out.close();
    }
}


