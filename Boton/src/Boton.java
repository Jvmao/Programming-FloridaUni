import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class Boton extends JFrame {

	private JPanel contentPane;
	private JTextField Caja1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Boton frame = new Boton();
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
	public Boton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String a = new String("JVMAO");
		
		//Boton//
		JButton Boton = new JButton("Aceptar");
		Boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Estas Muerto Primo!!");
			}
		});
		Boton.setBounds(151, 11, 89, 23);
		contentPane.add(Boton);
		
		JButton Boton1 = new JButton("Entrar");
		Boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Te estoy hackeando :)");
			}
		});
		Boton1.setBounds(151, 74, 89, 23);
		contentPane.add(Boton1);
		
		Caja1 = new JTextField();
		Caja1.setBounds(154, 125, 86, 20);
		contentPane.add(Caja1);
		Caja1.setColumns(10);
		
		Caja1.setText(a);
		
		JButton Boton2 = new JButton("GANAR!!");
		Boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("A Pagar");
			}
		});
		Boton2.setBounds(151, 174, 89, 23);
		contentPane.add(Boton2);
			
	}
}
