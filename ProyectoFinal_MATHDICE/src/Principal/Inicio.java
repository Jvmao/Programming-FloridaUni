package Principal;

import javax.swing.JFrame;

import Ventanas_Juego.Juego;
import Ventanas_Juego.Registro;

public class Inicio extends JFrame {

	public static void main(String[] args) {
		//Ventana Registro Jugador//
		Registro registro = new Registro();
		registro.setVisible(true);
	}

}
