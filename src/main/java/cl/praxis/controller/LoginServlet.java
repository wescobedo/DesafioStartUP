package cl.praxis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.praxis.model.dao.UserDAO;
import cl.praxis.model.dto.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		
		 String correo = request.getParameter("correo");
	     String password = request.getParameter("password");

	     User user = userDAO.read(correo);
	       

	        if (user != null && user.getPassword().equals(password)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("user", user);
	           	            
	            if (user.isAdmin()) {
	                List<User> usuarios = userDAO.read();
	                request.setAttribute("usuarios", usuarios);
	                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	                dispatcher.forward(request, response);
	            } else {
	                response.getWriter().println("Usuario no tiene el rol de administrador.");
	            }
              
	           
	        } else {
	            response.getWriter().println("Correo o password invalidos.");
	        }
		
		
	}

}
