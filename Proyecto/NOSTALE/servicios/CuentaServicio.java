package servicios;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cuenta;
import modelo.Personaje;

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
					boolean bannedBD = resultadoConsulta.getBoolean("Banned");
					
					return new Cuenta(idUsuarioBD, usuarioBD, contrasenaBD, emailBD, rolBD, bannedBD);
					
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
	
	public void banearCuenta(String usuario) throws SQLException {
		String sql = "UPDATE CUENTA SET Banned="+1+ " WHERE Usuario=\""+usuario+"\";";
		ConexionBDServicio.ejecutarSentencia(sql);
	}
	
	public void desbanearCuenta(String usuario) throws SQLException {
		String sql = "UPDATE CUENTA SET Banned="+0+ " WHERE Usuario=\""+usuario+"\";";
		ConexionBDServicio.ejecutarSentencia(sql);
	}
	
	public String listarCuentasBD() throws SQLException{
		
		String cuentas = "";
		
		String sql = "SELECT * FROM cuenta;";
		ResultSet resultado = ConexionBDServicio.ejecutarConsulta(sql);
		
			while(resultado.next()) {
				
				int idBD = resultado.getInt("Id");
				String usuarioBD = resultado.getString("Usuario");
				String contrasenaBD = resultado.getString("Contrasena");
				String emailBD = resultado.getString("Email");
				int rolBD = resultado.getInt("Rol");
				boolean bannedBD = resultado.getBoolean("Banned");
				
				Cuenta cuenta = new Cuenta(idBD, usuarioBD, contrasenaBD, emailBD, rolBD, bannedBD);
				
				cuentas += cuenta.recogerDatos() + "\n";
				
			}
		
		return cuentas;
	}
	
public String listarCuentasBaneadasBD() throws SQLException{
		
		String cuentas = "";
		
		String sql = "SELECT * FROM cuenta WHERE Banned=1;";
		ResultSet resultado = ConexionBDServicio.ejecutarConsulta(sql);
		
			while(resultado.next()) {
				
				int idBD = resultado.getInt("Id");
				String usuarioBD = resultado.getString("Usuario");
				String contrasenaBD = resultado.getString("Contrasena");
				String emailBD = resultado.getString("Email");
				int rolBD = resultado.getInt("Rol");
				boolean bannedBD = resultado.getBoolean("Banned");
				
				Cuenta cuenta = new Cuenta(idBD, usuarioBD, contrasenaBD, emailBD, rolBD, bannedBD);
				
				cuentas += cuenta.recogerDatos() + "\n";
				
			}
		
		return cuentas;
	}
	
}
