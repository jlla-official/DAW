package servicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UtilidadesServicio {

	public void crearYEscribirEnArchivoTXT(String contenidoArchivoTXT, String nombreArchivo) throws IOException {
		 
		Path ruta = Paths.get("exports");
        File archivo = new File(ruta.toFile(), nombreArchivo+".txt"); 
        int contador = 1; 

        while (archivo.exists()) { 
            nombreArchivo = nombreArchivo+"("+contador+")"+".txt"; 
            archivo = new File(ruta.toFile(), nombreArchivo); 
            contador++; 
        }

        
            FileWriter escritor = new FileWriter(archivo);
            escritor.write(contenidoArchivoTXT);
            escritor.close();
            System.out.println("Archivo creado con éxito");
        
	}
	
	
}
