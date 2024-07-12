package cl.praxis.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import cl.praxis.model.dao.UserDAO;
import cl.praxis.model.dto.User;


@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }
       
    
    public RegistroServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String nick = request.getParameter("nick");
        String password = request.getParameter("password");
        int peso = Integer.parseInt(request.getParameter("peso"));

        if (userDAO.checkUserExists(correo)) {
            response.getWriter().println("Ya existe usuario con este correo.");
        } else {
            User user = new User(correo, nick, nombre, password, peso);
            userDAO.create(user);
            response.getWriter().println("Usuario registrado exitosamente.");
        }
	}

}
