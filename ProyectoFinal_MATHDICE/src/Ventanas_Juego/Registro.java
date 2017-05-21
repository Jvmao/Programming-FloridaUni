package Ventanas_Juego;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;


import Jugador.Jugador;
import Modelo.ConexionDB;
import Modelo.JugadorDB;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Registro extends JFrame {

	//Variables para Etiquetas,Campos de Texto,ComboBox y Botones//
	private JPanel contentPane;
	private JTextField JTextNombre,JTextApellido1,JTextApellido2,JTextEdad,JTextEmail,JTextCode;
	private JLabel JLabelRegistro,JLabelNombre,JLabelApellido1,
	JLabelApellido2,JLabelEdad,JLabelGen,JLabelEmail,JLabelCode,JLabelInfo;
	private JButton JButtonRegistro,JButtonSalir,JButtonJugar,JButtonUsuarios,JButtonReset;
	private JComboBox<Object> cbGen,cbJugador;
	private JScrollPane scrollPane;
	private JTextArea JTextArea;
	
	//Variables para las Ventanas//
	Juego v2 = new Juego();
	VentanaPrincipal v3 = new VentanaPrincipal();
	
	//Generamos un Nuevo Jugador//
	Jugador p1 = new Jugador();
	
	//Variables para Generar el ID de Forma Aleatoria//
	Random aleatorio = new Random();
	private String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
	private String cadena = "";//Inicializamos la Variable//
	private int valor;
	private int posicion;
	
	//Variables para la Conexión a la Base de Datos//
	private ConexionDB db;
	private JugadorDB jdb;
	private Connection conexion;
	private boolean connected = false;
	private int numero_items;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		//Etiqueta Registro//
		JLabelRegistro = new JLabel("REGISTRO JUGADOR");
		JLabelRegistro.setForeground(new Color(0, 128, 128));
		JLabelRegistro.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 20));
		JLabelRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Etiqueta Nombre//
		JLabelNombre = new JLabel("NOMBRE");
		JLabelNombre.setFont(new Font("Tekton Pro", Font.BOLD, 14));
		//Campo Texto Nombre//
		JTextNombre = new JTextField();
		JTextNombre.setBackground(new Color(175, 238, 238));
		JTextNombre.setColumns(10);
		JTextNombre.addActionListener(new innerAL());//Agregamos el ActionListener desde la innerClass//
		JTextNombre.addKeyListener(new innerKL());//Agregamos el KeyListener desde la innerClass//
		
		//Etiqueta Apellido1//
		JLabelApellido1 = new JLabel("PRIMER APELLIDO");
		JLabelApellido1.setFont(new Font("Tekton Pro", Font.BOLD, 14));
		//Campo Texto Apellido1//
		JTextApellido1 = new JTextField();
		JTextApellido1.setBackground(new Color(175, 238, 238));
		JTextApellido1.setColumns(10);
		JTextApellido1.addActionListener(new innerAL());//Agregamos el ActionListener desde la innerClass//
		JTextApellido1.addKeyListener(new innerKL());//Agregamos el KeyListener desde la innerClass//
		
		//Etiqueta Apellido2//
		JLabelApellido2 = new JLabel("SEGUNDO APELLIDO");
		JLabelApellido2.setFont(new Font("Tekton Pro", Font.BOLD, 14));
		//Campo Texto Apellido2//
		JTextApellido2 = new JTextField();
		JTextApellido2.setBackground(new Color(175, 238, 238));
		JTextApellido2.setColumns(10);
		JTextApellido2.addActionListener(new innerAL());//Agregamos el ActionListener desde la innerClass//
		JTextApellido2.addKeyListener(new innerKL());//Agregamos el KeyListener desde la innerClass//
		
		//Etiqueta Edad//
		JLabelEdad = new JLabel("EDAD");
		JLabelEdad.setFont(new Font("Tekton Pro", Font.BOLD, 14));
		//Campo Texto Edad//
		JTextEdad = new JTextField();
		JTextEdad.setBackground(new Color(175, 238, 238));
		JTextEdad.setColumns(10);
		JTextEdad.addActionListener(new innerAL());//Agregamos el ActionListener desde la innerClass//
		JTextEdad.addKeyListener(new innerKL());//Agregamos el KeyListener desde la innerClass//
		
		//Etiqueta E-Mail//
		JLabelEmail = new JLabel("E-MAIL");
		JLabelEmail.setFont(new Font("Tekton Pro", Font.BOLD, 14));
		//Campo Texto E-Mail//
		JTextEmail = new JTextField();
		JTextEmail.setBackground(new Color(175, 238, 238));
		JTextEmail.setColumns(10);
		JTextEmail.addActionListener(new innerAL());//Agregamos el ActionListener desde la innerClass//
		JTextEmail.addKeyListener(new innerKL());//Agregamos el KeyListener desde la innerClass//
		
		//Etiqueta Género//
		JLabelGen = new JLabel("G\u00C9NERO");
		JLabelGen.setFont(new Font("Tekton Pro", Font.BOLD, 14));
		//ComboBox Género//
		cbGen = new JComboBox<Object>();
		cbGen.setBackground(new Color(175, 238, 238));
		cbGen.addItem("Hombre");
		cbGen.addItem("Mujer");
		cbGen.addActionListener(new innerAL());//Agregamos el ActionListener desde la innerClass//
	
		//Etiqueta Código//
		JLabelCode = new JLabel("ID JUEGO");
		JLabelCode.setFont(new Font("Tekton Pro", Font.BOLD, 14));
		//Campo Texto Código//
		JTextCode = new JTextField();
		JTextCode.setBackground(new Color(175, 238, 238));
		JTextCode.setColumns(10);
		JTextCode.setEditable(false);
		code();//Agregamos el Método creado especialmente para calcular el código de forma aleatoria//
		
		
		//Botón para Registrar Usuario//
		JButtonRegistro = new JButton("REGISTRARSE");
		JButtonRegistro.setForeground(new Color(255, 0, 0));
		JButtonRegistro.setFont(new Font("Stencil Std", Font.PLAIN, 11));
		JButtonRegistro.addActionListener(new innerAL());//Agregamos el ActionListener desde la innerClass//
		
		//Botón para Salir de la Aplicación//
		JButtonSalir = new JButton("SALIR ");
		JButtonSalir.addActionListener(new innerAL());//Agregamos el ActionListener desde la innerClass//
		
		//Definimos el ScrollPane y posteriormente agregamos un JTextArea para recoger los datos del Jugador//
		scrollPane = new JScrollPane();
		JTextArea = new JTextArea();
		JTextArea.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
		JTextArea.setBackground(new Color(204, 255, 153));
		JTextArea.setEditable(false);
		scrollPane.setViewportView(JTextArea);
		
		//Etiqueta Info para informarnos si el jugador se ha registrado correctamente//
		JLabelInfo = new JLabel("");
		JLabelInfo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelInfo.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		JLabelInfo.setForeground(new Color(255, 51, 51));
		
		//Botón para pasar al Juego MATHDICE//
		JButtonJugar = new JButton("JUGAR MATHDICE");
		JButtonJugar.setFont(new Font("Stencil", Font.PLAIN, 14));
		JButtonJugar.setEnabled(false);
		JButtonJugar.addActionListener(new innerAL());//Agregamos el ActionListener desde la innerClass//
		
		//Botón para Reiniciar Todos los Campos//
		JButtonUsuarios = new JButton("BUSCAR JUGADOR");
		JButtonUsuarios.setForeground(new Color(0, 0, 102));
		JButtonUsuarios.setFont(new Font("Stencil", Font.PLAIN, 12));
		JButtonUsuarios.addActionListener(new innerAL());//Agregamos el ActionListener desde la innerClass//
		
		//Combo Usuario//
		cbJugador = new JComboBox();
		cbJugador.addActionListener(new innerAL());//Agregamos el ActionListener desde la InnerClass//
		
		//Botón Reiniciar//
		JButtonReset = new JButton("REINICIAR");
		JButtonReset.addActionListener(new innerAL());//Agregamos el ActionListener desde la InnerClass//
		
		//Layout de la Ventana Registro//
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(JLabelRegistro, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(JButtonReset, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(JButtonSalir, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(2)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(JLabelCode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(JLabelEdad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(JLabelApellido1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
												.addComponent(JLabelApellido2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(JLabelEmail, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
												.addComponent(JLabelGen, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
												.addComponent(JLabelNombre, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(JTextNombre, Alignment.LEADING)
												.addComponent(cbGen, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(JTextEmail, Alignment.LEADING)
												.addComponent(JTextCode, Alignment.LEADING)
												.addComponent(JTextApellido2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
												.addComponent(JTextEdad, Alignment.LEADING)
												.addComponent(JTextApellido1, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(JButtonUsuarios, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(JButtonRegistro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
									.addGap(28)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(JButtonJugar, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
										.addComponent(JLabelInfo, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
										.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cbJugador, 0, 565, Short.MAX_VALUE)
							.addGap(7))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(JLabelRegistro, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(JTextNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(JLabelNombre))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(JLabelApellido1)
								.addComponent(JTextApellido1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(JLabelApellido2)
								.addComponent(JTextApellido2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(JLabelEdad)
								.addComponent(JTextEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(JTextEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(JLabelEmail))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbGen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(JLabelGen)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(JLabelCode)
								.addComponent(JTextCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addComponent(JButtonRegistro))
						.addComponent(JLabelInfo, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(JButtonUsuarios)
						.addComponent(JButtonJugar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbJugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(JButtonSalir)
						.addComponent(JButtonReset))
					.addGap(14))
		);
		contentPane.setLayout(gl_contentPane);
		conectar();
	}
	
	//Método para la Conexión//
	public void conectar(){
		//Datos Necesarios para la Conexión a la BBDD//
				db = new ConexionDB();
				//Establecemos la Conexión//
				connected=db.ConexionDB();
				//Asignamos con el getter la conexión establecida//
				conexion=db.getConexion();
				//Pasamos la Conexión a un Nuevo Jugador//
				jdb=new JugadorDB(conexion);
				//Comprobamos que la Conexión ha tenido Éxito//
				if(connected==false){
					System.out.println("Conectado a MySQL");
				}else{ 
					System.out.println("No estás Conectado");
				}
	}
	
	//Definimos el Método para Generar el Código interno del Jugador de manera aleatoria y alfanumérica//
	public void code(){	
		posicion=(int)(aleatorio.nextDouble() * alfa.length()-1+0);
		//Definimos la cantidad máxima de números aleatorios (99) y sumamos 100 para mantener 3 números cada vez//
		valor=(int)(aleatorio.nextDouble() * 99+100); 
		cadena=cadena+alfa.charAt(posicion)+valor;
			
		JTextCode.setText(cadena);//insertamos la clase en el JText para el código del juego//
		}
	
	
	//Generamos el Action Listener desde una InnerClass//
	//Una vez definidos deben ser declarados en la Clase Registro//
	public class innerAL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == JButtonSalir){
				System.exit(0);//Salimos de la Aplicación//
			}
			
			if(e.getSource() == JButtonRegistro){
				//Introducimos un condicional para asegurarnos que todos los campos han sido rellenados por el jugador//
				if((JTextNombre.getText().length()<=0) || (JTextApellido1.getText().length()<=0) 
					|| (JTextApellido2.getText().length()<=0) || (JTextEdad.getText().length()<=0)
					||(JTextEmail.getText().length()<=0)){
					JOptionPane.showMessageDialog(null, "Falta Algún Dato por Rellenar");//JOption 	ue muestra un mensaje//
				}else{
					//Registramos los datos del Jugador para pasarlos al JTextArea//
					p1.setNombre(JTextNombre.getText());
					p1.setApellido1(JTextApellido1.getText());
					p1.setApellido2(JTextApellido2.getText());
					p1.setEdad(Integer.parseInt(JTextEdad.getText().toString()));
					p1.setEmail(JTextEmail.getText());
					p1.setGenero(cbGen.getSelectedItem().toString());
					p1.setCode(JTextCode.getText().toString());

					
					JTextArea.setText("<<<Datos Jugador>>>\n"+p1);//Recogemos todos los datos del Jugador y los pasamos al JTextArea//
					JLabelInfo.setText("Jugador Registrado con Éxito");//Mensaje de que el Jugador ha sido registrado//
					JButtonJugar.setEnabled(true);
					JButtonUsuarios.setEnabled(false);
					JButtonRegistro.setEnabled(false);
					
					if(conexion != null){
						//Recogemos los Datos del Jugador para insertarlos en la BBDD de MySql//
						jdb.insertarUsuario(JTextNombre.getText(), JTextApellido1.getText(), 
								JTextApellido2.getText(), Integer.valueOf(JTextEdad.getText()), 
								JTextEmail.getText(), cbGen.getSelectedItem().toString(), 
								JTextCode.getText().toString(),p1.getPuntos());
					}else if(conexion == null){
						JLabelInfo.setText("Estas fuera de Conexión");
					}
					
				}
			}
			
			if(e.getSource()==JButtonJugar){
				try{
				v3.setVisible(true);//Al presionar el botón Jugar pasamos a la Ventana Juego//
				}catch (Exception error){
					error.getMessage();
				}
				try{
				p1.setNombre(JTextNombre.getText());//Pasamos el Nombre a la Ventana Juego y el resto a la ventana Perfil//
				p1.setApellido1(JTextApellido1.getText());
				p1.setApellido2(JTextApellido2.getText());
				p1.setEdad(Integer.parseInt(JTextEdad.getText().toString()));
				p1.setEmail(JTextEmail.getText());
				p1.setGenero(cbGen.getSelectedItem().toString());
				p1.setCode(JTextCode.getText().toString());
				v3.setJugador(p1);//Habilitamos al Jugador en la siguiente ventana//
				dispose();
				}catch (Exception evt){
					evt.getMessage();
				}
				
			}
			
			if(e.getSource()==JButtonUsuarios){
				cbJugador.removeAllItems();
					//Buscamos el Usuario por el Nombre y las Coincidencias quedan recogidas en un ComboBox//
					jdb.usuariosBox(JTextNombre.getText(),cbJugador);
					JLabelInfo.setText("Usuario Encontrado");
					numero_items=cbJugador.getItemCount();//Número de Items en el ComboBox///
					JTextArea.setText("Datos Registrados");
					
					//Método para Saber si el Usuario ya está registrado o no//
					if(numero_items==0){
						JTextNombre.setText("Usuario No Encontrado");
						JTextApellido1.setText("Usuario No Encontrado");
						JTextApellido2.setText("Usuario No Encontrado");
						JTextEdad.setText("Usuario No Encontrado");
						JTextEmail.setText("Usuario No Encontrado");
						cbGen.setSelectedItem("Usuario No Encontrado");
						JTextCode.setText("Usuario No Encontrado");
						JLabelInfo.setText("Vuelve a Buscar o Registrate");
						JButtonRegistro.setEnabled(false);
					}
			}
			
			//ActionListener Botón Reiniciar//
			if(e.getSource()== JButtonReset){
				JTextNombre.setText("");
				JTextApellido1.setText("");
				JTextApellido2.setText("");
				JTextEdad.setText("");
				JTextEmail.setText("");
				JTextCode.setText(cadena);
				cbGen.setSelectedItem("Hombre");
				cbJugador.removeAllItems();
				JLabelInfo.setText("");
				JTextArea.setText("");
				JButtonJugar.setEnabled(false);
				JButtonRegistro.setEnabled(true);
				JButtonUsuarios.setEnabled(true);
			}
			//ActionListener para el ComboBox//
			if(e.getSource()==cbJugador){
				p1=(Jugador)cbJugador.getSelectedItem();
				if (p1 !=null){
					JTextNombre.setText(p1.getNombre());
					JTextApellido1.setText(p1.getApellido1());
					JTextApellido2.setText(p1.getApellido2());
					JTextEdad.setText(String.valueOf(p1.getEdad()));
					JTextEmail.setText(p1.getEmail());
					cbGen.setSelectedItem(p1.getGenero());
					JTextCode.setText(p1.getCode());
					JButtonRegistro.setEnabled(false);
					JButtonJugar.setEnabled(true);
				}
			}
			
			//Habilitamos la tecla ENTER en los campos de texto para pasar al siguiente campo cuando lo presionamos//
			if(e.getSource() == JTextNombre){
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextApellido1.requestFocus();
			}else if(e.getSource() == JTextApellido1){
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextApellido2.requestFocus();
			}else if(e.getSource() == JTextApellido2){
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextEdad.requestFocus();
			}else if(e.getSource() == JTextEdad){
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextEmail.requestFocus();
			}else if(e.getSource() == JTextEmail){
				e.setSource((char)KeyEvent.VK_ENTER);
				cbGen.requestFocus();
			}else if(e.getSource() == cbGen){
				e.setSource((char)KeyEvent.VK_ENTER);
				JButtonRegistro.requestFocus();
			}
		}
		
	}
	
	//Generamos el KeyListener desde una InnerClass//
	public class innerKL implements KeyListener{
		public void keyPressed(KeyEvent arg0) {
		}
		public void keyReleased(KeyEvent e) {
		}
		public void keyTyped(KeyEvent e) {
			if(e.getSource() == JTextNombre){
				char c = e.getKeyChar();
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA,ACENTOS Y LA TECLA SPACE//
				if((c < 'a' || c > 'z' ) && (c < 'A' || c > 'Z') && (c !=KeyEvent.VK_SPACE)&& (c < '´')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 15 CARÁCTERES//
				if(JTextNombre.getText().length()==15) e.consume();
			}else if(e.getSource()==JTextApellido1){
				char c = e.getKeyChar();
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA,ACENTOS Y LA TECLA SPACE//
				if((c < 'a' || c > 'z' ) && (c < 'A' || c > 'Z') && (c !=KeyEvent.VK_SPACE) && (c < '´')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 20 CARÁCTERES//
				if(JTextApellido1.getText().length()==20) e.consume();
			}else if(e.getSource()==JTextApellido2){
				char c = e.getKeyChar();
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA,ACENTOS Y LA TECLA SPACE//
				if((c < 'a' || c > 'z' ) && (c < 'A' || c > 'Z') && (c !=KeyEvent.VK_SPACE) && (c < '´')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 20 CARÁCTERES//
				if(JTextApellido2.getText().length()==20) e.consume();
			}else if(e.getSource()==JTextEdad){
				char c = e.getKeyChar();
				//SOLO ADMITE NÚMEROS//
				if((c < '0' || c > '9')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 2 CARÁCTERES//
				if(JTextEdad.getText().length()==2) e.consume();
			}else if(e.getSource() == JTextEmail){
				//ADMITE TODO TIPO DE LETRAS,NÚMEROS Y CARACTERES Y LIMITAMOS EL TAMAÑO DEL TEXTO A 30 CARÁCTERES//
				if(JTextEmail.getText().length()==30) e.consume();
			}
		}
		
	}
}
