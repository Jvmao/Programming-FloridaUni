import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MiPerfil extends JFrame {

	private JPanel contentPane;
	private JTextField Caja1;
	private JLabel lblNewLabel_1;
	private JTextField Caja2;
	private JLabel lblNewLabel_2;
	private JTextField Caja3;
	private JLabel lblNewLabel_3;
	private JTextField Caja4;
	private JLabel lblNewLabel_4;
	private JTextField Caja5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiPerfil frame = new MiPerfil();
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
	public MiPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String a = new String("José Vicente");
		String b = new String("Martí Olmos");
		String c = new String("34");
		String d = new String("Valencia");
		String e = new String("jvmao82@gmail.com");
		
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(10, 11, 102, 14);
		contentPane.add(lblNewLabel);
		
		//Nombre//
		
		Caja1 = new JTextField();
		Caja1.setBounds(10, 36, 153, 20);
		contentPane.add(Caja1);
		Caja1.setColumns(10);
		
		Caja1.setText(a);
		
		lblNewLabel_1 = new JLabel("APELLIDOS");
		lblNewLabel_1.setBounds(10, 67, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		//Apellidos//
		
		Caja2 = new JTextField();
		Caja2.setBounds(10, 87, 153, 20);
		contentPane.add(Caja2);
		Caja2.setColumns(10);
		
		Caja2.setText(b);
		
		lblNewLabel_2 = new JLabel("EDAD");
		lblNewLabel_2.setBounds(10, 118, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		//EDAD//
		
		Caja3 = new JTextField();
		Caja3.setBounds(10, 141, 153, 20);
		contentPane.add(Caja3);
		Caja3.setColumns(10);
		
		Caja3.setText(c);
		
		lblNewLabel_3 = new JLabel("CIUDAD");
		lblNewLabel_3.setBounds(10, 172, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		//CIUDAD//
		
		Caja4 = new JTextField();
		Caja4.setBounds(10, 197, 153, 20);
		contentPane.add(Caja4);
		Caja4.setColumns(10);
		
		Caja4.setText(d);
		
		lblNewLabel_4 = new JLabel("E-MAIL");
		lblNewLabel_4.setBounds(10, 231, 102, 14);
		contentPane.add(lblNewLabel_4);
		
		//E-MAIL//

		Caja5 = new JTextField();
		Caja5.setBounds(10, 249, 153, 20);
		contentPane.add(Caja5);
		Caja5.setColumns(10);
		
		Caja5.setText(e);
	}

}
