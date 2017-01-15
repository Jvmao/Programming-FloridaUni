package Ventana_Principal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Ventana1_Login.Jugador;
import Ventana1_Login.Login;
import Ventana2_Juego.Juego;



public class Principal extends JFrame {

	//Serial Version//
	private static final long serialVersionUID = 1L;
	

	
	public static void main(String[] args) {
		// Ventanas a Utilizar//
				
				Login jugador1 = new Login();
				jugador1.setVisible(true);
				
				Juego juego = new Juego();
				juego.setVisible(false);
				

			}

			Jugador jugador1 = new Jugador();

		}