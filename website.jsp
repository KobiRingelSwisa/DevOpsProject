<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple JSP Web App</title>
</head>
<body>
    <h1>Welcome to Simple JSP Web Application</h1>
    <form action="process.jsp" method="POST">
        <label for="name">Enter Your Name Please:</label>
        <input type="text" id="name" name="name" required>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
