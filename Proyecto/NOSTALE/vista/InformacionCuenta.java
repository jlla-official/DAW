package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import controlador.CuentaControlador;
import modelo.Cuenta;
import modelo.ReproductorSonidos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InformacionCuenta extends JFrame {

	private JPanel contentPane;
	private JPasswordField inputNuevaContrasena;
	private JPasswordField inputRepetirNuevaContrasena;
	private JTextField inputNuevoEmail;
	private JTextField inputRepetirNuevoEmail;
	private JLabel fondoNuevaContrasena;
	private JLabel labelNuevaContrasena;
	private JButton botonAceptarNuevaContrasena;
	private JButton botonCancelarNuevaContrasena;
	private JButton botonAceptarNuevoEmail;
	private JLabel labelRepetirNuevaContrasena;
	private CuentaControlador cuentaBD = new CuentaControlador();
	

	public InformacionCuenta(Cuenta cuenta) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 791, 620);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonCambiarContrasena = new JButton("Nueva contraseña");
		botonCambiarContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondoNuevaContrasena.setVisible(true);
				labelNuevaContrasena.setVisible(true);
				inputNuevaContrasena.setVisible(true);
				inputNuevaContrasena.setEnabled(true);
				botonAceptarNuevaContrasena.setVisible(true);
				botonAceptarNuevaContrasena.setEnabled(true);
				botonCancelarNuevaContrasena.setVisible(true);
				botonCancelarNuevaContrasena.setEnabled(true);
				labelRepetirNuevaContrasena.setVisible(true);
				inputRepetirNuevaContrasena.setVisible(true);
				inputRepetirNuevaContrasena.setEnabled(true);
			}
		});
		
		botonCambiarContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		fondoNuevaContrasena = new JLabel("");
		fondoNuevaContrasena.setVisible(false);
		
		JLabel fondoNuevoEmail = new JLabel("");
		fondoNuevoEmail.setVisible(false);
		
		labelNuevaContrasena = new JLabel("Nueva contraseña :");
		labelNuevaContrasena.setVisible(false);
		
		labelRepetirNuevaContrasena = new JLabel("Repetir nueva contraseña :");
		labelRepetirNuevaContrasena.setVisible(false);
		
		inputRepetirNuevaContrasena = new JPasswordField();
		inputRepetirNuevaContrasena.setVisible(false);
		
		JLabel labelNuevoEmail = new JLabel("Nuevo E-mail :");
		labelNuevoEmail.setVisible(false);
		
		JLabel labelRepetirNuevoEmail = new JLabel("Repetir nuevo E-mail :");
		labelRepetirNuevoEmail.setVisible(false);
		
		botonCancelarNuevaContrasena = new JButton("Cancelar");
		botonCancelarNuevaContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondoNuevaContrasena.setVisible(false);
				labelNuevaContrasena.setVisible(false);
				inputNuevaContrasena.setVisible(false);
				inputNuevaContrasena.setEnabled(false);
				botonAceptarNuevaContrasena.setVisible(false);
				botonAceptarNuevaContrasena.setEnabled(false);
				botonCancelarNuevaContrasena.setVisible(false);
				botonCancelarNuevaContrasena.setEnabled(false);
				labelRepetirNuevaContrasena.setVisible(false);
				inputRepetirNuevaContrasena.setVisible(false);
				inputRepetirNuevaContrasena.setEnabled(false);
			}
		});
		botonCancelarNuevaContrasena.setEnabled(false);
		botonCancelarNuevaContrasena.setVisible(false);
		botonCancelarNuevaContrasena.setForeground(Color.WHITE);
		botonCancelarNuevaContrasena.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonCancelarNuevaContrasena.setBorder(null);
		botonCancelarNuevaContrasena.setBackground(new Color(0, 128, 255));
		botonCancelarNuevaContrasena.setBounds(392, 117, 77, 23);
		
		botonCancelarNuevaContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(botonCancelarNuevaContrasena);
		
		JButton botonCancelarNuevoEmail = new JButton("Cancelar");
		botonCancelarNuevoEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondoNuevoEmail.setVisible(false);
				labelNuevoEmail.setVisible(false);
				inputNuevoEmail.setVisible(false);
				inputNuevoEmail.setEnabled(false);
				botonAceptarNuevoEmail.setVisible(false);
				botonAceptarNuevoEmail.setEnabled(false);
				botonCancelarNuevoEmail.setVisible(false);
				botonCancelarNuevoEmail.setEnabled(false);
				inputRepetirNuevoEmail.setVisible(false);
				inputRepetirNuevoEmail.setEnabled(false);
				labelRepetirNuevoEmail.setVisible(false);
			}
		});
		botonCancelarNuevoEmail.setEnabled(false);
		botonCancelarNuevoEmail.setVisible(false);
		botonCancelarNuevoEmail.setForeground(Color.WHITE);
		botonCancelarNuevoEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonCancelarNuevoEmail.setBorder(null);
		botonCancelarNuevoEmail.setBackground(new Color(0, 128, 255));
		botonCancelarNuevoEmail.setBounds(392, 584, 77, 23);
		
		botonCancelarNuevoEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(botonCancelarNuevoEmail);
		
		botonAceptarNuevoEmail = new JButton("Aceptar");
		
		botonAceptarNuevoEmail.setEnabled(false);
		botonAceptarNuevoEmail.setVisible(false);
		botonAceptarNuevoEmail.setForeground(Color.WHITE);
		botonAceptarNuevoEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonAceptarNuevoEmail.setBorder(null);
		botonAceptarNuevoEmail.setBackground(new Color(0, 128, 255));
		botonAceptarNuevoEmail.setBounds(265, 584, 77, 23);
		
		botonAceptarNuevoEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nuevoEmail = inputNuevoEmail.getText();
				String repetirNuevoEmail = inputRepetirNuevoEmail.getText();
				
				if(
				   nuevoEmail.equals(repetirNuevoEmail) && 
				   nuevoEmail.contains("@") && 
				   nuevoEmail.contains(".")
				   ) {
					
					if(cuentaBD.actualizarEmail(nuevoEmail, cuenta.getId()) == null) {
						cuenta.setEmail(inputNuevoEmail.getText());
						new InformacionCuenta(cuenta);
						dispose();
					}
					
				} else if(nuevoEmail.equals("")) {
					
					new MensajeEmergente("Introduce un e-mail");
					
				} else if(!nuevoEmail.contains("@") || !nuevoEmail.contains(".")) {
					
					new MensajeEmergente("Introduce un e-mail valido");
					
				} else if (repetirNuevoEmail.equals("")) {
					
					new MensajeEmergente("Repite el e-mail");
					
				} else if (!nuevoEmail.equals(repetirNuevoEmail)) {
					
					new MensajeEmergente("Los e-mail no coinciden");
					
				}
					
			}
		});
		
		botonAceptarNuevoEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(botonAceptarNuevoEmail);
		
		inputRepetirNuevoEmail = new JTextField();
		inputRepetirNuevoEmail.setEnabled(false);
		inputRepetirNuevoEmail.setVisible(false);
		inputRepetirNuevoEmail.setColumns(10);
		inputRepetirNuevoEmail.setBounds(339, 542, 256, 20);
		
		inputRepetirNuevoEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(inputRepetirNuevoEmail);
		
		inputNuevoEmail = new JTextField();
		inputNuevoEmail.setEnabled(false);
		inputNuevoEmail.setVisible(false);
		inputNuevoEmail.setBounds(339, 500, 256, 20);
		
		inputNuevoEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(inputNuevoEmail);
		inputNuevoEmail.setColumns(10);
		
		labelRepetirNuevoEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelRepetirNuevoEmail.setBounds(171, 540, 198, 20);
		contentPane.add(labelRepetirNuevoEmail);
		
		labelNuevoEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNuevoEmail.setBounds(223, 498, 106, 20);
		contentPane.add(labelNuevoEmail);
		
		inputRepetirNuevaContrasena.setEnabled(false);
		inputRepetirNuevaContrasena.setBounds(382, 83, 149, 20);
		
		inputRepetirNuevaContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(inputRepetirNuevaContrasena);
		
		inputNuevaContrasena = new JPasswordField();
		inputNuevaContrasena.setEnabled(false);
		inputNuevaContrasena.setVisible(false);
		inputNuevaContrasena.setBounds(382, 40, 149, 20);
		
		inputNuevaContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(inputNuevaContrasena);
		
		botonAceptarNuevaContrasena = new JButton("Aceptar");
		botonAceptarNuevaContrasena.setEnabled(false);
		botonAceptarNuevaContrasena.setVisible(false);
		botonAceptarNuevaContrasena.setForeground(Color.WHITE);
		botonAceptarNuevaContrasena.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonAceptarNuevaContrasena.setBorder(null);
		botonAceptarNuevaContrasena.setBackground(new Color(0, 128, 255));
		botonAceptarNuevaContrasena.setBounds(265, 117, 77, 23);
		
		botonAceptarNuevaContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		botonAceptarNuevaContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nuevaContrasena = new String(inputNuevaContrasena.getPassword());
				String repetirNuevaContrasena = new String(inputRepetirNuevaContrasena.getPassword());
				
				if(nuevaContrasena.equals(repetirNuevaContrasena) && nuevaContrasena.length() >= 8) {
					
					if(cuentaBD.actualizarContrasena(nuevaContrasena, cuenta.getId()) == null) {
						cuenta.setContrasena(nuevaContrasena);
						new InformacionCuenta(cuenta);
						dispose();
					}
				
				} else if (nuevaContrasena.equals("")) {
					
					new MensajeEmergente("Introduce una contraseña");
				
				} else if (nuevaContrasena.length() < 8) {
						
					new MensajeEmergente("Introduce una contraseña de al menos 8 caracteres");
			
				} else if (repetirNuevaContrasena.equals("")) {
					
					new MensajeEmergente("Introduce de nuevo la contraseña");
					
				} else if (!nuevaContrasena.equals(repetirNuevaContrasena)) {
					
					new MensajeEmergente("Las contraseñas no coinciden");
				}
					
			}
		});
		
		contentPane.add(botonAceptarNuevaContrasena);
		
		labelRepetirNuevaContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelRepetirNuevaContrasena.setBounds(186, 81, 189, 20);
		contentPane.add(labelRepetirNuevaContrasena);
		
		labelNuevaContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNuevaContrasena.setBounds(238, 38, 136, 20);
		contentPane.add(labelNuevaContrasena);
		
		fondoNuevoEmail.setOpaque(true);
		fondoNuevoEmail.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		fondoNuevoEmail.setBackground(Color.WHITE);
		fondoNuevoEmail.setBounds(157, 481, 457, 134);
		contentPane.add(fondoNuevoEmail);
		fondoNuevaContrasena.setOpaque(true);
		fondoNuevaContrasena.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		fondoNuevaContrasena.setBackground(Color.WHITE);
		fondoNuevaContrasena.setBounds(157, 11, 457, 139);
		contentPane.add(fondoNuevaContrasena);
		
		JButton botonSalirInformacionCuenta = new JButton("Salir");
		botonSalirInformacionCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botonSalirInformacionCuenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		botonSalirInformacionCuenta.setForeground(Color.WHITE);
		botonSalirInformacionCuenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonSalirInformacionCuenta.setBorder(null);
		botonSalirInformacionCuenta.setBackground(new Color(0, 128, 255));
		botonSalirInformacionCuenta.setBounds(346, 435, 77, 23);
		
		contentPane.add(botonSalirInformacionCuenta);
		
		botonCambiarContrasena.setForeground(Color.WHITE);
		botonCambiarContrasena.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonCambiarContrasena.setBorder(null);
		botonCambiarContrasena.setBackground(new Color(0, 128, 255));
		botonCambiarContrasena.setBounds(404, 389, 127, 23);
		
		botonCambiarContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		contentPane.add(botonCambiarContrasena);
		
		JButton botonCambiarEmail = new JButton("Cambiar E-mail");
		
		botonCambiarEmail.setForeground(new Color(255, 255, 255));
		botonCambiarEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonCambiarEmail.setBackground(new Color(0, 128, 255));
		botonCambiarEmail.setBorder(null);
		botonCambiarEmail.setBounds(246, 389, 110, 23);
		
		botonCambiarEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		botonCambiarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fondoNuevoEmail.setVisible(true);
				labelNuevoEmail.setVisible(true);
				inputNuevoEmail.setVisible(true);
				inputNuevoEmail.setEnabled(true);
				botonAceptarNuevoEmail.setVisible(true);
				botonAceptarNuevoEmail.setEnabled(true);
				botonCancelarNuevoEmail.setVisible(true);
				botonCancelarNuevoEmail.setEnabled(true);
				inputRepetirNuevoEmail.setVisible(true);
				inputRepetirNuevoEmail.setEnabled(true);
				labelRepetirNuevoEmail.setVisible(true);
			}
		});
		
		contentPane.add(botonCambiarEmail);
		
		JLabel emailBD = new JLabel("");
		emailBD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailBD.setBounds(286, 322, 297, 23);
		emailBD.setText(cuenta.getEmail());
		contentPane.add(emailBD);
		
		JLabel usuarioBD = new JLabel("");
		usuarioBD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usuarioBD.setBounds(286, 269, 161, 14);
		usuarioBD.setText(cuenta.getUsuario());
		contentPane.add(usuarioBD);
		
		JLabel labelEmail = new JLabel("Email :");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEmail.setBounds(219, 323, 50, 20);
		contentPane.add(labelEmail);
		
		JLabel labelUsuario = new JLabel("Usuario :");
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelUsuario.setBounds(204, 266, 65, 20);
		contentPane.add(labelUsuario);
		
		JLabel tituloDetallesCuenta = new JLabel("DETALLES DE LA CUENTA");
		tituloDetallesCuenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		tituloDetallesCuenta.setBounds(282, 197, 210, 20);
		contentPane.add(tituloDetallesCuenta);
		
		JLabel fondoDetallesCuenta = new JLabel("");
		fondoDetallesCuenta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		fondoDetallesCuenta.setBackground(new Color(255, 255, 255));
		fondoDetallesCuenta.setOpaque(true);
		fondoDetallesCuenta.setBounds(157, 161, 457, 309);
		contentPane.add(fondoDetallesCuenta);
		
		JLabel fondoInformacionCuenta = new JLabel("");
		fondoInformacionCuenta.setIcon(new ImageIcon(InformacionCuenta.class.getResource("/resources/fondoInformacionCuenta.jpg")));
		fondoInformacionCuenta.setBounds(0, 0, 791, 622);
		contentPane.add(fondoInformacionCuenta);
		
		setVisible(true);
	}
}
