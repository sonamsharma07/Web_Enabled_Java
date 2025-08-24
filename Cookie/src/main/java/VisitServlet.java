import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        Cookie[] cookies = req.getCookies();
        int count = 0;

        if(cookies != null)
        {
            for(Cookie c : cookies)
            {
                if(c.getName().equals("visits"))
                {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        count++;

        Cookie visitCookie = new Cookie("visits", String.valueOf(count));
        visitCookie.setMaxAge(60 * 60 * 24 * 7); // 7 days
        res.addCookie(visitCookie);

        out.println("<html><body>");
        out.println("<h2>You have visited this servlet " + count + " times.</h2>");
        out.println("</body></html>");
    }
}
