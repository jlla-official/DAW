package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import modelo.ReproductorSonidos;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class PanelDeInformacion extends JFrame {

	private JPanel contentPane;
	

	public PanelDeInformacion(String informacion) {
		
		URL url = getClass().getResource("/resources/cursor.png");
		Image imagenCursor = Toolkit.getDefaultToolkit().getImage(url);
		Cursor cursorPersonalizado = Toolkit.getDefaultToolkit().createCustomCursor(imagenCursor, new Point(0, 0), "Cursor personalizado");
		setCursor(cursorPersonalizado);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 441);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		botonAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReproductorSonidos.reproducirUnaVez("resources\\click.wav");
            }
        });
		
		
		botonAceptar.setBounds(333, 394, 89, 23);
		contentPane.add(botonAceptar);
		
		JLabel fotoArdilla = new JLabel("");
		fotoArdilla.setIcon(new ImageIcon(PanelDeInformacion.class.getResource("/resources/ardilla.png")));
		fotoArdilla.setBounds(333, 22, 119, 72);
		contentPane.add(fotoArdilla);
		
		JTextArea textAreaInformacion = new JTextArea();
		textAreaInformacion.setFont(new Font("Monospaced", Font.BOLD, 15));
		textAreaInformacion.setEditable(false);
		textAreaInformacion.setBounds(61, 120, 685, 252);
		textAreaInformacion.setText(informacion);
		
		contentPane.add(textAreaInformacion);
		
		setVisible(true);
	}
}
