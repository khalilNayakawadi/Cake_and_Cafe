<%@page import="UserModule.UserDetails"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h1>User Profile</h1>
    <% 
        UserDetails userDetails = (UserDetails) request.getAttribute("profile");
    %>
    <p><strong>First Name:</strong> <%= userDetails.getFirstName() %></p>
    <p><strong>Last Name:</strong> <%= userDetails.getLastName() %></p>
    <p><strong>Last Name:</strong> <%= userDetails.getContact() %></p>
    <p><strong>Email:</strong> <%= userDetails.getEmail() %></p>
    <p><strong>Address:</strong> <%= userDetails.getAddress() %></p>
</body>
</html>
