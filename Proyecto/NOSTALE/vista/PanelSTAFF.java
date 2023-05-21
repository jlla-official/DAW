package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.Iterator;

import controlador.CentralControlador;
import controlador.PersonajeControlador;
import modelo.Cuenta;
import modelo.Personaje;
import modelo.ReproductorSonidos;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;

public class PanelSTAFF extends JFrame {

	private JPanel contentPane;
	private PersonajeControlador personajeControlador = new PersonajeControlador();
	private CentralControlador controlador = new CentralControlador();
	

	public PanelSTAFF(Cuenta cuenta) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 476, 300);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonCerrar = new JButton("Salir");
		botonCerrar.setBackground(new Color(0, 128, 255));
		botonCerrar.setForeground(new Color(255, 255, 255));
		botonCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		botonCerrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		JButton botonExportarPersonajes = new JButton("Exportar personajes de todas las cuentas a txt");
		botonExportarPersonajes.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonExportarPersonajes.setForeground(new Color(255, 255, 255));
		botonExportarPersonajes.setBackground(new Color(0, 128, 255));
		
		botonExportarPersonajes.setBorder(null);
		botonExportarPersonajes.setBounds(90, 89, 292, 23);
		botonExportarPersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String personajes = personajeControlador.listarPersonajesBD();
				
				String mensajeError = new CentralControlador().crearYEscribirEnArchivoTXT(personajes , "personajes");
				
				if(mensajeError == null) {
					
					new MensajeEmergente("¡Personajes exportados con éxito!");
					
				} else {
					
					new PanelDeInformacion(mensajeError);
					new MensajeEmergente("Error en la exportación");
					
				}
			
			}
		});
		
		botonExportarPersonajes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		JLabel simboloAyuda2 = new JLabel("");
		simboloAyuda2.setIcon(new ImageIcon(PanelSTAFF.class.getResource("/resources/ayuda.png")));
		simboloAyuda2.setBounds(402, 122, 32, 41);
		
		simboloAyuda2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
                new PanelDeInformacion(
                		 "El archivo de texto que contiene los personajes que se van a importar a\n"
                		+"la base de datos, está en la carpeta de Nostale\\imports.\n\n"
                		
                		+"Los datos de cada personaje deben estar puestos de la siguiente\n" 
                		+"manera en cada linea:\n\n" 
                		
                		+"IdUsuario, Nombre, Genero, ColorPeinado, TipoPeinado, slot"
                		);
            }
        });
		
		contentPane.add(simboloAyuda2);
		
		contentPane.add(botonExportarPersonajes);
		
		JButton botonImportarPersonajes = new JButton("Importar personajes a base de datos desde txt");
		botonImportarPersonajes.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonImportarPersonajes.setForeground(new Color(255, 255, 255));
		botonImportarPersonajes.setBackground(new Color(0, 128, 255));
		botonImportarPersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Personaje> personajes = personajeControlador.extraerPersonajesTXT("imports\\personajesImportar");
				
				try {
					for (int personaje = 0; personaje < personajes.size(); personaje++) {
						
						personajeControlador.insertarPersonajeBD(personajes.get(personaje));
					}
				}
				catch(Exception error) {
					error.getMessage();
					new MensajeEmergente("Error al insertar los datos en la BD");
				}
			}
		});
		
		botonImportarPersonajes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		botonImportarPersonajes.setBorder(null);
		botonImportarPersonajes.setBounds(90, 134, 293, 23);
		contentPane.add(botonImportarPersonajes);
		botonCerrar.setBorder(null);
		botonCerrar.setBounds(192, 252, 89, 23);
		contentPane.add(botonCerrar);
		
		JLabel rolBD = new JLabel("");
		rolBD.setFont(new Font("Dialog", Font.BOLD, 20));
		rolBD.setBounds(244, 31, 202, 26);
		
		if(cuenta.getRol() == 1) {
			rolBD.setText("Developer");
		}
		
		contentPane.add(rolBD);
		
		JLabel usuarioBD = new JLabel("");
		usuarioBD.setHorizontalAlignment(SwingConstants.RIGHT);
		usuarioBD.setHorizontalTextPosition(SwingConstants.RIGHT);
		usuarioBD.setFont(new Font("Dialog", Font.BOLD, 20));
		usuarioBD.setBounds(30, 31, 196, 26);
		usuarioBD.setText(cuenta.getUsuario());
		
		contentPane.add(usuarioBD);
		
		JLabel simboloAyuda1 = new JLabel("");
		simboloAyuda1.setIcon(new ImageIcon(PanelSTAFF.class.getResource("/resources/ayuda.png")));
		simboloAyuda1.setBounds(401, 79, 32, 41);
		
		simboloAyuda1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
                new MensajeEmergente(
                		"Los personajes van a la carpeta exports de Nostale"
                		);
            }
        });
		
		contentPane.add(simboloAyuda1);
		
		
		
		setVisible(true);
	}
}
