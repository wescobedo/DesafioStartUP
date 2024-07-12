package cl.praxis.model.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.sql.Timestamp;

import cl.praxis.model.conexion.Conexion;
import cl.praxis.model.dto.User;

public class UserDAO {

	public void create(User a) {

		String sql = "insert into usuarios (correo, nick, nombre, password, peso ) values ('" + a.getCorreo() + "', '" + a.getNick() + "', '" + a.getNombre() + "', '" + a.getPassword() +"', "+ a.getPeso() +")";
		
		System.out.println(sql);
		
		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			s.execute(sql);
		}  catch (SQLException e) {
			System.out.println("ERROR en método create()");
			e.printStackTrace();
		}
		
	}

	public User read(String correo) {
		User a = null;

		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "SELECT u.*, d.nombre as direccion, ru.rol_id FROM usuarios u INNER JOIN direcciones d ON u.id = d.usuario_id INNER JOIN roles_usuarios ru ON u.id = ru.usuario_id WHERE u.correo =  '" + correo+"'";
				
			ResultSet rs = s.executeQuery(sql);
						
			if (rs.next()) {
				boolean isAdmin = rs.getInt("rol_id") == 1;
				a = new User(rs.getInt("id"), rs.getString("correo"), rs.getTimestamp("created_at") ,rs.getString("nick"), rs.getString("nombre"),rs.getString("password"), rs.getInt("peso"), rs.getTimestamp("updated_at") ,isAdmin, rs.getString("direccion"));
			}
		} catch (SQLException e) {
			System.out.println("ERROR en método read(id)");
			e.printStackTrace();
		}

		return a;
	}

	public List<User> read() {

		List<User> user = new ArrayList<User>();

		try {

			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "SELECT u.*, d.nombre as direccion, ru.rol_id FROM usuarios u INNER JOIN direcciones d ON u.id = d.usuario_id INNER JOIN roles_usuarios ru ON u.id = ru.usuario_id";

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				boolean isAdmin = rs.getInt("rol_id") == 1;

				user.add(new User(rs.getInt("id"), rs.getString("correo"), rs.getTimestamp("created_at") ,rs.getString("nick"), rs.getString("nombre"),rs.getString("password"), rs.getInt("peso"), rs.getTimestamp("updated_at"), isAdmin, rs.getString("direccion")));
			}

		} catch (SQLException e) {
			System.out.println("ERROR en método read()");
			e.printStackTrace();
		}

		return user;
	}

	public boolean checkUserExists(String correo) {
		
		
		try {
			Connection c = Conexion.getCon();

			Statement s = c.createStatement();
			String sql = "select * from usuarios where correo = '" + correo+"'";
			ResultSet rs = s.executeQuery(sql);
			return rs.next();
				
		} catch (SQLException e) {
			System.out.println("ERROR en método checkUserExists(correo)");
			e.printStackTrace();
		}

		return false;
		
				
    }
}
	
	
	

