<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Processing Page</title>
</head>
<body>
    <h1>Form Submitted Successfully!</h1>
    <%
        String name = request.getParameter("name");
        if (name != null && !name.isEmpty()) {
            out.println("<p>Hello, " + name + "!</p>");
        } else {
            out.println("<p>Please enter a valid name.</p>");
        }
    %>
    <a href="index.jsp">Go back</a>
</body>
</html>
