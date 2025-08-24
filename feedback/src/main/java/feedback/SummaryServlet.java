package feedback;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SummaryServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException {
// Get session
HttpSession session = request.getSession(false);
response.setContentType("text/html");
PrintWriter out = response.getWriter();
if (session != null && session.getAttribute("name") != null) {
String name = (String) session.getAttribute("name");
String course = (String) session.getAttribute("course");
String pname = (String) session.getAttribute("pname");
String pcode = (String) session.getAttribute("pcode");
String rating = (String) session.getAttribute("rating");
String comments = (String) session.getAttribute("comments");
out.println("<html><body>");
out.println("<h2>Thank You for Your Feedback!</h2>");
out.println("<p><strong>Name:</strong> " + name + "</p>");
out.println("<p><strong>Course:</strong> " + course + "</p>");
out.println("<p><strong>Paper Name:</strong> " + pname + "</p>");
out.println("<p><strong>Paper Code:</strong> " + pcode + "</p>");

out.println("<p><strong>Rating:</strong> " + rating + "</p>");
out.println("<p><strong>Comments:</strong> " + comments + "</p>");
out.println("</body></html>");
} else {
out.println("<html><body><h3>No feedback found in session!</h3></body></html>");
}
}
}
