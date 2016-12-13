package Pack_2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import Pack_3.Ventana_2;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;



public class Ventana_1 extends JFrame {

	
		private JPanel contentPane;
		private JTextField nombreJText;
		private JTextField apellido1JText;
		private JTextField apellido2JText;
		private JTextField edadJText;
		private JTextField idJText;
		private JButton boton1;
		private JTextField datosJugadorJText;
	
		
		//Generar Nuevo Jugador//
		Jugador jugador1 = new Jugador();
		
		public Ventana_1() {
			setForeground(Color.BLACK);
			setTitle("Login");
			setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_1.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
			setBackground(Color.LIGHT_GRAY);
			
					//Inicio Jugador//
					jugador1.setNombre(" ");
					jugador1.setApellido1(" ");
					jugador1.setApellido2(" ");
					jugador1.setEdad(150);
					jugador1.setId(1001);
					
			
					//Propiedades Ventana//
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 450, 321);
					contentPane = new JPanel();
					contentPane.setBackground(new Color(32, 178, 170));
					contentPane.setBorder(new CompoundBorder(new LineBorder(null), null));
					setContentPane(contentPane);
					contentPane.setLayout(null);
					
		

					//ETIQUETA JUGADOR//
					JLabel EtiquetaJugador = new JLabel("JUGADOR");
					EtiquetaJugador.setHorizontalAlignment(SwingConstants.CENTER);
					EtiquetaJugador.setFont(new Font("Mongolian Baiti", Font.BOLD, 14));
					EtiquetaJugador.setBounds(91, 11, 310, 14);
					contentPane.add(EtiquetaJugador);
					
					
					
					//Etiqueta NOMBRE// 
					JLabel EtiquetaNombre = new JLabel("NOMBRE");
					EtiquetaNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
					EtiquetaNombre.setBounds(10, 42, 71, 14);
					contentPane.add(EtiquetaNombre);
					//Texto para Nombre//
					nombreJText = new JTextField();
					//KEY LISTENER PARA EL NOMBRE// //SOLO ADMITE LETRAS EN MAYÚSCULAS Y MINÚSCULAS PERO NO NÚMEROS//
					nombreJText.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent evt) {
							char c = evt.getKeyChar();
							if((c<'a' || c>'z') && (c < 'A' || c > 'Z')) evt.consume();
						}
					});
					nombreJText.setBackground(new Color(204, 255, 255));
					//Action Listener Nombre//
					nombreJText.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							//Presionar ENTER y pasar al siguiente texto//
							evt.setSource((char)KeyEvent.VK_ENTER);
							apellido1JText.requestFocus();
							jugador1.setNombre(nombreJText.getText());
						}
					});
					nombreJText.setBounds(91, 39, 310, 20);
					contentPane.add(nombreJText);
					nombreJText.setColumns(10);
					
					
					
					
					//Etiqueta APELLIDO1//
					JLabel EtiquetaApellido1 = new JLabel("APELLIDO1");
					EtiquetaApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
					EtiquetaApellido1.setBounds(10, 67, 71, 14);
					contentPane.add(EtiquetaApellido1);
					//Texto para Apellido1//
					apellido1JText = new JTextField();
					//KEY LISTENER PARA EL NOMBRE// //SOLO ADMITE LETRAS EN MAYÚSCULA Y MINÚSCULA PERO NO NÚMEROS//
					apellido1JText.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent evt) {
							char c = evt.getKeyChar();
							if((c<'a' || c>'z') && (c < 'A' || c > 'Z')) evt.consume();
						}
					});
					apellido1JText.setBackground(new Color(204, 255, 255));
					apellido1JText.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							//Presionar ENTER y pasar al siguiente texto//
							evt.setSource((char)KeyEvent.VK_ENTER);
							apellido2JText.requestFocus();
							jugador1.setApellido1(apellido1JText.getText());
						}
					});
					apellido1JText.setBounds(91, 64, 310, 20);
					contentPane.add(apellido1JText);
					apellido1JText.setColumns(10);
					
					
					//Etiqueta APELLIDO2//
					JLabel EtiquetaApellido2 = new JLabel("APELLIDO2");
					EtiquetaApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
					EtiquetaApellido2.setBounds(10, 92, 71, 14);
					contentPane.add(EtiquetaApellido2);
					//Texto para Apellido2//
					apellido2JText = new JTextField();
					//KEY LISTENER PARA EL NOMBRE// //SOLO ADMITE LETRAS EN MAYÚSCULA Y MINÚSCULA PERO NO NÚMEROS//
					apellido2JText.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent evt) {
							char c = evt.getKeyChar();
							if((c<'a' || c>'z') && (c < 'A' || c > 'Z')) evt.consume();
						}
					});
					apellido2JText.setBackground(new Color(204, 255, 255));
					apellido2JText.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							//Presionar ENTER y pasar al siguiente texto//
							evt.setSource((char)KeyEvent.VK_ENTER);
							edadJText.requestFocus();
							jugador1.setApellido2(apellido2JText.getText());
						}
					});
					apellido2JText.setBounds(91, 89, 310, 20);
					contentPane.add(apellido2JText);
					apellido2JText.setColumns(10);
				
					
					
					
					//Etiqueta EDAD//
					JLabel EtiquetaEdad = new JLabel("EDAD");
					EtiquetaEdad.setFont(new Font("Tahoma", Font.BOLD, 11));
					EtiquetaEdad.setBounds(10, 117, 71, 14);
					contentPane.add(EtiquetaEdad);
					
					//Texto para Edad//
					edadJText = new JTextField();
					//KEY LISTENER PARA LA EDAD// //SOLO ADMITE NÚMEROS Y NO PERMITE ESCRIBIR LETRAS//
					edadJText.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent evt) {
							char c = evt.getKeyChar();
							if(c<'0' || c>'9') evt.consume();
						}
					});
					edadJText.setBackground(new Color(204, 255, 255));
					edadJText.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							//Presionar ENTER y pasar al siguiente texto//
							evt.setSource((char)KeyEvent.VK_ENTER);
							idJText.requestFocus();
							if(jugador1.isNumeric(edadJText.getText())==true)
							jugador1.setEdad(Integer.parseInt(edadJText.getText()));
							else jugador1.setEdad(150);
						}
					});
					edadJText.setBounds(91, 114, 310, 20);
					contentPane.add(edadJText);
					edadJText.setColumns(10);
					
					
					
					
					//Etiqueta ID//
					JLabel EtiquetaID = new JLabel("ID");
					EtiquetaID.setFont(new Font("Tahoma", Font.BOLD, 11));
					EtiquetaID.setBounds(10, 142, 71, 14);
					contentPane.add(EtiquetaID);
					//Texto para ID//
					idJText = new JTextField();
					//KEYLISTENER QUE IMPIDE QUE SE PUEDA MODIFICAR EL TEXTO DE LA ETIQUETA ID//
					idJText.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent evt) {
							idJText.setEnabled(false);
						}
					});
					//ID se asgina por defecto al primer jugador//
					idJText.setText("1001");
					idJText.setBackground(new Color(204, 255, 255));
					idJText.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							
							//Presionar ENTER y pasar al siguiente texto//
							evt.setSource((char)KeyEvent.VK_ENTER);
							boton1.requestFocus();
						}	
					});
					idJText.setBounds(91, 139, 310, 20);
					contentPane.add(idJText);
					idJText.setColumns(10);
					
					
					
					
					
					//Boton JUGAR//  
					boton1 = new JButton("JUGAR >>>");
					boton1.setForeground(new Color(0, 0, 0));
					boton1.setFont(new Font("Myriad Web Pro Condensed", Font.BOLD, 14));
					//Evento Listener//
					boton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//Pasar a Ventana_2 al presionar el botón JUGAR//
						Ventana_2 v2 = new Ventana_2();
						v2.setVisible(true);
						
						//Pasar el Nombre de la Ventana_1 a la Ventana_2 mediante la creación de una nueva variable llamada j1//
						Jugador j1 = new Jugador();
						j1.setNombre(nombreJText.getText());
						//Nombre del Jugador es enviado a la Ventana_2//
						v2.setJugador(j1);
						
						
						//Action Listener para EDAD//
						if(jugador1.isNumeric(edadJText.getText())==true)
							jugador1.setEdad(Integer.parseInt(edadJText.getText()));
						//Action Listener cuando falta el NOMBRE o los APELLIDOS//	
						if (jugador1.espaciosBlanco(jugador1.getNombre()))
						datosJugadorJText.setText("Escribe tu Nombre");
						else if (jugador1.espaciosBlanco(jugador1.getApellido1()))
						datosJugadorJText.setText("Falta Apellido 1");
						else if (jugador1.espaciosBlanco(jugador1.getApellido2()))
						datosJugadorJText.setText("Falta Apellido 2");
						else
						datosJugadorJText.setText("Jugador: "+jugador1.getNombre()+ " " +jugador1.getApellido1()+ " " +jugador1.getApellido2()+ " " +jugador1.getEdad()+ " " +jugador1.getId());
						System.out.println("Jugador: "+jugador1.getNombre()+ " " +jugador1.getApellido1()+ " " +jugador1.getApellido2()+ " " +jugador1.getEdad()+ " años " +jugador1.getId());
						}
					});
					boton1.setBounds(183, 170, 122, 29);
					contentPane.add(boton1);
					
					
					//Recogida de DATOS//
					datosJugadorJText = new JTextField();
					datosJugadorJText.setBackground(new Color(255, 255, 102));
					datosJugadorJText.setBounds(91, 206, 310, 29);
					contentPane.add(datosJugadorJText);
					datosJugadorJText.setColumns(10);
			
	}

		

}
