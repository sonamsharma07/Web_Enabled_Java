package test2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        if(uname.equals("admin") && pwd.equals("admin123")) 
        {
            out.println("Hello " + uname);
        } 
        else 
        {
            out.println("Login failed");
        }
        out.close();
    }
}
