package org.example.webclient.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        String password = request.getParameter("password");

        if (validateLogin(name, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            request.setAttribute("loggedIn", true);

            Cookie ck = new Cookie("name", name);
            response.addCookie(ck);
            response.sendRedirect("index.jsp");
        } else {
            out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
            out.println("<script>");
            out.println("window.onload = function() {");
            out.println("    swal({");
            out.println("        title: 'Error',");
            out.println("        text: 'Wrong username or password!',");
            out.println("        icon: 'error',");
            out.println("        confirmButtonColor: '#235da8',");
            out.println("        button: 'ok',");
            out.println("    }).then(function() {");
            out.println("       Swal.close();");
            out.println("    });");
            out.println("};");
            out.println("</script>");


            request.getRequestDispatcher("login.jsp").include(request, response);
            request.setAttribute("loggedIn", false);
        }

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }


    private boolean validateLogin(String username, String password) {
        try {
            String urlString = "http://localhost:8080/AppServerWar/api/rest/login?username=" +
                    URLEncoder.encode(username, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8");
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse JSON response
                JSONObject json = new JSONObject(response.toString());
                String usernameFromResponse = json.getString("username");

                return username.equals(usernameFromResponse);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

}

