package controlador;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Cuenta;
import modelo.Personaje;
import servicios.ConexionBDServicio;
import servicios.UtilidadesServicio;
import vista.Login;
import vista.MensajeEmergente;
import vista.PanelDeInformacion;
import vista.SeleccionPersonaje;

public class CentralControlador {
	
	
	public static void iniciarVista() {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					Login login = new Login();
				} catch (Exception e) {
					new PanelDeInformacion(e.getMessage());
					System.out.println(e.getMessage());
				}
				
			}
		});
	}
	
	public String crearYEscribirEnArchivoTXT(String contenidoArchivoTXT, String nombreArchivo) {
		 
		try {
			new UtilidadesServicio().crearYEscribirEnArchivoTXT(contenidoArchivoTXT, nombreArchivo);
			return null;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return e.getMessage();	
		}
		
	}
	
	public String conectar() {
		try {
			new ConexionBDServicio();
			ConexionBDServicio.conectar();
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}
	
}


