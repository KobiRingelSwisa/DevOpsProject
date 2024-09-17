<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple JSP Web Application</title>
</head>
<body>
    <h1>Welcome to the Simple JSP Web Application</h1>

    <!-- Input Text Box -->
    <form action="submit.jsp" method="post">
        <label for="userInput">Enter something:</label>
        <input type="text" id="userInput" name="userInput" required>
        <!-- Submit Button -->
        <button type="submit">Submit</button>
    </form>

    <!-- Link to another page -->
    <a href="anotherPage.jsp">Go to Another Page</a>

</body>
</html>
