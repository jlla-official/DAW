package main;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import controlador.CentralControlador;
import modelo.ReproductorSonidos;
import servicios.ConexionBDServicio;
import vista.Login;

public class Main {

	public static void main(String[] args) {
		
		
		
		CentralControlador controladorCentral = new CentralControlador();
		controladorCentral.conectar();
		CentralControlador.iniciarVista();
		//INICIAR SOUNDTRACK JUEGO
		ReproductorSonidos.reproducirEnBucle("resources\\musica.wav");
		
	
		
	}

}
