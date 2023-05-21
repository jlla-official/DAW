package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Component;

import controlador.CentralControlador;
import controlador.CuentaControlador;
import modelo.Cuenta;
import modelo.ReproductorSonidos;


public class Login extends JFrame {

	private JLayeredPane contentPane;
	private JTextField inputUsuario;
	private JPasswordField inputContrasena;
	private Cuenta cuenta;
	

	/**
	 * Create the frame.
	 */
	
	public Login() {
	
		
		//CURSOR DEL RATÓN PERSONALIZADO
		URL url = getClass().getResource("/resources/cursor.png");
		Image imagenCursor = Toolkit.getDefaultToolkit().getImage(url);
		Cursor cursorPersonalizado = Toolkit.getDefaultToolkit().createCustomCursor(imagenCursor, new Point(0, 0), "Cursor personalizado");
		setCursor(cursorPersonalizado);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1920, 1041);	
		setLocationRelativeTo(null);
		
		contentPane = new JLayeredPane();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		inputContrasena = new JPasswordField();
		inputContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuarioLogin = inputUsuario.getText();
            	String contrasenaLogin = new String(inputContrasena.getPassword());
            	
            	Cuenta cuenta = new CuentaControlador().login(usuarioLogin, contrasenaLogin);
            	
            	if(cuenta != null && !cuenta.isBanned()) {
            		new SeleccionPersonaje(cuenta);
            		dispose();
            	} 
            	else if(cuenta.isBanned()) {
            		new MensajeEmergente("Su cuenta ha sido suspendida");
            	} else {
            		new MensajeEmergente("Usuario o contraseña incorrecta");
            	}
			}
		});
		
		inputContrasena.setEchoChar('*');
		inputContrasena.setCaretColor(new Color(255, 255, 255));
		inputContrasena.setFont(new Font("Reem Kufi", Font.PLAIN, 16));
		inputContrasena.setForeground(new Color(255, 255, 255));
		inputContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		inputContrasena.setBorder(null);
		inputContrasena.setBackground(new Color(20, 20, 20));
		inputContrasena.setBounds(641, 504, 190, 26);
		
		inputContrasena.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		          
		        }
		    }
		});
		
		inputContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(inputContrasena);
		
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Registro registro = new Registro();
							registro.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		botonRegistrarse.setBorder(null);
		botonRegistrarse.setFont(new Font("Reem Kufi", Font.BOLD, 13));
		botonRegistrarse.setForeground(new Color(255, 255, 255));
		botonRegistrarse.setBackground(new Color(85, 85, 255));
		botonRegistrarse.setBounds(934, 544, 97, 23);
		
		contentPane.add(botonRegistrarse);
		
		
		JLabel registroText1 = new JLabel("¿Aún no tienes cuenta?\r\n");
		
		registroText1.setHorizontalAlignment(SwingConstants.CENTER);
		registroText1.setForeground(Color.WHITE);
		registroText1.setFont(new Font("Reem Kufi", Font.PLAIN, 17));
		registroText1.setBounds(891, 469, 189, 36);
		
		botonRegistrarse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(registroText1);
		
		
		JLabel fondoRegistrarse = new JLabel("");
		
		fondoRegistrarse.setOpaque(true);
		fondoRegistrarse.setForeground(Color.WHITE);
		fondoRegistrarse.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(238, 238, 238), new Color(238, 238, 238), new Color(0, 0, 0), new Color(0, 0, 0)));
		fondoRegistrarse.setBackground(new Color(51, 51, 51));
		fondoRegistrarse.setBounds(861, 430, 244, 144);
		
		contentPane.add(fondoRegistrarse);
		
		
		JLabel logoNostale = new JLabel("");
		
		logoNostale.setIcon(new ImageIcon(Login.class.getResource("/resources/logo300x.png")));
		logoNostale.setBounds(689, 73, 300, 158);
		
		contentPane.add(logoNostale);
		
		
		JButton botonSalir = new JButton("Salir");
		
		botonSalir.setBorder(null);
		botonSalir.setFont(new Font("Reem Kufi", Font.BOLD, 13));
		botonSalir.setForeground(new Color(255, 255, 255));
		botonSalir.setBackground(new Color(85, 85, 255));
		botonSalir.setBounds(702, 544, 81, 23);
		
		botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
		
		botonSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(botonSalir);
		
		
		JButton botonContinuar = new JButton("Continuar");
		
		botonContinuar.setBorder(null);
		botonContinuar.setFont(new Font("Reem Kufi", Font.BOLD, 13));
		botonContinuar.setForeground(new Color(255, 255, 255));
		botonContinuar.setBackground(new Color(85, 85, 255));
		botonContinuar.setBounds(599, 544, 81, 23);
		
		botonContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String usuarioLogin = inputUsuario.getText();
            	String contrasenaLogin = new String(inputContrasena.getPassword());
            	
            	Cuenta cuenta = new CuentaControlador().login(usuarioLogin, contrasenaLogin);
            	
            	if(cuenta != null) {
            		new SeleccionPersonaje(cuenta);
            		dispose();
            	} else {
            		new MensajeEmergente("Usuario o contraseña incorrecta");
            	}
            	
            }
        });
		
		botonContinuar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		
	
		
		contentPane.add(botonContinuar);
		
		
		JLabel labelContrasena = new JLabel("Contraseña");
		
		labelContrasena.setForeground(Color.WHITE);
		labelContrasena.setFont(new Font("Reem Kufi", Font.PLAIN, 15));
		labelContrasena.setBounds(556, 511, 88, 14);
		
		contentPane.add(labelContrasena);
		
		
		inputUsuario = new JTextField();
		
		inputUsuario.setAlignmentX(Component.RIGHT_ALIGNMENT);
		inputUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		inputUsuario.setFont(new Font("Reem Kufi", Font.PLAIN, 16));
		inputUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		inputUsuario.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		inputUsuario.setCaretColor(new Color(255, 255, 255));
		inputUsuario.setForeground(new Color(255, 255, 255));
		inputUsuario.setBorder(null);
		inputUsuario.setBackground(new Color(20, 20, 20));
		inputUsuario.setBounds(641, 475, 190, 26);
		
		inputUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(inputUsuario);
	
	
		JLabel labelUsuario = new JLabel("Usuario");
		
		labelUsuario.setForeground(new Color(255, 255, 255));
		labelUsuario.setFont(new Font("Reem Kufi", Font.PLAIN, 15));
		labelUsuario.setBounds(582, 481, 62, 14);
		
		contentPane.add(labelUsuario);
		
		
		JLabel labelLogin = new JLabel("Iniciar Sesión");
		
		labelLogin.setFont(new Font("Dialog", Font.BOLD, 17));
		labelLogin.setForeground(new Color(255, 255, 255));
		labelLogin.setBounds(641, 441, 112, 23);
		
		contentPane.add(labelLogin);
		
		
		JLabel fondoLogin = new JLabel("");
		
		fondoLogin.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(238, 238, 238), new Color(238, 238, 238), new Color(0, 0, 0), new Color(0, 0, 0)));
		fondoLogin.setOpaque(true);
		fondoLogin.setForeground(Color.WHITE);
		fondoLogin.setBackground(new Color(51, 51, 51));
		fondoLogin.setBounds(545, 430, 291, 144);
		
		contentPane.add(fondoLogin);
		
		
		JLabel fondoVentana = new JLabel("");
		fondoVentana.setIcon(new ImageIcon(Login.class.getResource("/resources/fondoLoginn.jpg")));
		
		fondoVentana.setForeground(new Color(255, 255, 255));
		fondoVentana.setBounds(-32, 0, 1920, 1041);
		
		contentPane.add(fondoVentana);
		
		setVisible(true);
	}
}
