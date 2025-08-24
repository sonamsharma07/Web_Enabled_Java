package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ValidateServlet extends HttpServlet {

    // Handle POST requests (from login form)
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String user = req.getParameter("user");
        String pass = req.getParameter("pass");

        if ("1AdminisLogging!!".equals(pass) && "admin".equals(user)
        		) {
            // Forward to WelcomeServlet if password is correct
            RequestDispatcher rd = req.getRequestDispatcher("Welcome");
            rd.forward(req, res);
        } else {
            // Show login form again with error message
            out.println("<html><body>");
            out.println("<p style='color:red;'>Incorrect password</p>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
            out.println("</body></html>");
        }
    }

    // Handle GET requests (e.g., if someone visits the servlet URL directly)
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Redirect to login page
        res.sendRedirect("login.html");
    }
}
