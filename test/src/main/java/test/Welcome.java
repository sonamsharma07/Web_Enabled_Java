package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Welcome extends HttpServlet {

    // Handle POST request (coming from ValidateServlet)
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String user = req.getParameter("user");

        out.println("<html><body>");
        out.println("<h2>Welcome " + user + "</h2>");
        out.println("</body></html>");
    }

    // Handle GET request (e.g., direct URL access)
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("<h2>You must login first.</h2>");
        out.println("<a href='login.html'>Go to Login</a>");
        out.println("</body></html>");
    }
}