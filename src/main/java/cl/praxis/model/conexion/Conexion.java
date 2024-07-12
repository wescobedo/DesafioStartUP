package cl.praxis.model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	 private static Connection con = null;
	 
	 private Conexion () {
		 
		 try {
			 
			 Class.forName("org.postgresql.Driver");
			 
			 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StartUP", "postgres", "danett");
			 
			 boolean isValid = con.isValid(50000);
			 System.out.println(isValid ? "Test ok Postfresql" : "test failed postgresql");
			 
			 
		 } catch (ClassNotFoundException |  SQLException ex) {
			 
			 System.out.println("Error de conexion con la BdD; " + ex.getMessage());
			 
		 }
		 
		 
	 }

	public static Connection getCon() {
		
		if (con == null) {
			new Conexion();
		}
		
		return con;
	}

	public static Connection getConnection() {
		
		return null;
	}

	}
