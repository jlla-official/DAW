package modelo;

import java.sql.Date;

public class Personaje {

	private int id;
	private int idUsuario;
	private String nombre;
	private String genero;
	private String tipoPeinado;
	private String colorPeinado;
	private int slot;
	
	
	public Personaje(int idUsuario, String nombre, String genero, String tipoPeinado, String colorPeinado, int slot) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.genero = genero;
		this.tipoPeinado = tipoPeinado;
		this.colorPeinado = colorPeinado;
		this.slot = slot;
		
	}

	public Personaje(int id, int idUsuario, String nombre, String genero, String tipoPeinado, String colorPeinado, int slot) {
		this.id = id;
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.genero = genero;
		this.tipoPeinado = tipoPeinado;
		this.colorPeinado = colorPeinado;
		this.slot = slot;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTipoPeinado() {
		return tipoPeinado;
	}

	public void setTipoPeinado(String tipoPeinado) {
		this.tipoPeinado = tipoPeinado;
	}

	public String getColorPeinado() {
		return colorPeinado;
	}

	public void setColorPeinado(String colorPeinado) {
		this.colorPeinado = colorPeinado;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}
	
	public String recogerDatos() {
		return "[Id : " + this.id + "] [IdUsuario : " + this.idUsuario + "] [Slot : " +  this.slot + "] [Nombre : " + this.nombre +"] [Genero : " + this.genero + "] [Tipo de pelo : " + this.tipoPeinado + "] [ColorPeinado : " + this.colorPeinado + "]";
	}
	
	public String imprimirDatosSinNombreCampo() {
		return this.id + ", " + this.idUsuario + ", " +  this.slot + ", " + this.nombre +", " + this.genero + ", " + this.tipoPeinado + ", " + this.colorPeinado;
	}

	@Override
	public String toString() {
		return "[Nombre : " + this.nombre +"] [Genero : " + this.genero + "] [Tipo de pelo : " + this.tipoPeinado + "] [ColorPeinado : " + this.colorPeinado + "]";
	}
	
}
	