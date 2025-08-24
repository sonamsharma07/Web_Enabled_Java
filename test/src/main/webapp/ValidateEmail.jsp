<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email Validation Result</title>
</head>
<body>
<h2>Email Validation Result</h2>
<%
    String email = request.getParameter("email");
    boolean isValid = true;

    if (email != null) email = email.trim();

    if (email == null || email.isEmpty()) {
        isValid = false;
    } else {
        // Rule 0: No whitespace anywhere
        if (email.contains(" ") || email.contains("\t") || email.contains("\n")) {
            isValid = false;
        }

        // Rule 1: Exactly one '@' and not first/last character
        int atPos = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        if (atPos <= 0 || atPos != lastAt || atPos == email.length() - 1) {
            isValid = false;
        }

        // Rule 2: Must have at least one '.' after '@'
        int dotPos;
        if (atPos >= 0) {
            dotPos = email.indexOf('.', atPos + 1);
        } else {
            dotPos = -1;
        }
        int lastDot = email.lastIndexOf('.');
        if (dotPos == -1) {
            isValid = false;
        }

        // Rule 3: At least two characters between '@' and the first '.' after it
        if (dotPos != -1 && (dotPos - atPos - 1) < 2) {
            isValid = false;
        }

        // Rule 4: No two consecutive dots anywhere
        if (email.contains("..")) {
            isValid = false;
        }

        // Rule 5: TLD must be at least 2 characters and '.' not last char
        if (lastDot == -1 || lastDot == email.length() - 1 || (email.length() - 1 - lastDot) < 2) {
            isValid = false;
        }
    }

    if (isValid) {
        out.println("<p style='color:green;'>Valid Email</p>");
    } else {
        out.println("<p style='color:red;'>Invalid Email</p>");
    }
%>
<br>
<a href="email_form.html">Go Back</a>
</body>
</html>
