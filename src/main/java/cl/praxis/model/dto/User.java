package cl.praxis.model.dto;
import java.time.LocalDate;
import java.sql.Timestamp;

public class User {
	
	private int id;
    private String correo;
    private Timestamp createdAt;
    private String nick;
    private String nombre;
    private String password;
    private int peso;
    private Timestamp updatedAt;
    private boolean isAdmin;
    private String direccion;
       
            
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String correo, String nick, String nombre, String password, int peso) {
		super();
		
		this.correo = correo;
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.peso = peso;
		
	}

	public User(int id, String correo, Timestamp createdAt, String nick, String nombre, String password, int peso, Timestamp updatedAt) {
		super();
		this.id = id;
		this.correo = correo;
		this.createdAt = createdAt;
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.peso = peso;
		this.updatedAt = updatedAt;
	}
	
	

	public User(int id, String correo, Timestamp createdAt, String nick, String nombre, String password, int peso, Timestamp updatedAt, boolean isAdmin, String direccion) {
		super();
		this.id = id;
		this.correo = correo;
		this.createdAt = createdAt;
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.peso = peso;
		this.updatedAt = updatedAt;
		this.isAdmin = isAdmin;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	
	
	
}
	
