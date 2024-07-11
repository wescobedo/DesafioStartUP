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

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String nick = request.getParameter("nick");
        String password = request.getParameter("password");
        int peso = Integer.parseInt(request.getParameter("peso"));

        if (userDAO.checkUserExists(correo)) {
            response.getWriter().println("User already exists with this email.");
        } else {
            User user = new User(correo, nick, nombre, password, peso);
            userDAO.create(user);
            response.getWriter().println("User registered successfully.");
        }
	}

}
