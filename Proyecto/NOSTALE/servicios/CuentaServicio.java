package servicios;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cuenta;

public class CuentaServicio {
	
	public void registrarse(String usuario, String contrasena, String email) throws SQLException {
		
		String sql = "INSERT INTO cuenta (usuario, contrasena, email, rol) VALUES('" + usuario + "', '" + contrasena + "', '" + email + "', 2)";
		ConexionBDServicio.ejecutarSentencia(sql);
		
	}
	
	
	public Cuenta getCuenta(String usuario, String contrasena) throws Exception  {
		
		String sql = "SELECT * FROM cuenta WHERE usuario=\"" + usuario + "\" AND " + "contrasena=\"" + contrasena + "\"";
    	ResultSet resultadoConsulta = ConexionBDServicio.ejecutarConsulta(sql);
    
			
				if(resultadoConsulta.next()) {
					int idUsuarioBD = resultadoConsulta.getInt("id");
					String usuarioBD = resultadoConsulta.getString("usuario");
					String contrasenaBD = resultadoConsulta.getString("contrasena");
					String emailBD = resultadoConsulta.getString("email");
					int rolBD = resultadoConsulta.getInt("rol");
					
					return new Cuenta(idUsuarioBD, usuarioBD, contrasenaBD, emailBD, rolBD);
					
				}
				
				return null; 
				
	}
	
	public void actualizarEmail(String nuevoEmail, int idUsuario) throws SQLException {
		
		String sql = "UPDATE CUENTA SET Email=\""+nuevoEmail+"\" " + "WHERE Id="+idUsuario+";";
		ConexionBDServicio.ejecutarSentencia(sql);
		
	
	}
	
	public void actualizarContrasena(String nuevaContrasena, int idUsuario) throws SQLException {
		
		String sql = "UPDATE CUENTA SET Contrasena=\""+nuevaContrasena+"\" " + "WHERE Id="+idUsuario+";" ;
		ConexionBDServicio.ejecutarSentencia(sql);
	
	}
	
	
}
