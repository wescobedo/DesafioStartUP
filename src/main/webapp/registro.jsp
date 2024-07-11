<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
    <h1>Registro</h1>
    <form action="RegistroServlet" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>
        <label for="nombre">Correo:</label>
        <input type="text" id="correo" name="correo" required><br>
        <label for="nick">Nick:</label>
        <input type="text" id="nick" name="nick"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <label for="peso">Peso:</label>
        <input type="number" id="peso" name="peso"><br>
        <button type="submit">Registro</button>
</body>
</html>