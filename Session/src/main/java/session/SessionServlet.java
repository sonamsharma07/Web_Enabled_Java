package session;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet extends HttpServlet 
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Check if destroy was requested
        String destroy = req.getParameter("destroy");

        // Create or get session
        HttpSession session = req.getSession(true);

        out.println("<h2>Session Details</h2>");
        out.println("Session ID: " + session.getId() + "<br>");
        out.println("Created: " + new java.util.Date(session.getCreationTime()) + "<br>");
        out.println("Last Accessed: " + new java.util.Date(session.getLastAccessedTime()) + "<br><br>");

        if ("true".equals(destroy)) {
            // Destroy session
            session.invalidate();
            out.println("<h3>Session destroyed successfully!</h3>");
        } else {
            // Track visits
            Integer visitCount = (Integer) session.getAttribute("visitCount");

            if (visitCount == null) {
                visitCount = 1;
                out.println("<h3>Welcome! This is your first visit.</h3>");
            } else {
                visitCount++;
                out.println("<h3>Welcome back! You have visited " + visitCount + " times.</h3>");
            }
            session.setAttribute("visitCount", visitCount);
        }

        // Add back button
        out.println("<br><a href='index.html'>Back to Home</a>");
        out.close();
    }
}
