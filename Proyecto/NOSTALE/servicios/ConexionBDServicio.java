package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBDServicio {
   
    private static final String URL = "jdbc:mysql://localhost:3306/nostale";
    private static final String USUARIO = "admin";
    private static final String CONTRASENA = "admin";


    private static Connection conexion;


    public static void conectar() throws ClassNotFoundException, SQLException {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
      
    }

    
    public static void desconectar() throws SQLException {
        
            conexion.close();
            System.out.println("Conexión cerrada");
        
    }

    
    public static ResultSet ejecutarConsulta(String consulta) throws SQLException {
        
        Statement sentencia = conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery(consulta);
        return resultado;
        
    }
    
    public static void ejecutarSentencia(String sql) throws SQLException {
        
    	Statement sentencia = conexion.createStatement();
        sentencia.executeUpdate(sql);
        
    }
}