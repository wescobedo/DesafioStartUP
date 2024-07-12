<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cl.praxis.model.dto.User" %>
<%@ page import="java.util.List" %>

<%@ page session="true" %>  
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

<h1>Listado de usuarios</h1>
    <%
        User user = (User) session.getAttribute("user");
    User loggedInUser = (User) session.getAttribute("user");
    if (loggedInUser != null && loggedInUser.isAdmin()) {
        List<User> usuarios = (List<User>) request.getAttribute("usuarios");
        if (usuarios != null) {
%>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Nick</th>
                    <th>Peso</th>
                    <th>Direccion</th>
                </tr>
                <%
                    for (User usuario : usuarios) {
                %>
                    <tr>
                        <td><%= usuario.getId() %></td>
                        <td><%= usuario.getNombre() %></td>
                        <td><%= usuario.getCorreo() %></td>
                        <td><%= usuario.getNick() %></td>
                        <td><%= usuario.getPeso() %></td>
                        <td><%= usuario.getDireccion() %></td>
                        
                        
                    </tr>
                <%
                    }
                %>
            </table>
<%
        } else {
            out.println("No se encontraron usuarios.");
        }
    } else {
        out.println("Acceso denegado. No tiene permisos de administrador.");
    }

     %>

</body>
</html>