package servicios;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Personaje;

public class PersonajeServicio {
	
	public void insertarPersonajeBD(Personaje personaje) throws SQLException {
		
		String sql = "INSERT INTO personaje (IdUsuario, Nombre, Genero, ColorPeinado, TipoPeinado, slot) "
				+ "VALUES"
				+ "(" 
				+ personaje.getIdUsuario() + 
				", \"" + personaje.getNombre() + 
				"\", \"" + personaje.getGenero() +
				"\", \"" + personaje.getColorPeinado() +
				"\", \"" + personaje.getTipoPeinado() + 
				"\", " + personaje.getSlot() + 
				")";
		
		ConexionBDServicio.ejecutarSentencia(sql);
		
	
	}
	
	public Personaje recogerPersonajeBD(int idUsuario, int slot) throws SQLException {
		
		Personaje personajeBD = null;
		
		ResultSet resultado = ConexionBDServicio.ejecutarConsulta("SELECT * FROM personaje WHERE idUsuario=" + idUsuario + " AND " + "Slot=" + slot +";");
		
		if(resultado.next()) {
			int idBD = resultado.getInt("Id");
			int idUsuarioBD = resultado.getInt("IdUsuario");
			String generoBD = resultado.getString("Genero");
			String tipoPeinadoBD = resultado.getString("TipoPeinado");
			String colorPeinadoBD = resultado.getString("ColorPeinado");
			String nombreBD = resultado.getString("Nombre");
			int slotBD = resultado.getInt("Slot");
					
			personajeBD = new Personaje(idBD, idUsuarioBD, nombreBD, generoBD, tipoPeinadoBD, colorPeinadoBD, slotBD);
		}
		
		return personajeBD;
			
	}
	
	public Personaje recogerPersonajeBD(String nombrePersonaje) throws SQLException {
		
		Personaje personajeBD;
		ResultSet resultado = ConexionBDServicio.ejecutarConsulta("SELECT * FROM personaje WHERE Nombre=\"" + nombrePersonaje + "\";");
		
			
			if(resultado.next()) {
				
				int idBD = resultado.getInt("Id");
				int idUsuarioBD = resultado.getInt("IdUsuario");
				String generoBD = resultado.getString("Genero");
				String tipoPeinadoBD = resultado.getString("TipoPeinado");
				String colorPeinadoBD = resultado.getString("ColorPeinado");
				String nombreBD = resultado.getString("Nombre");
				int slotBD = resultado.getInt("Slot");
				
				personajeBD = new Personaje(idBD, idUsuarioBD, nombreBD, generoBD, tipoPeinadoBD, colorPeinadoBD, slotBD);
				
				return personajeBD;
			
			}
			
			return personajeBD = null;
	}
	
	public void borrarPersonaje(int idPersonaje) throws SQLException {
		ConexionBDServicio.ejecutarSentencia("DELETE FROM personaje WHERE Id=" + idPersonaje + ";");
	}
	
	public String listarPersonajesBD() throws SQLException{
	
		String personajes = "";
		
		String sql = "SELECT * FROM personaje;";
		ResultSet resultado = ConexionBDServicio.ejecutarConsulta(sql);
		
			while(resultado.next()) {
				
				int idBD = resultado.getInt("Id");
				int idUsuarioBD = resultado.getInt("IdUsuario");
				String generoBD = resultado.getString("Genero");
				String tipoPeinadoBD = resultado.getString("TipoPeinado");
				String colorPeinadoBD = resultado.getString("ColorPeinado");
				String nombreBD = resultado.getString("Nombre");
				int slotBD = resultado.getInt("Slot");
				
				Personaje personaje = new Personaje(idBD, idUsuarioBD, nombreBD, generoBD, tipoPeinadoBD, colorPeinadoBD, slotBD);
				
				personajes += personaje.recogerDatos() + "\n";
				
			}
		
		return personajes;
	}
	
	public ArrayList<Personaje> extraerPersonajesTXT(String rutaTXT) throws NumberFormatException, IOException {

		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		String nombreArchivo = rutaTXT; //

		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea;

		while ((linea = br.readLine()) != null) {

			String[] atributosPersonaje = linea.split(", ");

			personajes.add(
					new Personaje(Integer.parseInt(atributosPersonaje[0]), atributosPersonaje[1], atributosPersonaje[2],
							atributosPersonaje[3], atributosPersonaje[4], Integer.parseInt(atributosPersonaje[5])));
		}

		return personajes;

	}
}
