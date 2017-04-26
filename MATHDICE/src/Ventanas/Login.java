package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;

import BBDD.ConexionDB;
import BBDD.JugadorDB;
import Jugador.Jugador;

import javax.swing.ImageIcon;


public class Login extends JFrame{
	
	//Generar Nuevo Jugador//
	Jugador p1 = new Jugador();

	//Asignar Nombres a las Variables de los campos de Texto y a los Botones//
	private JPanel contentPane;
	private JTextField nombreJText, apellido1JText, apellido2JText, edadJText, idJText,datosJugadorJText;
	private JLabel EtiquetaJugador,EtiquetaNombre,EtiquetaApellido1,
	EtiquetaApellido2,EtiquetaEdad,generoJText,EtiquetaID, JLabelMando;
	private JComboBox<String> cbGenero;
	private JButton btJugar;

	//Mediante la Clase Random Generamos el ID de Forma aleatoria
	//de 1 a 1000 incluido//
	Random aleatorio = new Random();
	int valor = aleatorio.nextInt(1000)+1;
	
	//Definimos el Semaphore para deshabilitar el Botón Jugar al pasar a la siguiente Ventana//
	private boolean tocaJuego = true;
	
	//Definimos las Variables para la Conexión a la Base de Datos//
	private ConexionDB db;
	private JugadorDB jdb;
	private Connection conexion;
	private boolean connected = false;
	
	//------------------------------------INICIO VENTANA LOGIN-----------------------------------------//
	public Login() {
		setForeground(Color.BLACK);
		setTitle("Registro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		setBackground(Color.LIGHT_GRAY);
		
		
				//Inicio Jugador//
				p1.setNombre(" ");
				p1.setApellido1(" ");
				p1.setApellido2(" ");
				p1.setEdad(99);
				p1.setId(valor);
				p1.setGenero(" ");
				p1.getPuntos();
			
				
		
				//---------------------Propiedades Ventana----------------------------//
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 322);
				contentPane = new JPanel();
				contentPane.setBackground(new Color(255, 127, 80));
				contentPane.setBorder(new CompoundBorder(new LineBorder(null), null));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				//Con el comando setLocationRelativeTo centramos la ventana del Juego en el CENTRO de la Pantalla//
				setLocationRelativeTo(null);
				//Impedimos que la Ventana se puedad hacer más grande//
				setResizable(false);
				//-------------------------------------------------------------------//
				

				//---------------------ETIQUETA JUGADOR-------------------------------//
				EtiquetaJugador = new JLabel("REGISTRO JUGADOR");
				EtiquetaJugador.setHorizontalAlignment(SwingConstants.CENTER);
				EtiquetaJugador.setFont(new Font("Lithos Pro Regular", Font.BOLD, 15));
				EtiquetaJugador.setBounds(91, 11, 310, 14);
				contentPane.add(EtiquetaJugador);
				//-------------------------------------------------------------------//
				
				
				
				//---------------------------Etiqueta NOMBRE------------------------// 
				EtiquetaNombre = new JLabel("NOMBRE");
				EtiquetaNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
				EtiquetaNombre.setBounds(10, 42, 71, 14);
				contentPane.add(EtiquetaNombre);
				//------------------------------------------------------------------//
				
				//-------------------Campo Texto NOMBRE----------------------------//
				nombreJText = new JTextField();
				nombreJText.setBackground(new Color(204, 255, 255));
				nombreJText.setBounds(91, 39, 310, 20);
				contentPane.add(nombreJText);
				nombreJText.setColumns(10);
				nombreJText.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner Class//
				nombreJText.addActionListener(new innerAL());//Añadimos el ActionListener desde la Inner Class//
				//----------------------------------------------------------------//
				
				
				
				//--------------------Etiqueta APELLIDO1--------------------------//
				EtiquetaApellido1 = new JLabel("APELLIDO1");
				EtiquetaApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
				EtiquetaApellido1.setBounds(10, 67, 71, 14);
				contentPane.add(EtiquetaApellido1);
				//---------------------------------------------------------------//
				
				//-------------Campo Texto APELLIDO1----------------------------//
				apellido1JText = new JTextField();
				apellido1JText.setBackground(new Color(204, 255, 255));
				apellido1JText.setBounds(91, 64, 310, 20);
				contentPane.add(apellido1JText);
				apellido1JText.setColumns(10);
				apellido1JText.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner Class//
				apellido1JText.addActionListener(new innerAL());//Añadimos el ActionListener desde la Inner Class//
				//-------------------------------------------------------------//
			
				
				
				//-------------------Etiqueta APELLIDO2-----------------------//
				EtiquetaApellido2 = new JLabel("APELLIDO2");
				EtiquetaApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
				EtiquetaApellido2.setBounds(10, 92, 71, 14);
				contentPane.add(EtiquetaApellido2);
				//-----------------------------------------------------------//
				
				//---------------Campo Texto APELLIDO2-----------------------//
				apellido2JText = new JTextField();
				apellido2JText.setBackground(new Color(204, 255, 255));
				apellido2JText.setBounds(91, 89, 310, 20);
				contentPane.add(apellido2JText);
				apellido2JText.setColumns(10);
				apellido2JText.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner Class//
				apellido2JText.addActionListener(new innerAL());//Añadimos el ActionListener desde la Inner Class//
				//----------------------------------------------------------//
				
				
				
				//-----------------Etiqueta EDAD---------------------------//
				EtiquetaEdad = new JLabel("EDAD");
				EtiquetaEdad.setFont(new Font("Tahoma", Font.BOLD, 11));
				EtiquetaEdad.setBounds(10, 117, 71, 14);
				contentPane.add(EtiquetaEdad);
				//--------------------------------------------------------//
				
				//------------------Campo Texto Edad----------------------//
				edadJText = new JTextField();
				edadJText.setBackground(new Color(204, 255, 255));
				edadJText.setBounds(91, 114, 310, 20);
				contentPane.add(edadJText);
				edadJText.setColumns(10);
				edadJText.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner Class//
				edadJText.addActionListener(new innerAL());//Añadimos el ActionListener desde la Inner Class//
				//-------------------------------------------------------//
				
				
				
				//----------------------Etiqueta ID---------------------//
				EtiquetaID = new JLabel("ID");
				EtiquetaID.setFont(new Font("Tahoma", Font.BOLD, 11));
				EtiquetaID.setBounds(10, 142, 71, 14);
				contentPane.add(EtiquetaID);
				//-----------------------------------------------------//
				
				//-----------------Campo Texto para ID-----------------//
				idJText = new JTextField();
				idJText.setFont(new Font("Tahoma", Font.BOLD, 12));
				idJText.setBounds(91, 138, 310, 20);
				contentPane.add(idJText);
				idJText.setColumns(10);
				idJText.setBackground(new Color(204, 255, 255));
				idJText.setText(Integer.toString(valor)); //Generamos el ID de forma aleatoria//
				idJText.addKeyListener(new innerKL()); //Añadimos el KeyListener desde la Inner Class//
				idJText.addActionListener(new innerAL());//Añadimos el ActionListener desde la Inner Class//
				//--------------------------------------------------------//
			
				
				//----------Etiqueta Desplegable Para GÉNERO--------------//
				generoJText = new JLabel("G\u00C9NERO");
				generoJText.setFont(new Font("Tahoma", Font.BOLD, 11));
				generoJText.setBounds(10, 171, 46, 14);
				contentPane.add(generoJText);
				//-------------------------------------------------------//
				
				//----------------Campo Deplegable GENERO---------------//
				cbGenero = new JComboBox<String>();
				cbGenero.addItem(" HOMBRE ");
				cbGenero.addItem(" MUJER ");
				cbGenero.setBackground(new Color(230, 230, 250));
				cbGenero.setBounds(91, 168, 310, 20);
				contentPane.add(cbGenero);
				
				//Action Listener en el ComoBox para poder seleccionar varias opciones dentro de la pestaña//
				cbGenero.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cbGenero.getSelectedItem().toString();
						//Pasamos los Datos a la Ventana Recogida de Datos//
						p1.setGenero(cbGenero.getSelectedItem().toString());
					}
				});
				//---------------------------------------------------------//
				
				
				
				
				//------------------------------Boton JUGAR-----------------------------------------//  
				btJugar = new JButton("JUGAR >>>");
				btJugar.setBackground(Color.GRAY);
				btJugar.setForeground(new Color(0, 0, 0));
				btJugar.setFont(new Font("Lithos Pro Regular", Font.BOLD, 14));
				btJugar.setBounds(183, 202, 218, 29);
				contentPane.add(btJugar);
				btJugar.addActionListener(new actionButton());//Añadimos el ActionListener desde la Inner Class//
				//--------------------------------------------------------------------------------//
				
				
				
				//-------------------------------Recogida de DATOS-------------------------------------//
				datosJugadorJText = new JTextField();
				datosJugadorJText.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 11));
				datosJugadorJText.setBackground(Color.ORANGE);
				datosJugadorJText.setBounds(91, 242, 310, 40);
				contentPane.add(datosJugadorJText);
				datosJugadorJText.setColumns(10);
				datosJugadorJText.setEnabled(false);//Inhabilitamos el campo de la recogida de datos//
				//-------------------------------------------------------------------------------------//
				
				//-----------------------Imagen Mando Jugador------------------------------------------//
				JLabelMando = new JLabel("");
				JLabelMando.setIcon(new ImageIcon(Login.class.getResource("/imagenes/mando.png")));
				JLabelMando.setBounds(91, 199, 59, 35);
				contentPane.add(JLabelMando);
				//-------------------------------------------------------------------------------------//
				
				//Datos Necesarios para la Conexión a la BBDD//
				db = new ConexionDB("localhost","mathdice","root"," ");
				//Establecemos la Conexión//
				connected=db.connectDB();
				//Asignamos con el getter la conexión establecida//
				conexion=db.getConexion();
				//Pasamos la Conexión a un Nuevo Jugador//
				jdb=new JugadorDB(conexion);
				
				//Comprobamos que la Conexión ha tenido Éxito//
				if(connected==false){
					System.out.println("SIN EXITO EN LA CONEXIÓN");
				}else{ 
					System.out.println("EXITO EN LA CONEXIÓN");
				}
	}
	
	//Definimos el KeyListener para los JTextField desde una InnerClass//
	private class innerKL implements KeyListener{
		public void keyPressed(KeyEvent e) {	
		}

		public void keyReleased(KeyEvent e) {	
		}

		public void keyTyped(KeyEvent e) {
			JTextField field = (JTextField)e.getSource();
			if(field == nombreJText){
				char c = e.getKeyChar();
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA Y LA TECLA SPACE, PERO NO NÚMEROS//
				if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c !=KeyEvent.VK_SPACE)) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 15 CARÁCTERES//
				if(nombreJText.getText().length()==15) e.consume();
			}else if(field == apellido1JText){
				char c = e.getKeyChar();
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA Y LA TECLA SPACE, PERO NO NÚMEROS//
				if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c !=KeyEvent.VK_SPACE)) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 20 CARÁCTERES//
				if(apellido1JText.getText().length()==20) e.consume();
			}else if(field == apellido2JText){
				char c = e.getKeyChar();
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA Y LA TECLA SPACE, PERO NO NÚMEROS//
				if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c !=KeyEvent.VK_SPACE)) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 20 CARÁCTERES//
				if(apellido2JText.getText().length()==20) e.consume();
			}else if(field == edadJText){
				//SOLO ADMITE NÚMEROS Y NO PERMITE ESCRIBIR LETRAS//
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
			}else if(field == idJText){
				//KEYLISTENER QUE IMPIDE QUE SE PUEDA MODIFICAR EL TEXTO DE LA ETIQUETA ID//
				idJText.setEnabled(false);
			}
		}
		
	}
	
	//Definimos el ActionListener para los JTextField desde una InnerClass//
	private class innerAL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JTextField action = (JTextField)e.getSource();
			if(action == nombreJText){
				e.setSource((char)KeyEvent.VK_ENTER);//Presionar ENTER y pasar al siguiente texto//
				apellido1JText.requestFocus();
				p1.setNombre(nombreJText.getText()); //Pasamos los Datos a la Ventana Recogida de Datos// 
			}else if(action == apellido1JText){
				e.setSource((char)KeyEvent.VK_ENTER);//Presionar ENTER y pasar al siguiente texto//
				apellido2JText.requestFocus();
				p1.setApellido1(apellido1JText.getText());//Pasamos los Datos a la Ventana Recogida de Datos//
			}else if(action == apellido2JText){
				e.setSource((char)KeyEvent.VK_ENTER);//Presionar ENTER y pasar al siguiente texto//
				edadJText.requestFocus();
				p1.setApellido2(apellido2JText.getText());//Pasamos los Datos a la Ventana Recogida de Datos//
			}else if(action == edadJText){
				e.setSource((char)KeyEvent.VK_ENTER);//Presionar ENTER y pasar al siguiente texto//
				idJText.requestFocus();
				//Limita la Edad hasta 2 dígitos, si se escriben más dará un error//
				if(edadJText.getText().length()==2){
					p1.setEdad(Integer.parseInt(edadJText.getText()));
				}else{ 
					p1.setEdad(99);}
			}else if(action == idJText){
				e.setSource((char)KeyEvent.VK_ENTER);//Presionar ENTER y pasar al siguiente texto//
				cbGenero.requestFocus();
				p1.setId(Integer.parseInt(idJText.getText()));//Pasamos los Datos a la Ventana Recogida de Datos//
			}
		}
		
	}
	
	//Definimos el ActionListener para el Botón JUGAR desde una InnerClass//
	public class actionButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton)e.getSource();
			if(boton == btJugar){
				//Generar Nueva Variable v1 para referirnos a la Ventana Login//
				Login v1 = new Login();
				//Generar Nueva Variable v2 dentro del Botón JUGAR 
				//para pasar a la siguiente Ventana de Juego.
				//Juego v2 = new Juego();
				//Generar Nueva Variable para pasar de la Ventana Login a
				//la Ventana Principal//
				VentanaPrincipal v3 = new VentanaPrincipal();
				
				
				//Action Listener para EDAD dentro del Boton JUGAR//
				if (p1.getEdad()== 99){
					//Muestra otra ventana con la opción JOptionPane 
					//donde se indica que la EDAD es incorrecta
					JOptionPane.showMessageDialog(null, "La EDAD es Incorrecta - Vuélvala a Escribir y Pulse ENTER");
					datosJugadorJText.setText("EDAD incorrecta");
					return;
				}else if (p1.espaciosBlanco(p1.getNombre())){//Action Listener cuando falta el NOMBRE  	
					//Muestra otra Ventana, con la opción JOptionPane donde se indica que falta el Nombre del jugador//
					JOptionPane.showMessageDialog(null, "Falta NOMBRE - Vuélvalo a Introducir y Pulse ENTER");
					datosJugadorJText.setText("Falta Nombre"); 
					return;
				}else if (p1.espaciosBlanco(p1.getApellido1())){//Action Listener cuando falta el APELLIDO1  
					//Muestra otra Ventana donde se indica que falta el Apellido1 del jugador//
					JOptionPane.showMessageDialog(null, "Falta PRIMER APELLIDO - Vuélvalo a Introducir y Pulse ENTER");
					datosJugadorJText.setText("Falta Primer Apellido"); 
					return;
				}else if (p1.espaciosBlanco(p1.getApellido2())){ //Action Listener cuando falta el APELLIDO2  
					//Muestra otra Ventana donde se indica que falta el Apellido2 del jugador//
					JOptionPane.showMessageDialog(null, "Falta SEGUNDO APELLIDO - Vuélvalo a Introducir y Pulse ENTER");
					datosJugadorJText.setText("Falta Segundo Apellido");
					return;
					
				}else{
				//Recogida de Datos//
				datosJugadorJText.setText("JUGADOR: "+p1.getNombre()+ " " +p1.getApellido1()+ " " 
				+p1.getApellido2()+ " " +p1.getEdad()+ " " +p1.getId()+ " " +p1.getGenero());
				}
				
				//Se introduce una excepción con Try para evitar errores al pasar a la ventana Juego//
					try{
					v3.setVisible(true);//Pasar a VentanaPrincipal al presionar el botón JUGAR//
					}catch (Exception evt){
						evt.getMessage();
					}
			
				
				//Se introduce una excepción con Try para evitar errores al pasar el Nombre 
				// a la ventana Juego//
			    	try {
			    	//Pasar el Nombre de la Ventana LOGIN a la Ventana JUEGO y TODOS los datos a la Ventana PERFIL// 
					Jugador p1 = new Jugador();
					p1.setNombre(nombreJText.getText());
					p1.setApellido1(apellido1JText.getText());
					p1.setApellido2(apellido2JText.getText());
					p1.setEdad(Integer.parseInt(edadJText.getText()));
					p1.setId(Integer.parseInt(idJText.getText())); 
					p1.setGenero(cbGenero.getSelectedItem().toString());
			    	v3.setJugador(p1); 
			    	}catch (Exception evt){
			    		evt.getMessage();
			    	}
				//Establecemos un semáforo que deshabilita el Botón JUGAR  y todos los demás campos
		    	//al pasar a la Ventana del Juego//
		    	if(!tocaJuego){
		    		tocaJuego = true;
		    		btJugar.setEnabled(false);
		    	}else{
		    		tocaJuego = false;
		    		btJugar.setEnabled(false);
		    		nombreJText.setEnabled(false);
		    		apellido1JText.setEnabled(false); 
		    		apellido2JText.setEnabled(false);
		    		edadJText.setEnabled(false);
		    		cbGenero.setEnabled(false);
		    	}
			
			//Salida de Datos en Consola Eclipse//
			System.out.println("Jugador: "+p1.getNombre()+ " " +p1.getApellido1()+ " "
			+p1.getApellido2()+ " " +p1.getEdad()+ " años " + " " +p1.getId()+ " " +p1.getGenero());
		 	}
			
			//Recogemos los Datos del Jugador para pasarlos a la BBDD en MySQL//
			jdb.insertarUsuario(nombreJText.getText(),apellido1JText.getText(),apellido2JText.getText(),
					Integer.valueOf(edadJText.getText()),Integer.valueOf(idJText.getText()),
					cbGenero.getSelectedItem().toString(),p1.getPuntos());
			
			//Enviamos un Mensaje para hacer saber al Jugador si se ha registrado en la BBDD o no//
			if(connected==true){
				JOptionPane.showMessageDialog(null,"Jugador Registrado con éxito en la BBDD");
			}else {
				JOptionPane.showMessageDialog(null, "Fallo en el Registro, comprueba la Conexión");
			}
		}
		
	}
}

