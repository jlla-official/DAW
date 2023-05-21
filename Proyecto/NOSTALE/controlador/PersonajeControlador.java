package controlador;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Personaje;
import servicios.ConexionBDServicio;
import servicios.PersonajeServicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersonajeControlador {
	
	public String insertarPersonajeBD(Personaje personaje) {
		
		try {
			new PersonajeServicio().insertarPersonajeBD(personaje);
			return "";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}
	
	
	public Personaje recogerPersonajeBD(int idUsuario, int slot) {
		
			try {
				return new PersonajeServicio().recogerPersonajeBD(idUsuario, slot);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
			
	}
	
	public Personaje recogerPersonajeBD(String nombrePersonaje) {
		
		try {
			return new PersonajeServicio().recogerPersonajeBD(nombrePersonaje);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	
	
	public String borrarPersonaje(int idPersonaje) {
		
		try {
			new PersonajeServicio().borrarPersonaje(idPersonaje);
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
			
		}
		
	}
	
	
	public String listarPersonajesBD(){
			
			try {
				return new PersonajeServicio().listarPersonajesBD();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return e.getMessage();
			}
			
	}

	
	public ArrayList<Personaje> extraerPersonajesTXT(String rutaTXT) {
		
		try {
			return new PersonajeServicio().extraerPersonajesTXT(rutaTXT);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			return null;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
}
