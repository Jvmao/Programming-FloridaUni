package Ventanas;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Jugador.Jugador;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//Almacenamos al Jugador//
	private Jugador p1;
	
	//Almacenamos la Ventana Juego
	//pasándola a un JPanel para este JFrame
	private Juego ventanaJuego = new Juego();

	//Alamacenamos la Ventana Perfil//
	private Perfil ventanaPerfil = new Perfil();
	
	//Identificadores//
	final static String VENTANAJ = "Ventana Juego";
	final static String VENTANAP = "Ventana Perfil";
	
	public VentanaPrincipal() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Con el comando setLocationRelativeTo centramos la Ventana Principal en el CENTRO de la Pantalla//
		setLocationRelativeTo(null);
		//Impedimos que la Ventana se puedad hacer más grande//
		setResizable(false);
		//Tamaño del Frame//
		setBounds(50, 50, 900, 600);
		dispose();//Cerrar Ventana//
		setPreferredSize(getSize());
		
		//Añadir Ventanas al Contenedor//
		contentPane.add(ventanaJuego , VENTANAJ);
		contentPane.add(ventanaPerfil, VENTANAP);
		
		
		//Barra Menú//
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVentanas = new JMenu("Ventanas");
		menuBar.add(mnVentanas);
		
		JMenuItem mntmJuego = new JMenuItem("Juego");
		mnVentanas.add(mntmJuego);
		//Action Listener para Mostrarnos la Ventana Juego en este JFrame//
		mntmJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, VENTANAJ); //Muestra la Ventana Juego//
				setBounds(50, 50, 900, 600);
			}
		});
		
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mnVentanas.add(mntmPerfil);
		//Action Listener para Mostrarnos la Ventana Perfil en este JFrame//
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(contentPane.getLayout());
				cl.show(contentPane, VENTANAP); //Muestra la Ventana Perfil//
				setBounds(50, 50, 900, 600);
			}
		});
		
	}
	
	//Pasar Datos del Jugador a JPanel//
	public void setJugador(Jugador p1){
		this.p1=p1;
		ventanaJuego.setJugador(p1, ventanaPerfil);
		ventanaPerfil.setJugador(p1, ventanaJuego);
	}

}
