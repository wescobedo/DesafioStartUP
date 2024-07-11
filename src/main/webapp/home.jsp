<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cl.praxis.model.dto.User" %>
<%@ page session="true" %>  
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

<h1>Welcome Home</h1>
    <%
        User user = (User) session.getAttribute("user");
        if (user != null) {
            out.println("Nombre: " + user.getNombre() + "<br>");
            out.println("Correo: " + user.getCorreo() + "<br>");
        } else {
            response.sendRedirect("index.jsp");
        }
     %>

</body>
</html>