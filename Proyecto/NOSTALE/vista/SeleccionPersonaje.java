package vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.PersonajeControlador;
import modelo.Cuenta;
import modelo.Personaje;
import modelo.ReproductorSonidos;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class SeleccionPersonaje extends JFrame {

	private JPanel contentPane;
	private Personaje personajeSlot1 = null;
	private Personaje personajeSlot2 = null;
	private Personaje personajeSlot3 = null;
	private Personaje personajeSlot4 = null;
	private int idPersonajeSeleccionado;
	private PersonajeControlador personajeControlador = new PersonajeControlador();
	
	public SeleccionPersonaje(Cuenta cuenta) {
				
		personajeSlot1 = new PersonajeControlador().recogerPersonajeBD(cuenta.getId(), 1);
		personajeSlot2 = new PersonajeControlador().recogerPersonajeBD(cuenta.getId(), 2);
		personajeSlot3 = new PersonajeControlador().recogerPersonajeBD(cuenta.getId(), 3);
		personajeSlot4 = new PersonajeControlador().recogerPersonajeBD(cuenta.getId(), 4);	
		
		URL url = getClass().getResource("/resources/cursor.png");
		Image imagenCursor = Toolkit.getDefaultToolkit().getImage(url);
		Cursor cursorPersonalizado = Toolkit.getDefaultToolkit().createCustomCursor(imagenCursor, new Point(0, 0), "Cursor personalizado");
		setCursor(cursorPersonalizado);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1582, 861);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton informacionCuenta = new JButton("Información cuenta");
		
		informacionCuenta.setOpaque(false);
		informacionCuenta.setForeground(Color.WHITE);
		informacionCuenta.setFont(new Font("Dialog", Font.BOLD, 12));
		informacionCuenta.setBorderPainted(false);
		informacionCuenta.setBorder(null);
		informacionCuenta.setBackground(Color.WHITE);
		informacionCuenta.setBounds(918, 797, 132, 31);
		
		informacionCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InformacionCuenta(cuenta);
			}
		});
		
		informacionCuenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		JButton botonPanelSTAFF = new JButton("PANEL ADM");
		botonPanelSTAFF.setEnabled(false);
		botonPanelSTAFF.setVisible(false);
		
		botonPanelSTAFF.setBorderPainted(false);
		botonPanelSTAFF.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		botonPanelSTAFF.setForeground(new Color(255, 255, 255));
		botonPanelSTAFF.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		botonPanelSTAFF.setActionCommand("\r\n");
		botonPanelSTAFF.setBackground(new Color(0, 255, 0));
		botonPanelSTAFF.setBounds(1099, 794, 144, 38);
		
		botonPanelSTAFF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PanelSTAFF(cuenta);
			}
		});
		
		if(cuenta.getRol() == 1) {
			botonPanelSTAFF.setVisible(true);
			botonPanelSTAFF.setEnabled(true);
		}
		
		botonPanelSTAFF.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(botonPanelSTAFF);
		
		
		
		contentPane.add(informacionCuenta);
		
		JLabel informacionPersonajeSeleccionado = new JLabel("");
		informacionPersonajeSeleccionado.setOpaque(true);
		informacionPersonajeSeleccionado.setBackground(Color.BLACK);
		informacionPersonajeSeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		informacionPersonajeSeleccionado.setHorizontalAlignment(SwingConstants.LEFT);
		informacionPersonajeSeleccionado.setForeground(Color.WHITE);
		informacionPersonajeSeleccionado.setBounds(466, 433, 760, 67);
		informacionPersonajeSeleccionado.setVisible(false);
		
		contentPane.add(informacionPersonajeSeleccionado);
		
		
		
		JButton botonCerrarSesion = new JButton("CERRAR SESIÓN");
		botonCerrarSesion.setOpaque(false);
		botonCerrarSesion.setForeground(Color.WHITE);
		botonCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 12));
		botonCerrarSesion.setBorderPainted(false);
		botonCerrarSesion.setBorder(null);
		botonCerrarSesion.setBackground(Color.WHITE);
		botonCerrarSesion.setBounds(548, 797, 130, 31);
		contentPane.add(botonCerrarSesion);
		botonCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		
		botonCerrarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		JButton botonBorrarPersonaje = new JButton("BORRAR PERSONAJE");
		
		botonBorrarPersonaje.setOpaque(false);
		botonBorrarPersonaje.setForeground(Color.WHITE);
		botonBorrarPersonaje.setFont(new Font("Dialog", Font.BOLD, 12));
		botonBorrarPersonaje.setBorderPainted(false);
		botonBorrarPersonaje.setBorder(null);
		botonBorrarPersonaje.setBackground(Color.WHITE);
		botonBorrarPersonaje.setBounds(727, 794, 144, 38);
		
		botonBorrarPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					personajeControlador.borrarPersonaje(idPersonajeSeleccionado);
					new SeleccionPersonaje(cuenta);
					dispose();
				}
				catch(Exception borrarPersonajeError) {
				}
			}
		});
		
		botonBorrarPersonaje.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(botonBorrarPersonaje);
		
		JButton nombrePersonajeSlot1 = new JButton("");
		
		nombrePersonajeSlot1.setFocusPainted(false);
		nombrePersonajeSlot1.setContentAreaFilled(false);
		nombrePersonajeSlot1.setBorderPainted(false);
		nombrePersonajeSlot1.setOpaque(false);
		nombrePersonajeSlot1.setHorizontalAlignment(SwingConstants.LEFT);
		nombrePersonajeSlot1.setBorder(null);
		nombrePersonajeSlot1.setFont(new Font("Power Red and Green", Font.BOLD, 18));
		nombrePersonajeSlot1.setForeground(new Color(255, 255, 255));
		nombrePersonajeSlot1.setBounds(447, 22, 122, 34);
		
		nombrePersonajeSlot1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(personajeSlot1 != null) {
					informacionPersonajeSeleccionado.setText(personajeSlot1.toString());
					informacionPersonajeSeleccionado.setVisible(true);
					idPersonajeSeleccionado = personajeSlot1.getId();
				}
			}
		});
		
		nombrePersonajeSlot1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(nombrePersonajeSlot1);
		
		try {
			nombrePersonajeSlot1.setText(personajeSlot1.getNombre());
		}
		catch(Exception e) {
		}
		
		JButton botonCrearPersonaje1 = new JButton("    Crear personaje");
		botonCrearPersonaje1.setOpaque(false);
		botonCrearPersonaje1.setForeground(Color.WHITE);
		botonCrearPersonaje1.setFont(new Font("Power Red and Green", Font.BOLD, 15));
		botonCrearPersonaje1.setBorderPainted(false);
		botonCrearPersonaje1.setBorder(null);
		botonCrearPersonaje1.setBackground(Color.WHITE);
		botonCrearPersonaje1.setBounds(380, 15, 190, 50);
		contentPane.add(botonCrearPersonaje1);
		botonCrearPersonaje1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreacionPersonaje(1, cuenta);
				dispose();
				
			}
		});
		
		botonCrearPersonaje1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		if( personajeSlot1 != null ) {
			
			botonCrearPersonaje1.setVisible(false);
			botonCrearPersonaje1.setEnabled(false);
			
		} else {
			nombrePersonajeSlot1.setVisible(false);
			nombrePersonajeSlot1.setEnabled(false);
		}
		
		JButton nombrePersonajeSlot2 = new JButton("");
		
		nombrePersonajeSlot2.setFocusPainted(false);
		nombrePersonajeSlot2.setContentAreaFilled(false);
		nombrePersonajeSlot2.setBorderPainted(false);
		nombrePersonajeSlot2.setHorizontalAlignment(SwingConstants.LEFT);
		nombrePersonajeSlot2.setOpaque(false);
		nombrePersonajeSlot2.setBorder(null);
		nombrePersonajeSlot2.setForeground(Color.WHITE);
		nombrePersonajeSlot2.setFont(new Font("Power Red and Green", Font.BOLD, 18));
		nombrePersonajeSlot2.setBounds(648, 22, 134, 34);
		
		nombrePersonajeSlot2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(personajeSlot2 != null) {
					informacionPersonajeSeleccionado.setText(personajeSlot2.toString());
					informacionPersonajeSeleccionado.setVisible(true);
					idPersonajeSeleccionado = personajeSlot2.getId();
				}
				
			}
		});
		
		nombrePersonajeSlot2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(nombrePersonajeSlot2);
		
		JButton botonCrearPersonaje2 = new JButton("    Crear personaje");
		botonCrearPersonaje2.setFocusPainted(false);
		botonCrearPersonaje2.setContentAreaFilled(false);
		botonCrearPersonaje2.setOpaque(false);
		botonCrearPersonaje2.setForeground(Color.WHITE);
		botonCrearPersonaje2.setFont(new Font("Power Red and Green", Font.BOLD, 15));
		botonCrearPersonaje2.setBorderPainted(false);
		botonCrearPersonaje2.setBorder(null);
		botonCrearPersonaje2.setBackground(Color.WHITE);
		botonCrearPersonaje2.setBounds(601, 15, 188, 50);
		
		botonCrearPersonaje2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreacionPersonaje personajeSlot2 = new CreacionPersonaje(2, cuenta);
				personajeSlot2.setVisible(true);
				dispose();
			}
		});
		
		botonCrearPersonaje2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(botonCrearPersonaje2);
		
		if(personajeSlot2 != null) {
			nombrePersonajeSlot2.setText(personajeSlot2.getNombre());
			botonCrearPersonaje2.setVisible(false);
			botonCrearPersonaje2.setEnabled(false);
			
		} else {
			nombrePersonajeSlot2.setVisible(false);
			nombrePersonajeSlot2.setEnabled(false);
		}
		
		
		JButton nombrePersonajeSlot3 = new JButton("Hola");
		
		nombrePersonajeSlot3.setBorderPainted(false);
		nombrePersonajeSlot3.setContentAreaFilled(false);
		nombrePersonajeSlot3.setFocusPainted(false);
		nombrePersonajeSlot3.setHorizontalAlignment(SwingConstants.LEFT);
		nombrePersonajeSlot3.setOpaque(false);
		nombrePersonajeSlot3.setBorder(null);
		nombrePersonajeSlot3.setForeground(Color.WHITE);
		nombrePersonajeSlot3.setFont(new Font("Power Red and Green", Font.BOLD, 18));
		nombrePersonajeSlot3.setBounds(870, 21, 134, 34);
		
		nombrePersonajeSlot3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(personajeSlot3 != null){
					informacionPersonajeSeleccionado.setText(personajeSlot3.toString());
					informacionPersonajeSeleccionado.setVisible(true);
					idPersonajeSeleccionado = personajeSlot3.getId();
				}
			}
		});
		
		nombrePersonajeSlot3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
			
		
		contentPane.add(nombrePersonajeSlot3);
		
		JButton botonCrearPersonaje3 = new JButton("    Crear personaje");
		botonCrearPersonaje3.setOpaque(false);
		botonCrearPersonaje3.setForeground(Color.WHITE);
		botonCrearPersonaje3.setFont(new Font("Power Red and Green", Font.BOLD, 15));
		botonCrearPersonaje3.setBorderPainted(false);
		botonCrearPersonaje3.setBorder(null);
		botonCrearPersonaje3.setBackground(Color.WHITE);
		botonCrearPersonaje3.setBounds(819, 16, 188, 49);
		
		botonCrearPersonaje3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreacionPersonaje(3, cuenta);
				dispose();
			}
		});
		
		botonCrearPersonaje3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(botonCrearPersonaje3);
		
		if(personajeSlot3 != null) {
			nombrePersonajeSlot3.setText(personajeSlot3.getNombre());
			botonCrearPersonaje3.setVisible(false);
			botonCrearPersonaje3.setEnabled(false);
			
		} else {
			nombrePersonajeSlot3.setVisible(false);
			nombrePersonajeSlot3.setEnabled(false);
		}
		
		
		JButton nombrePersonajeSlot4 = new JButton("");
		
		nombrePersonajeSlot4.setContentAreaFilled(false);
		nombrePersonajeSlot4.setBorderPainted(false);
		nombrePersonajeSlot4.setFocusPainted(false);
		nombrePersonajeSlot4.setHorizontalAlignment(SwingConstants.LEFT);
		nombrePersonajeSlot4.setOpaque(false);
		nombrePersonajeSlot4.setBorder(null);
		nombrePersonajeSlot4.setForeground(Color.WHITE);
		nombrePersonajeSlot4.setFont(new Font("Power Red and Green", Font.BOLD, 18));
		nombrePersonajeSlot4.setBounds(1086, 24, 134, 34);
		
		nombrePersonajeSlot4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(personajeSlot4 != null) {
					informacionPersonajeSeleccionado.setText(personajeSlot4.toString());
					informacionPersonajeSeleccionado.setVisible(true);
					idPersonajeSeleccionado = personajeSlot4.getId();
				}
			}
		});
		
		nombrePersonajeSlot4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		
		contentPane.add(nombrePersonajeSlot4);
		
		JButton botonCrearPersonaje4 = new JButton("    Crear personaje");
		
		botonCrearPersonaje4.setForeground(new Color(255, 255, 255));
		botonCrearPersonaje4.setOpaque(false);
		botonCrearPersonaje4.setBorderPainted(false);
		botonCrearPersonaje4.setBackground(new Color(255, 255, 255));
		botonCrearPersonaje4.setBorder(null);
		botonCrearPersonaje4.setFont(new Font("Power Red and Green", Font.BOLD, 15));
		botonCrearPersonaje4.setBounds(1036, 16, 190, 49);
		
		botonCrearPersonaje4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreacionPersonaje(4, cuenta);
				dispose();
			}
		});
		
		botonCrearPersonaje4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
	
		contentPane.add(botonCrearPersonaje4);
		
		if(personajeSlot4 != null) {
			nombrePersonajeSlot4.setText(personajeSlot4.getNombre());
			botonCrearPersonaje4.setVisible(false);
			botonCrearPersonaje4.setEnabled(false);
			
		} else {
			nombrePersonajeSlot4.setVisible(false);
			nombrePersonajeSlot4.setEnabled(false);
		}
		
		JLabel fondoCreacionPersonaje = new JLabel("");
		fondoCreacionPersonaje.setIcon(new ImageIcon(SeleccionPersonaje.class.getResource("/resources/SeleccionPersonaje.jpg")));
		fondoCreacionPersonaje.setBounds(0, 0, 1594, 861);
		
		contentPane.add(fondoCreacionPersonaje);
		
		
		
		setVisible(true);
		
	}
}
