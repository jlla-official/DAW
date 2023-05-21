package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.BevelBorder;

import controlador.CuentaControlador;
import modelo.ReproductorSonidos;
import servicios.ConexionBDServicio;

public class Registro extends JFrame {
	
	private JTextField inputUsuario;
	private JTextField inputEmail;
	private JTextField inputAgainEmail;
	private JPasswordField inputContrasena;
	private JPasswordField inputAgainContrasena;

	/**
	 * Create the frame.
	 */
	public Registro() {
		
		URL url = getClass().getResource("/resources/cursor.png");
		Image imagenCursor = Toolkit.getDefaultToolkit().getImage(url);
		Cursor cursorPersonalizado = Toolkit.getDefaultToolkit().createCustomCursor(imagenCursor, new Point(0, 0), "Cursor personalizado");
		setCursor(cursorPersonalizado);
				
		setResizable(false);
		setBounds(100, 100, 786, 475);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton cancelarRegistro = new JButton("Cancelar");
		cancelarRegistro.setFont(new Font("Dialog", Font.PLAIN, 16));
		cancelarRegistro.setBounds(382, 370, 198, 32);
		
		cancelarRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		cancelarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setFont(new Font("Reem Kufi", Font.PLAIN, 16));
		botonRegistrarse.setVisible(true);
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String usuario = inputUsuario.getText();
				String contrasena = new String(inputContrasena.getPassword());
				String repetirContrasena = new String(inputAgainContrasena.getPassword());
				String email = inputEmail.getText();
				String repetirEmail = inputAgainEmail.getText();
				
				if(
					!usuario.equals("") &&
					usuario.length() > 3 &&
					usuario.length() <= 15 &&
					contrasena.equals(repetirContrasena) &&
					contrasena.length() >= 4 &&
					contrasena.length() <= 15 &&
					!contrasena.equals("") && 
					email.equals(repetirEmail) && 
					!email.equals("") &&
					email.contains("@") &&
					email.contains(".")
				   )
				{
					new CuentaControlador().registrarse(usuario, contrasena, email);
					new MensajeEmergente("¡Te has registrado!");
					dispose();
					
				}	else if (usuario.equals("")) {
						
					new MensajeEmergente("Introduce un usuario");
					
				} 	else if (usuario.length() > 15 || usuario.length() < 3) {
					
				new MensajeEmergente("El usuario tiene que tener entre 3 y 15 caracteres");
				
				}	else if (contrasena.equals("")) {
							
					new MensajeEmergente("Introduce una contraseña");
						
				} else if(contrasena.length() < 4 || contrasena.length() > 15) {
					
					new MensajeEmergente("La contraseña tiene que tener entre 4 y 15 caracteres");
				
				} else if (repetirContrasena.equals("")) {
						
						new MensajeEmergente("Introduce de nuevo la contraseña");
					
				} else if(!contrasena.equals(repetirContrasena)) {
					
					new MensajeEmergente("Las contraseñas no coinciden");
				
				} else if (email.equals("")) {
					
					new MensajeEmergente("Introduce un email");
				
				} else if (!email.contains("@") || !email.contains(".")) {
					
					new MensajeEmergente("Introduce un email válido");
				
				} else if (repetirEmail.equals("")) {
						
						new MensajeEmergente("Introduce de nuevo el email");	
					
				} else if(!email.equals(repetirEmail)) {
				
					new MensajeEmergente("Los correos electrónicos no coinciden");
				
				}
			}
		});
		
		botonRegistrarse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		botonRegistrarse.setBounds(153, 370, 198, 32);
		getContentPane().add(botonRegistrarse);
		
		
		getContentPane().add(cancelarRegistro);
		
		inputUsuario = new JTextField();
		inputUsuario.setBounds(397, 82, 196, 32);
		inputUsuario.setColumns(10);
		inputUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		getContentPane().add(inputUsuario);
		
		
		inputContrasena = new JPasswordField();
		inputContrasena.setBounds(397, 137, 196, 32);
		inputContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		getContentPane().add(inputContrasena);
		
		inputEmail = new JTextField();
		inputEmail.setColumns(10);
		inputEmail.setBounds(397, 237, 196, 32);
		inputEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		getContentPane().add(inputEmail);
		
		
		
		JLabel labelContrasena = new JLabel("Contraseña");
		labelContrasena.setFont(new Font("Reem Kufi", Font.PLAIN, 16));
		labelContrasena.setBounds(268, 137, 89, 25);
		getContentPane().add(labelContrasena);
		
		JLabel labelEmail = new JLabel("E-mail");
		labelEmail.setFont(new Font("Reem Kufi", Font.PLAIN, 16));
		labelEmail.setBounds(311, 239, 51, 25);
		getContentPane().add(labelEmail);
		
		inputAgainContrasena = new JPasswordField();
		inputAgainContrasena.setBounds(397, 186, 196, 32);
		inputAgainContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		getContentPane().add(inputAgainContrasena);
		
		JLabel labelAgainEmail = new JLabel("Vuelve a escribir tu E-mail");
		labelAgainEmail.setFont(new Font("Reem Kufi", Font.PLAIN, 16));
		labelAgainEmail.setBounds(180, 294, 190, 25);
		getContentPane().add(labelAgainEmail);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Reem Kufi", Font.PLAIN, 16));
		labelUsuario.setBounds(294, 84, 63, 25);
		getContentPane().add(labelUsuario);
		
		JLabel labelAgainContrasena = new JLabel("Vuelve a escribir tu contraseña");
		labelAgainContrasena.setFont(new Font("Reem Kufi", Font.PLAIN, 16));
		labelAgainContrasena.setBounds(141, 186, 221, 25);
		getContentPane().add(labelAgainContrasena);
		
		inputAgainEmail = new JTextField();
		inputAgainEmail.setColumns(10);
		inputAgainEmail.setBounds(397, 292, 196, 32);
		inputAgainEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		getContentPane().add(inputAgainEmail);
		
		JLabel fondoCampos = new JLabel("");
		fondoCampos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fondoCampos.setOpaque(true);
		fondoCampos.setBackground(new Color(192, 192, 192));
		fondoCampos.setBounds(110, 66, 545, 282);
		getContentPane().add(fondoCampos);
		
		JLabel fondoRegistro = new JLabel("");
		fondoRegistro.setIcon(new ImageIcon(Registro.class.getResource("/resources/fondoRegistro.jpg")));
		fondoRegistro.setBounds(0, 0, 785, 474);
		getContentPane().add(fondoRegistro);

	}
}
