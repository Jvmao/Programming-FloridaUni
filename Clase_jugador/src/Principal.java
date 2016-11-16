import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Propiedades.Jugador;

public class Principal extends JFrame {

	private JPanel contentPane;

	//Entrada a Programa:
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Constructor//
	public Principal() {
		
		//Propiedades Ventana//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Código del Programa Jugador// 
		Jugador jugador1 = new Jugador();
		jugador1.setNombre("Jose Vicente");
		jugador1.setApellidos("Martí Olmos");
		jugador1.setEdad(34);
		jugador1.setId(0);
		jugador1.setPuntos(0);
		System.out.println(jugador1.toString());
		
	}

}
