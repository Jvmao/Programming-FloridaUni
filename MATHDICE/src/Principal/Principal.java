package Principal;

import javax.swing.JFrame;

import Juego.Jugador;
import Ventanas.Login;
import Ventanas.VentanaPrincipal;



public class Principal extends JFrame {
	public Principal() {
	}

	//Serial Version//
	private static final long serialVersionUID = 1L;
	

	
	public static void main(String[] args) {
		// Ventanas a Utilizar//
				
				//Ventana Login//
				Login login = new Login();
				login.setVisible(true);
				
				//Juego juego = new Juego();
				//juego.setVisible(false);
				
				//Ventana Principal//
				VentanaPrincipal vJuego = new VentanaPrincipal();
				vJuego.setVisible(false);

			}

			Jugador jugador1 = new Jugador();

		}