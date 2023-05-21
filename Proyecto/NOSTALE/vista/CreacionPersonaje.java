package vista;

import java.awt.EventQueue;

import controlador.PersonajeControlador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.CentralControlador;
import modelo.Cuenta;
import modelo.Personaje;
import modelo.ReproductorSonidos;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.JButton;

public class CreacionPersonaje extends JFrame {

	private JPanel contentPane;
	private JTextField inputNombrePersonaje;
	private int slotPersonaje; 
	
	public CreacionPersonaje(int slotPersonaje, Cuenta cuenta) {
		
		this.slotPersonaje = slotPersonaje;
		URL url = getClass().getResource("/resources/cursor.png");
		Image imagenCursor = Toolkit.getDefaultToolkit().getImage(url);
		Cursor cursorPersonalizado = Toolkit.getDefaultToolkit().createCustomCursor(imagenCursor, new Point(0, 0), "Cursor personalizado");
		setCursor(cursorPersonalizado);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonCancel = new JButton("");
		botonCancel.setContentAreaFilled(false);
		botonCancel.setBorderPainted(false);
		botonCancel.setOpaque(false);
		botonCancel.setBorder(null);
		botonCancel.setBounds(1345, 754, 114, 46);
		botonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new SeleccionPersonaje(cuenta);
            	dispose();
            }
        });
		
		botonCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(botonCancel);
		
		
		
		JRadioButton radioButtonPeloRosaMuerto = new JRadioButton("");
		radioButtonPeloRosaMuerto.setOpaque(false);
		radioButtonPeloRosaMuerto.setBorder(null);
		radioButtonPeloRosaMuerto.setBounds(1425, 402, 37, 37);
		radioButtonPeloRosaMuerto.setActionCommand("Rosa Muerto");
		
		radioButtonPeloRosaMuerto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonPeloRosaMuerto);
		
		JRadioButton radioButtonPeloPurpura = new JRadioButton("");
		radioButtonPeloPurpura.setOpaque(false);
		radioButtonPeloPurpura.setBorder(null);
		radioButtonPeloPurpura.setBounds(1373, 402, 37, 37);
		radioButtonPeloPurpura.setActionCommand("Púrpura");
		
		radioButtonPeloPurpura.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonPeloPurpura);
		
		JRadioButton radioButtonPeloAzul = new JRadioButton("");
		radioButtonPeloAzul.setOpaque(false);
		radioButtonPeloAzul.setBorder(null);
		radioButtonPeloAzul.setBounds(1321, 402, 37, 37);
		radioButtonPeloAzul.setActionCommand("Azul");
		
		radioButtonPeloAzul.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonPeloAzul);
		
		JRadioButton radioButtonPeloVerde = new JRadioButton("");
		radioButtonPeloVerde.setOpaque(false);
		radioButtonPeloVerde.setBorder(null);
		radioButtonPeloVerde.setBounds(1269, 402, 37, 37);
		radioButtonPeloVerde.setActionCommand("Verde");
		
		radioButtonPeloVerde.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonPeloVerde);
		
		JRadioButton radioButtonPeloAmarillo = new JRadioButton("");
		radioButtonPeloAmarillo.setOpaque(false);
		radioButtonPeloAmarillo.setBorder(null);
		radioButtonPeloAmarillo.setBounds(1217, 402, 37, 37);
		radioButtonPeloAmarillo.setActionCommand("Amarillo");
		
		radioButtonPeloAmarillo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonPeloAmarillo);
		
		JRadioButton radioButtonPeloGris = new JRadioButton("");
		radioButtonPeloGris.setOpaque(false);
		radioButtonPeloGris.setBorder(null);
		radioButtonPeloGris.setBounds(1425, 347, 37, 37);
		radioButtonPeloGris.setActionCommand("Gris");
		
		radioButtonPeloGris.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonPeloGris);
		
		JRadioButton radioButtonPeloNegro = new JRadioButton("");
		radioButtonPeloNegro.setOpaque(false);
		radioButtonPeloNegro.setBorder(null);
		radioButtonPeloNegro.setBounds(1373, 347, 37, 37);
		radioButtonPeloNegro.setActionCommand("Negro");
		
		radioButtonPeloNegro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonPeloNegro);
		
		JRadioButton radioButtonPeloMarron = new JRadioButton("");
		radioButtonPeloMarron.setOpaque(false);
		radioButtonPeloMarron.setBorder(null);
		radioButtonPeloMarron.setBounds(1321, 347, 37, 37);
		radioButtonPeloMarron.setActionCommand("Marrón");
		
		radioButtonPeloMarron.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonPeloMarron);
		
		JRadioButton radioButtonPeloRojo = new JRadioButton("");
		radioButtonPeloRojo.setOpaque(false);
		radioButtonPeloRojo.setBorder(null);
		radioButtonPeloRojo.setBounds(1269, 347, 37, 37);
		radioButtonPeloRojo.setActionCommand("Rojo");
		
		radioButtonPeloRojo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonPeloRojo);
		
		JRadioButton radioButtonPeloRosa = new JRadioButton("");
		radioButtonPeloRosa.setOpaque(false);
		radioButtonPeloRosa.setBorder(null);
		radioButtonPeloRosa.setBounds(1216, 347, 37, 37);
		radioButtonPeloRosa.setActionCommand("Rosa");

		radioButtonPeloRosa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonPeloRosa);
		
		ButtonGroup colorPelo = new ButtonGroup();
		colorPelo.add(radioButtonPeloAmarillo);
		colorPelo.add(radioButtonPeloAzul);
		colorPelo.add(radioButtonPeloGris);
		colorPelo.add(radioButtonPeloMarron);
		colorPelo.add(radioButtonPeloNegro);
		colorPelo.add(radioButtonPeloPurpura);
		colorPelo.add(radioButtonPeloPurpura);
		colorPelo.add(radioButtonPeloRojo);
		colorPelo.add(radioButtonPeloRosa);
		colorPelo.add(radioButtonPeloRosaMuerto);
		colorPelo.add(radioButtonPeloVerde);		
		
		inputNombrePersonaje = new JTextField();
		inputNombrePersonaje.setSelectionColor(new Color(173, 148, 48));
		inputNombrePersonaje.setFont(new Font("Rubik", Font.PLAIN, 14));
		inputNombrePersonaje.setForeground(new Color(255, 255, 255));
		inputNombrePersonaje.setBackground(new Color(0, 0, 0));
		inputNombrePersonaje.setBorder(null);
		inputNombrePersonaje.setBounds(1297, 709, 105, 20);
		
		inputNombrePersonaje.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(inputNombrePersonaje);
		inputNombrePersonaje.setColumns(10);
		
		JRadioButton radioButtonGeneroF = new JRadioButton("");
		radioButtonGeneroF.setOpaque(false);
		radioButtonGeneroF.setBorder(null);
		radioButtonGeneroF.setName("genero");
		radioButtonGeneroF.setBounds(1396, 106, 68, 67);
		radioButtonGeneroF.setActionCommand("Femenino");
		
		radioButtonGeneroF.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonGeneroF);
		
		JRadioButton radioButtonGeneroM = new JRadioButton("");
		radioButtonGeneroM.setOpaque(false);
		radioButtonGeneroM.setBorder(null);
		radioButtonGeneroM.setBounds(1322, 106, 66, 67); 
		radioButtonGeneroM.setActionCommand("Masculino");
		
		radioButtonGeneroM.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonGeneroM);
		
		ButtonGroup genero = new ButtonGroup();
		genero.add(radioButtonGeneroM);
		genero.add(radioButtonGeneroF);
		
		JRadioButton radioButtonTipoPeloB = new JRadioButton("");
		radioButtonTipoPeloB.setOpaque(false);
		radioButtonTipoPeloB.setName("genero");
		radioButtonTipoPeloB.setBorder(null);
		radioButtonTipoPeloB.setBounds(1396, 209, 68, 67);
		radioButtonTipoPeloB.setActionCommand("B");
		
		radioButtonTipoPeloB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonTipoPeloB);
		
		JRadioButton radioButtonTipoPeloA = new JRadioButton("");
		radioButtonTipoPeloA.setOpaque(false);
		radioButtonTipoPeloA.setBorder(null);
		radioButtonTipoPeloA.setBounds(1322, 209, 66, 67);
		radioButtonTipoPeloA.setActionCommand("A");
		
		radioButtonTipoPeloA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(radioButtonTipoPeloA);
		
		ButtonGroup tipoPelo = new ButtonGroup();
		tipoPelo.add(radioButtonTipoPeloB);
		tipoPelo.add(radioButtonTipoPeloA);
		
		JLabel fondoCreacionPersonaje = new JLabel("");
		fondoCreacionPersonaje.setName("genero");
		fondoCreacionPersonaje.setForeground(new Color(0, 0, 0));
		fondoCreacionPersonaje.setBackground(new Color(0, 0, 0));
		fondoCreacionPersonaje.setIcon(new ImageIcon(CreacionPersonaje.class.getResource("/resources/CreacionPersonaje.png")));
		fondoCreacionPersonaje.setBounds(0, 0, 1600, 900);
		contentPane.add(fondoCreacionPersonaje);
		
		JButton botonCreate = new JButton("");
		botonCreate.setOpaque(false);
		botonCreate.setBorder(null);
		botonCreate.setBounds(1217, 754, 114, 46);
		botonCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	ButtonModel generoSeleccionado = genero.getSelection();
            	String genero = generoSeleccionado.getActionCommand();
            	
            	ButtonModel peloSeleccionado = tipoPelo.getSelection();
            	String pelo = peloSeleccionado.getActionCommand();
            	
            	ButtonModel colorPeloSeleccionado = colorPelo.getSelection();
            	String colorPelo = colorPeloSeleccionado.getActionCommand();
            	
            	String nombrePersonaje = inputNombrePersonaje.getText();
            	
            	boolean existePersonaje = false;
            	Personaje personajeBD = new PersonajeControlador().recogerPersonajeBD(nombrePersonaje);
            	
            	if(personajeBD != null) {
            		existePersonaje = true;
            	}
            	
            	if(!nombrePersonaje.equals("") && 
            	   !existePersonaje && 
            	   nombrePersonaje.length() >= 3  &&
            	   nombrePersonaje.length() <= 13) {
	            	
            		Personaje personaje = new Personaje(cuenta.getId(), nombrePersonaje, genero, pelo, colorPelo, slotPersonaje);
	            	
	            	new PersonajeControlador().insertarPersonajeBD(personaje);
	            	
	            	new SeleccionPersonaje(cuenta);
	            	
	            	dispose();
	            	
            	} else if(nombrePersonaje.length() < 3) {
            	
            		new MensajeEmergente("Introduce un nombre de al menos 3 caracteres");
            	
            	} else if(nombrePersonaje.length() > 13) {
            		
            		new MensajeEmergente("El nombre debe tener menos de 13 caracteres");
            	
            	} else if(existePersonaje) {
            	
            		new MensajeEmergente("El nombre de personaje ya existe");
            	
            	}
       
            }
        });
		
		botonCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(botonCreate);
		
		setVisible(true);
	}
}
