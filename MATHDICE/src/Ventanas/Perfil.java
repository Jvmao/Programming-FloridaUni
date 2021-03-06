package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Jugador.Jugador;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Perfil extends JPanel {
	
	//Almacenamos al Jugador//
	private Jugador p1;

	//Variable Ventana Juego//
	private Juego v2;
	
	//Declaraci�n de Variables//
	private JLabel JLabelFoto1;
	private JLabel JLabelNombre,JLabelApellido1, JLabelApellido2, 
	JLabelEdad, JLabelID, JLabelGenero, JLabelPuntos,
	JLabelPerfil1,JLabelPerfil2,JLabelPerfil3,JLabelDatos;
	private JTextField JTextNombre, JTextApellido1 , JTextApellido2, 
	JTextEdad, JTextID, JTextGenero,JTextPuntos;
	private JButton JButtonDatos, JButtonSalir;
	private JTextPane JPaneDatos;

	
	
	public Perfil() {
		setBackground(new Color(255, 255, 102));
		//setLocale("Perfil Jugador");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 900, 600);
		
		//Objeto para la clase Jugador//
		p1 = new Jugador();
		
		//Etiqueta T�tulo//
		JLabelPerfil1 = new JLabel("DATOS PERFIL JUGADOR");
		JLabelPerfil1.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		
		//Etiqueta Foto Perfil//
		JLabelFoto1 = new JLabel("");
		JLabelFoto1.setIcon(new ImageIcon(Perfil.class.getResource("/imagenes/hombre.png")));
		
		//Etiqueta Nombre//
		JLabelNombre = new JLabel("NOMBRE");
		JLabelNombre.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		//Campo de Texto para Nombre//
		JTextNombre = new JTextField();
		JTextNombre.setBackground(new Color(176, 224, 230));
		JTextNombre.setColumns(10);
		JTextNombre.addKeyListener(new innerKL());//A�adimos el KeyListener desde la InnerClass//
		JTextNombre.addActionListener(new innerAction()); //A�adimos el ActionListener desde la InnerClass//
		
		//Etiqueta Apellido1//
		JLabelApellido1 = new JLabel("APELLIDO1");
		JLabelApellido1.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		//Campo de Texto para Apellido1//
		JTextApellido1 = new JTextField();
		JTextApellido1.setBackground(new Color(176, 224, 230));
		JTextApellido1.setColumns(10);
		JTextApellido1.addKeyListener(new innerKL());//A�adimos el KeyListener desde la InnerClass//
		JTextApellido1.addActionListener(new innerAction()); //A�adimos el ActionListener desde la InnerClass//
		
		//Etiqueta y Campo de Texto Para Apellido2//
		JLabelApellido2 = new JLabel("APELLIDO2");
		JLabelApellido2.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		//Campo de Texto para Apellido2//
		JTextApellido2 = new JTextField();
		JTextApellido2.setBackground(new Color(176, 224, 230));
		JTextApellido2.setColumns(10);
		JTextApellido2.addKeyListener(new innerKL());//A�adimos el KeyListener desde la InnerClass//
		JTextApellido2.addActionListener(new innerAction()); //A�adimos el ActionListener desde la InnerClass//
		
		//Etiqueta Edad//
		JLabelEdad = new JLabel("EDAD");
		JLabelEdad.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		//Campo de Texto para Edad//
		JTextEdad = new JTextField();
		JTextEdad.setBackground(new Color(176, 224, 230));
		JTextEdad.setColumns(10);
		JTextEdad.addKeyListener(new innerKL());//A�adimos el KeyListener desde la InnerClass//
		JTextEdad.addActionListener(new innerAction()); //A�adimos el ActionListener desde la InnerClass//
		
		//Etiqueta ID//
		JLabelID = new JLabel("ID");
		JLabelID.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		//Campo de Texto para ID//
		JTextID = new JTextField();
		JTextID.setBackground(new Color(176, 224, 230));
		JTextID.setEditable(false);
		JTextID.setColumns(10);
		
		//Etiqueta y Campo de Texto para G�nero//
		JLabelGenero = new JLabel("G�NERO");
		JLabelGenero.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		
		//Campo de texto para G�nero//
		JTextGenero = new JTextField();
		JTextGenero.setBackground(new Color(176, 224, 230));
		JTextGenero.setColumns(10);
		JTextGenero.addKeyListener(new innerKL()); //A�adimos el KeyListener desde la InnerClass//
		JTextGenero.addActionListener(new innerAction()); //A�adimos el ActionListener desde la InnerClass//
		
		//Etiqueta y Campo de Texto para Puntos//
		JLabelPuntos = new JLabel("PUNTOS");
		JLabelPuntos.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		//Campor de Texto para Puntos//
		JTextPuntos = new JTextField();
		JTextPuntos.setBackground(new Color(176, 224, 230));
		JTextPuntos.setEditable(false);
		JTextPuntos.setColumns(10);
		
		//Bot�n para Actualizar Datos//
		JButtonDatos = new JButton("ACTUALIZAR DATOS");
		JButtonDatos.setEnabled(false);
		JButtonDatos.setForeground(Color.BLUE);
		JButtonDatos.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		JButtonDatos.addActionListener(new innerAL()); //A�adimos el ActionListener desde la Inner Class//
		
		//Etiqueta Datos//
		JLabelDatos = new JLabel("DATOS");
		JLabelDatos.setForeground(Color.BLUE);
		JLabelDatos.setFont(new Font("Stencil", Font.PLAIN, 18));
		JLabelDatos.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Panel para Recoger los Datos Actualizados//
		JPaneDatos = new JTextPane();
		JPaneDatos.setBackground(new Color(204, 255, 204));
		JPaneDatos.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 15));
		JPaneDatos.setEditable(false);
		
		//Bot�n Salir//
		JButtonSalir = new JButton("Salir");
		JButtonSalir.setForeground(Color.DARK_GRAY);
		JButtonSalir.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		JButtonSalir.addActionListener(new innerAL());//A�adimos el ActionListener desde la Inner Class//
		
		
		//Iconos Jugador//
		JLabelPerfil3 = new JLabel("");
		JLabelPerfil3.setIcon(new ImageIcon(Perfil.class.getResource("/imagenes/manc.png")));
		
		JLabelPerfil2 = new JLabel("");
		JLabelPerfil2.setIcon(new ImageIcon(Perfil.class.getResource("/imagenes/mujer.png")));
		
		
		//Caracter�sticas del GroupLayOut//
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(JLabelPerfil1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(JLabelPerfil2, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
										.addComponent(JLabelFoto1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
										.addComponent(JLabelPerfil3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
									.addGap(39)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(JButtonDatos, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(JLabelApellido2, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(JTextApellido2, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(JLabelPuntos, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
												.addComponent(JLabelGenero, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
												.addComponent(JLabelEdad, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
												.addComponent(JLabelID, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
												.addComponent(JLabelApellido1, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
												.addComponent(JLabelNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(JTextGenero, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
												.addComponent(JTextApellido1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
												.addComponent(JTextNombre, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
												.addComponent(JTextID, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
												.addComponent(JTextEdad, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
												.addComponent(JTextPuntos, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)))))
							.addGap(64)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(JPaneDatos, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
								.addComponent(JLabelDatos, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
							.addGap(68))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(JButtonSalir, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(JLabelPerfil1, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(JLabelDatos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(JLabelNombre)
										.addComponent(JTextNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(5)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(30)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(JLabelApellido1)
										.addComponent(JTextApellido1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(JLabelEdad)
										.addComponent(JTextEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(JPaneDatos, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(JLabelID, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(JTextID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(JLabelApellido2)
									.addComponent(JTextApellido2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(JLabelFoto1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(JLabelPerfil2, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(JLabelGenero)
								.addComponent(JTextGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(JLabelPuntos)
								.addComponent(JTextPuntos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addComponent(JButtonDatos))
						.addComponent(JLabelPerfil3, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
					.addGap(36)
					.addComponent(JButtonSalir)
					.addGap(80))
		);
		setLayout(groupLayout);
	}
	
	//Obtenemos los Datos del Jugador//
	public void setJugador(Jugador p1, Juego v2){
		this.p1=p1;
		this.v2=v2;
		JTextNombre.setText(p1.getNombre());
		JTextApellido1.setText(p1.getApellido1());
		JTextApellido2.setText(p1.getApellido2());
		JTextEdad.setText(String.valueOf(p1.getEdad()));
		JTextID.setText(String.valueOf(p1.getId()));
		JTextGenero.setText(p1.getGenero());
		//comboGenero.setSelectedItem(p1.getGenero().toString());
		JTextPuntos.setText(String.valueOf(p1.getPuntos()));
		}
	
	//M�todo para Recibir los Puntos de la Ventana Juego//
	public void setPuntos(int puntos){
		p1.setPuntos(puntos);
		JTextPuntos.setText(String.valueOf(p1.getPuntos()));
	}
	
	//INNER CLASSES//
	private class innerKL implements KeyListener{
		public void keyPressed(KeyEvent arg0) {
		}

		public void keyReleased(KeyEvent arg0) {	
		}

		public void keyTyped(KeyEvent e) {
			JTextField j = (JTextField)e.getSource();
			if(j == JTextNombre){
				char c = e.getKeyChar();
				//SOLO ADMITE LETRAS EN MAY�SCULA,MIN�SCULA Y LA TECLA SPACE, PERO NO N�MEROS//
				if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c !=KeyEvent.VK_SPACE)) e.consume();
				//LIMITAMOS EL TAMA�O DEL TEXTO A 15 CAR�CTERES//
				if(JTextNombre.getText().length()==15) e.consume();
				JButtonDatos.setEnabled(true); //Habilitamos el Bot�n de Actualizar Datos al modificar el Texto//
			}else if(j == JTextApellido1){
				char c = e.getKeyChar();
				//SOLO ADMITE LETRAS EN MAY�SCULA,MIN�SCULA Y LA TECLA SPACE PERO NO N�MEROS//
				if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c !=KeyEvent.VK_SPACE)) e.consume();
				//LIMITAMOS EL TAMA�O DEL TEXTO A 20 CAR�CTERES//
				if(JTextApellido1.getText().length()==20) e.consume();
				JButtonDatos.setEnabled(true); //Habilitamos el Bot�n de Actualizar Datos al modificar el Texto//
			}else if(j == JTextApellido2){
				char c = e.getKeyChar();
				//SOLO ADMITE LETRAS EN MAY�SCULA,MIN�SCULA Y LA TECLA SPACE PERO NO N�MEROS//
				if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c !=KeyEvent.VK_SPACE)) e.consume();
				//LIMITAMOS EL TAMA�O DEL TEXTO A 20 CAR�CTERES//
				if(JTextApellido2.getText().length()==20) e.consume();
				JButtonDatos.setEnabled(true); //Habilitamos el Bot�n de Actualizar Datos al modificar el Texto//
			}else if(j == JTextEdad){
				//SOLO ADMITE N�MEROS Y NO LETRAS//
				char d = e.getKeyChar();
				if(d<'0' || d>'9')e.consume(); 
				//LIMITAMOS EL TAMA�O DEL TEXTO A 2 CAR�CTERES//
				if(JTextEdad.getText().length()==2) e.consume();
				JButtonDatos.setEnabled(true); //Habilitamos el Bot�n de Actualizar Datos al modificar el Texto//
			}else if(j == JTextGenero){
				char c = e.getKeyChar();
				//SOLO ADMITE LETRAS EN MAY�SCULA//
				if((c < 'A' || c > 'Z')) e.consume();
				//LIMITAMOS LA EL TAMA�O DEL TEXTO A 7 CAR�CTERES//
				if(JTextGenero.getText().length()==7) e.consume();
				JButtonDatos.setEnabled(true); //Habilitamos el Bot�n de Actualizar Datos al modificar el Texto//
			}
				
		}
		
	}
	
	private class innerAL implements ActionListener{ //ActionListener para Botones//
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == JButtonDatos){
				p1.setNombre(JTextNombre.getText());
				p1.setApellido1(JTextApellido1.getText());
				p1.setApellido2(JTextApellido2.getText());  
				p1.setEdad(Integer.valueOf(JTextEdad.getText()));
				p1.setId(Integer.valueOf(JTextID.getText()));
				p1.setGenero(JTextGenero.getText());
				JPaneDatos.setText("*Perfil Actualizado Correctamente*\n"+p1);
				//Pasamos el Nombre del Jugador Actualizado a Ventana Juego
				//mediante el m�todo creado en esta ventana y el de la clase juego//
				v2.setNombre(p1.getNombre());
			}
			if (e.getSource() == JButtonSalir){
				System.exit(0);//Al presionar el Bot�n SALIR salimos de la aplicaci�n//
			}

		}
	}
	
	private class innerAction implements ActionListener{//ActionListener para Campos de Texto//
		public void actionPerformed(ActionEvent e) {
			JTextField z = (JTextField)e.getSource();
			if(z == JTextNombre){
				e.setSource((char)KeyEvent.VK_ENTER);//Al presionar la tecla ENTER pasamos al siguiente campo//
				JTextApellido1.requestFocus();
			}else if(z == JTextApellido1){
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextApellido2.requestFocus();
			}else if(z == JTextApellido2){
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextEdad.requestFocus();
			}else if(z == JTextEdad){
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextGenero.requestFocus();
			}
		}
	}
		
}
