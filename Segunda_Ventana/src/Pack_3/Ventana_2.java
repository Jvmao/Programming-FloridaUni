package Pack_3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Pack_2.Jugador;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_2 extends JFrame {

	private JPanel contentPane;
	private Jugador j1;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_2 frame = new Ventana_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana_2() {
		setTitle("Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(5, 5, 424, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Botón para cerrar la Aplicación//
				dispose();
				
				//Código para cerrar la aplicación entera.Cuando cerramos desde la Ventana_2 también se cerrará la Ventana_1//
				System.exit(0);
			}
		});
		btnNewButton.setBounds(449, 264, 89, 23);
		contentPane.add(btnNewButton);
	}

	//Comprobar esta parte porque hay algo mal aquí//
	public void setJugador(Jugador j1){
		this.j1=j1;
		lblNewLabel.setText("Bienvenido: " +j1.getNombre());
	}
}
