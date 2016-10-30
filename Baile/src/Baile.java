import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Baile extends JFrame {

	private JPanel contentPane;
	private JTextField Texto_1;
	private JTextField Texto_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Baile frame = new Baile();
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
	public Baile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//BOTON 1:
		JButton Boton_1 = new JButton("===>");
		Boton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Texto_2.setText(Texto_1.getText());
				Texto_1.setText("");
			}
		});
		Boton_1.setBounds(158, 38, 89, 23);
		contentPane.add(Boton_1);
		
		//TEXTO 1:
		Texto_1 = new JTextField();
		Texto_1.setBounds(24, 92, 86, 20);
		contentPane.add(Texto_1);
		Texto_1.setColumns(10);
		
		//BOTON 2:
		JButton Boton_2 = new JButton("<===");
		Boton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Texto_1.setText(Texto_2.getText());
				Texto_2.setText("");
			}
		});
		Boton_2.setBounds(158, 161, 89, 23);
		contentPane.add(Boton_2);
		
		//TEXTO 2:
		Texto_2 = new JTextField();
		Texto_2.setBounds(281, 92, 86, 20);
		contentPane.add(Texto_2);
		Texto_2.setColumns(10);
	}
}
