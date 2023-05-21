package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import controlador.CuentaControlador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BanearCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField inputUsuario;

	public BanearCuenta() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 407, 197);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel labelBanearCuenta = new JLabel("BANEAR CUENTA");
		labelBanearCuenta.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelBanearCuenta.setBounds(130, 23, 145, 21);
		contentPane.add(labelBanearCuenta);
		
		JLabel labelUsuario = new JLabel("Usuario :");
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelUsuario.setBounds(62, 88, 54, 17);
		contentPane.add(labelUsuario);
		
		inputUsuario = new JTextField();
		inputUsuario.setBounds(150, 84, 154, 29);
		contentPane.add(inputUsuario);
		inputUsuario.setColumns(10);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonAceptar.setForeground(new Color(255, 255, 255));
		botonAceptar.setBackground(new Color(0, 128, 255));
		botonAceptar.setBorder(null);
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = inputUsuario.getText();
				String resultado = new CuentaControlador().banearCuenta(usuario);
				
				if(resultado != null) {
					new MensajeEmergente(resultado);
				} else {
					new MensajeEmergente("Cuenta baneada");
				}
				
			}
		});
		botonAceptar.setBounds(109, 161, 89, 23);
		contentPane.add(botonAceptar);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botonSalir.setForeground(Color.WHITE);
		botonSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonSalir.setBorder(null);
		botonSalir.setBackground(new Color(0, 128, 255));
		botonSalir.setBounds(231, 161, 89, 23);
		contentPane.add(botonSalir);
		
		setVisible(true);
	}
}
