package time;

import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class DateTimeServlet extends HttpServlet 
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Set auto-refresh every 5 seconds
        res.setHeader("Refresh", "5");

        // Get current date & time
        Date now = new Date();

        out.println("<html><head><title>Date & Time</title></head><body>");
        out.println("<h2>Current Date and Time</h2>");
        out.println("<p>" + now.toString() + "</p>");
        out.println("<br><a href='index.html'>Back to Home</a>");
        out.println("</body></html>");

        out.close();
    }
}
