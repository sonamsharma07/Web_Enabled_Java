package feedback;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
public class FeedbackServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException {
// Retrieve form data
String name = request.getParameter("name");
String course = request.getParameter("course");
String pname = request.getParameter("pname ");
String pcode = request.getParameter("pcode");
String rating = request.getParameter("rating");
String comments = request.getParameter("comments");
// Store in session
HttpSession session = request.getSession();
session.setAttribute("name", name);
session.setAttribute("course", course);
session.setAttribute("pname", pname);
session.setAttribute("pcode", pcode);
session.setAttribute("rating", rating);
session.setAttribute("comments", comments);
// Redirect to summary servlet
response.sendRedirect("SummaryServlet");
}
}
