package modelo;

import javax.sound.sampled.*;
import java.io.File;

public class ReproductorSonidos {

	public static void reproducirEnBucle(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void reproducirUnaVez(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}