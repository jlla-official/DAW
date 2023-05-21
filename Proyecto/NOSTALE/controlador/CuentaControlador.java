package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;
import servicios.ConexionBDServicio;
import servicios.CuentaServicio;
import vista.MensajeEmergente;
import vista.PanelDeInformacion;
import vista.SeleccionPersonaje;

public class CuentaControlador {
	
	public Cuenta login(String usuario, String contrasena) {
		
		try {
			Cuenta cuenta = new CuentaControlador().getCuenta(usuario, contrasena);
			return cuenta;
		} catch (Exception e) {
			new MensajeEmergente("Usuario o contraseña incorrecta");
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public String registrarse(String usuario, String contrasena, String email) {
		
		try {
			new CuentaServicio().registrarse(usuario, contrasena, email);
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage().split("'")[1];
		}
		
	}
	

	public Cuenta getCuenta(String usuario, String contrasena)  {
		
		try {
			return new CuentaServicio().getCuenta(usuario, contrasena);
			
		} catch (Exception error) {
			new MensajeEmergente(error.getMessage());
			error.printStackTrace();
			return null;
		}
	
	}
	
	public String actualizarEmail(String nuevoEmail, int idUsuario) {
		
			try {
				new CuentaServicio().actualizarEmail(nuevoEmail, idUsuario);
				return null;
			} catch (SQLException e) {				
				System.out.println(e.getMessage());
				return e.getMessage();
			}
		
	}
	
	public String actualizarContrasena(String nuevaContrasena, int idUsuario) {
		
		try {
			new CuentaServicio().actualizarContrasena(nuevaContrasena, idUsuario);
			return null;
		} catch (SQLException e) {	
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	
	}

	
	public String listarCuentasBD(){
			
			try {
				return new CuentaServicio().listarCuentasBD();
			} catch (SQLException e) {
				return e.getMessage();
				
			}
	}
	
	public String listarCuentasBaneadasBD(){
		
		try {
			return new CuentaServicio().listarCuentasBaneadasBD();
		} catch (SQLException e) {
			return e.getMessage();
			
		}
	}
	
	public String banearCuenta(String usuario) {
		
		try {
			new CuentaServicio().banearCuenta(usuario);
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public String desbanearCuenta(String usuario) {
		
		try {
			new CuentaServicio().desbanearCuenta(usuario);
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	
}
