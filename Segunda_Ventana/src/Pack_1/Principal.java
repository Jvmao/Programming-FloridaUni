package Pack_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Pack_2.Jugador;
import Pack_2.Ventana_1;
import Pack_3.Ventana_2;


public class Principal extends JFrame {

	public static void main(String[] args) {
				//Ventanas a Utilizar//
					Ventana_2 ventana2 = new Ventana_2();
					ventana2.setVisible(false);
					
					Ventana_1 jugador1 = new Ventana_1();
					jugador1.setVisible(true);		
	}
	
	Jugador jugador1 = new Jugador();

}


