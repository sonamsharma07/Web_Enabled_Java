package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class add extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String n1 = req.getParameter("num1");
        String n2 = req.getParameter("num2");

        if (n1 == null || n2 == null || n1.trim().isEmpty() || n2.trim().isEmpty()) {
            out.println("Error: Please enter both numbers.");
            return;
        }

        try {
            int i = Integer.parseInt(n1.trim());
            int j = Integer.parseInt(n2.trim());
            int k = i + j;

            System.out.println("The result is: " + k); // Debug
            out.println("<h2>The result is: " + k + "</h2>");
        } catch (NumberFormatException e) {
            out.println("Error: Please enter valid integers.");
        }
    }
}
