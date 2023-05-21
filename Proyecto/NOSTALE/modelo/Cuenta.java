package modelo;

public class Cuenta {

	private int id;
	private String usuario;
	private String contrasena;
	private String email;
	private int rol;
	private boolean banned = false;
	
	
	public Cuenta() {}


	public Cuenta(int id, String usuario, String contrasena, String email, int rol, boolean banned) {
		this.id = id;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.email = email;
		this.rol = rol;
		this.banned = banned;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getRol() {
		return rol;
	}


	public void setRol(int rol) {
		this.rol = rol;
	}


	public boolean isBanned() {
		return banned;
	}


	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	
	public String recogerDatos() {
		return "[Id : " + this.id + "] [Usuario : " + this.usuario + "] [Contraseña : " +  this.contrasena + "] [Rol : " + this.rol +"] [Banned : " + this.banned + "]";
	}

}
