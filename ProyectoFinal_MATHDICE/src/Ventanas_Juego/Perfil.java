package Ventanas_Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import Jugador.Jugador;
import Modelo.ConexionDB;
import Modelo.JugadorDB;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class Perfil extends JPanel {
	
	//Variables contentPane,Etiquetas y Campos de Texto//
	private JPanel contentPane;
	private JTextField JTextNombre,JTextApellido1,JTextApellido2,JTextEdad,
	JTextCode,JTextMail,JTextGenero,JTextPuntos;
	private JLabel JLabelTitulo,JLabelPerfil1,JLabelNombre,JLabelApellidos,JLabelEdad,
	JLabelCode,JLabelMail,JLabelGenero,JLabelPuntos,JLabelDatosJugador,
	JLabelPerfil2,JLabelPerfil3;
	private JScrollPane scrollPane;
	private JButton JButtonSalir,JButtonActualizar;
	private JTextPane JTextPane;
	
	//Declaramos al Jugador//
	private Jugador p1;
	
	//Variable Ventana Juego//
	private Juego v2;
	
	//Variable para Actualizar la BBDD//
	private JugadorDB jdb;
	private ConexionDB db;
	private Connection conexion;
	private boolean connected = false;
	
	public Perfil() {
		setBackground(new Color(152, 251, 152));
		setBounds(100, 100, 850, 650);
		contentPane = this;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		jdb = new JugadorDB(conexion);//Inicializamos el Jugador en la BBDD//
		
		JLabelTitulo = new JLabel("PERFIL MATHDICE");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelTitulo, 10, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelTitulo, 349, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelTitulo, 794, SpringLayout.WEST, this);
		JLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelTitulo.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		contentPane.add(JLabelTitulo);
		
		//Etiqueta Nombre//
		JLabelNombre = new JLabel("NOMBRE");
		JLabelNombre.setFont(new Font("Sitka Text", Font.BOLD, 12));
		contentPane.add(JLabelNombre);
		
		//Campo de Texto para el Nombre//
		JTextNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelNombre, -16, SpringLayout.NORTH, JTextNombre);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelNombre, -6, SpringLayout.NORTH, JTextNombre);
		JTextNombre.setForeground(new Color(0, 0, 0));
		JTextNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		JTextNombre.setBackground(new Color(255, 255, 153));
		contentPane.add(JTextNombre);
		JTextNombre.setColumns(10);
		JTextNombre.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta Apellidos//
		JLabelApellidos = new JLabel("APELLIDOS");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JTextNombre, -58, SpringLayout.NORTH, JLabelApellidos);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JTextNombre, -35, SpringLayout.NORTH, JLabelApellidos);
		JLabelApellidos.setFont(new Font("Sitka Text", Font.BOLD, 12));
		contentPane.add(JLabelApellidos);
		
		//Campo de Texto para Apellido1//
		JTextApellido1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelApellidos, -21, SpringLayout.NORTH, JTextApellido1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelApellidos, -6, SpringLayout.NORTH, JTextApellido1);
		JTextApellido1.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.WEST, JTextApellido1, 132, SpringLayout.WEST, this);
		JTextApellido1.setBackground(new Color(255, 255, 153));
		contentPane.add(JTextApellido1);
		JTextApellido1.setColumns(10);
		JTextApellido1.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta Imagen1//
		JLabelPerfil1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelApellidos, 9, SpringLayout.EAST, JLabelPerfil1);
		sl_contentPane.putConstraint(SpringLayout.WEST, JTextNombre, 9, SpringLayout.EAST, JLabelPerfil1);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelNombre, 9, SpringLayout.EAST, JLabelPerfil1);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelPerfil1, 10, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelPerfil1, 123, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelPerfil1, 27, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelPerfil1, 161, SpringLayout.NORTH, this);
		JLabelPerfil1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPerfil1.setIcon(new ImageIcon(Perfil.class.getResource("/imagenesApp/manc.png")));
		contentPane.add(JLabelPerfil1);
		
		//Campo de Texto para Apellido2//
		JTextApellido2 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, JTextApellido1, -29, SpringLayout.NORTH, JTextApellido2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JTextApellido1, -6, SpringLayout.NORTH, JTextApellido2);
		JTextApellido2.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.WEST, JTextApellido2, 132, SpringLayout.WEST, this);
		JTextApellido2.setBackground(new Color(255, 255, 153));
		contentPane.add(JTextApellido2);
		JTextApellido2.setColumns(10);
		JTextApellido2.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta Edad//
		JLabelEdad = new JLabel("EDAD");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JTextApellido2, -66, SpringLayout.NORTH, JLabelEdad);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JTextApellido2, -43, SpringLayout.NORTH, JLabelEdad);
		JLabelEdad.setFont(new Font("Sitka Text", Font.BOLD, 12));
		contentPane.add(JLabelEdad);
		
		//Campo de Texto para Edad//
		JTextEdad = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelEdad, -21, SpringLayout.NORTH, JTextEdad);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelEdad, -6, SpringLayout.NORTH, JTextEdad);
		JTextEdad.setFont(new Font("Tahoma", Font.BOLD, 11));
		JTextEdad.setBackground(new Color(255, 255, 153));
		contentPane.add(JTextEdad);
		JTextEdad.setColumns(10);
		JTextEdad.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta ID//
		JLabelCode = new JLabel("ID");
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelEdad, -22, SpringLayout.WEST, JLabelCode);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelCode, 221, SpringLayout.WEST, this);
		JLabelCode.setFont(new Font("Sitka Text", Font.BOLD, 12));
		contentPane.add(JLabelCode);
		
		//Campo de Texto Code//
		JTextCode = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelCode, -21, SpringLayout.NORTH, JTextCode);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelCode, -6, SpringLayout.NORTH, JTextCode);
		sl_contentPane.putConstraint(SpringLayout.EAST, JTextEdad, -22, SpringLayout.WEST, JTextCode);
		JTextCode.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.EAST, JTextCode, 292, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, JTextCode, 221, SpringLayout.WEST, this);
		JTextCode.setBackground(new Color(255, 255, 153));
		JTextCode.setEditable(false);
		contentPane.add(JTextCode);
		JTextCode.setColumns(10);
		
		//Etiqueta Mail//
		JLabelMail = new JLabel("E-MAIL");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JTextCode, -93, SpringLayout.NORTH, JLabelMail);
		sl_contentPane.putConstraint(SpringLayout.NORTH, JTextEdad, -93, SpringLayout.NORTH, JLabelMail);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JTextCode, -70, SpringLayout.NORTH, JLabelMail);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JTextEdad, -70, SpringLayout.NORTH, JLabelMail);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelMail, 132, SpringLayout.WEST, this);
		JLabelMail.setFont(new Font("Sitka Text", Font.BOLD, 12));
		contentPane.add(JLabelMail);
		
		//Campo de Texto para E-Mail//
		JTextMail = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelMail, -16, SpringLayout.NORTH, JTextMail);
		JTextMail.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelMail, -6, SpringLayout.NORTH, JTextMail);
		sl_contentPane.putConstraint(SpringLayout.WEST, JTextMail, 130, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, JTextMail, 298, SpringLayout.WEST, this);
		JTextMail.setBackground(new Color(255, 255, 153));
		contentPane.add(JTextMail);
		JTextMail.setColumns(10);
		JTextMail.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta Genero//
		JLabelGenero = new JLabel("GENERO");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JTextMail, -72, SpringLayout.NORTH, JLabelGenero);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JTextMail, -49, SpringLayout.NORTH, JLabelGenero);
		JLabelGenero.setFont(new Font("Sitka Text", Font.BOLD, 12));
		contentPane.add(JLabelGenero);
		
		//Campo de Texto para Genero//
		JTextGenero = new JTextField();
		JTextGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelGenero, -21, SpringLayout.NORTH, JTextGenero);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelGenero, -6, SpringLayout.NORTH, JTextGenero);
		JTextGenero.setBackground(new Color(255, 255, 153));
		contentPane.add(JTextGenero);
		JTextGenero.setColumns(10);
		JTextGenero.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta Puntos//
		JLabelPuntos = new JLabel("PUNTOS");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JTextGenero, -91, SpringLayout.NORTH, JLabelPuntos);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JTextGenero, -68, SpringLayout.NORTH, JLabelPuntos);
		JLabelPuntos.setFont(new Font("Sitka Text", Font.BOLD, 12));
		contentPane.add(JLabelPuntos);
		
		//Campo de Texto para los Puntos//
		JTextPuntos = new JTextField();
		JTextPuntos.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelPuntos, -16, SpringLayout.NORTH, JTextPuntos);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelPuntos, -6, SpringLayout.NORTH, JTextPuntos);
		sl_contentPane.putConstraint(SpringLayout.NORTH, JTextPuntos, -54, SpringLayout.SOUTH, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JTextPuntos, -32, SpringLayout.SOUTH, this);
		JTextPuntos.setBackground(new Color(255, 255, 153));
		JTextPuntos.setForeground(Color.BLACK);
		JTextPuntos.setEditable(false);
		contentPane.add(JTextPuntos);
		JTextPuntos.setColumns(10);
		
		//Etiqueta Datos Jugador//
		JLabelDatosJugador = new JLabel("DATOS JUGADOR");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelDatosJugador, 58, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelNombre, -54, SpringLayout.WEST, JLabelDatosJugador);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelTitulo, -25, SpringLayout.NORTH, JLabelDatosJugador);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelDatosJugador, 0, SpringLayout.WEST, JLabelTitulo);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelDatosJugador, 445, SpringLayout.WEST, JLabelTitulo);
		JLabelDatosJugador.setForeground(new Color(0, 0, 255));
		JLabelDatosJugador.setFont(new Font("Stencil Std", Font.PLAIN, 14));
		JLabelDatosJugador.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(JLabelDatosJugador);
		
		//Panel donde situamos la barra de scroll//
		scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 92, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelDatosJugador, -11, SpringLayout.NORTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelApellidos, -59, SpringLayout.WEST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, JTextNombre, -51, SpringLayout.WEST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelCode, -57, SpringLayout.WEST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, JTextApellido2, -51, SpringLayout.WEST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, JTextApellido1, -51, SpringLayout.WEST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 794, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 349, SpringLayout.WEST, this);
		contentPane.add(scrollPane);
		
		//Area de Texto para Datos//
		JTextPane = new JTextPane();
		JTextPane.setBackground(new Color(204, 255, 204));
		JTextPane.setEditable(false);
		JTextPane.setFont(new Font("Tekton Pro Ext", Font.BOLD, 16));
		scrollPane.setViewportView(JTextPane);
		
		//Botón para Actualizar el Perfil//
		JButtonActualizar = new JButton("ACTUALIZAR PERFIL");
		sl_contentPane.putConstraint(SpringLayout.EAST, JTextPuntos, -54, SpringLayout.WEST, JButtonActualizar);
		sl_contentPane.putConstraint(SpringLayout.NORTH, JButtonActualizar, -1, SpringLayout.NORTH, JTextPuntos);
		sl_contentPane.putConstraint(SpringLayout.WEST, JButtonActualizar, 0, SpringLayout.WEST, JLabelTitulo);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JButtonActualizar, -29, SpringLayout.SOUTH, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, JButtonActualizar, 517, SpringLayout.WEST, this);
		JButtonActualizar.setFont(new Font("Stencil", Font.PLAIN, 13));
		add(JButtonActualizar);
		JButtonActualizar.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Botón para Salir de la Aplicación//
		JButtonSalir = new JButton("SALIR");
		sl_contentPane.putConstraint(SpringLayout.NORTH, JButtonSalir, -54, SpringLayout.SOUTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, JButtonSalir, -182, SpringLayout.EAST, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JButtonSalir, -29, SpringLayout.SOUTH, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, JButtonSalir, -46, SpringLayout.EAST, this);
		contentPane.add(JButtonSalir);
		JButtonSalir.addActionListener(new innerAL()); //Añadimos el ActionListener desde la InnerClass//
		
		JLabelPerfil2 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelEdad, 14, SpringLayout.EAST, JLabelPerfil2);
		sl_contentPane.putConstraint(SpringLayout.WEST, JTextEdad, 14, SpringLayout.EAST, JLabelPerfil2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelPerfil2, 58, SpringLayout.SOUTH, JLabelPerfil1);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelPerfil2, 10, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelPerfil2, 118, SpringLayout.WEST, this);
		JLabelPerfil2.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPerfil2.setIcon(new ImageIcon(Perfil.class.getResource("/imagenesApp/mujer.png")));
		add(JLabelPerfil2);
		
		JLabelPerfil3 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelPuntos, 9, SpringLayout.EAST, JLabelPerfil3);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelGenero, 9, SpringLayout.EAST, JLabelPerfil3);
		sl_contentPane.putConstraint(SpringLayout.WEST, JTextPuntos, 9, SpringLayout.EAST, JLabelPerfil3);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelPerfil2, -60, SpringLayout.NORTH, JLabelPerfil3);
		sl_contentPane.putConstraint(SpringLayout.EAST, JTextGenero, 175, SpringLayout.EAST, JLabelPerfil3);
		sl_contentPane.putConstraint(SpringLayout.WEST, JTextGenero, 9, SpringLayout.EAST, JLabelPerfil3);
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelPerfil3, 428, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelPerfil3, -28, SpringLayout.SOUTH, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelPerfil3, 123, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelPerfil3, 15, SpringLayout.WEST, this);
		JLabelPerfil3.setIcon(new ImageIcon(Perfil.class.getResource("/imagenesApp/hombre.png")));
		JLabelPerfil3.setHorizontalAlignment(SwingConstants.CENTER);
		add(JLabelPerfil3);
		
		JLabel JLabelImagen1 = new JLabel("");
		JLabelImagen1.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -22, SpringLayout.NORTH, JLabelImagen1);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelPuntos, -65, SpringLayout.WEST, JLabelImagen1);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelGenero, -80, SpringLayout.WEST, JLabelImagen1);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelMail, -52, SpringLayout.WEST, JLabelImagen1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, JLabelImagen1, 345, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, JLabelImagen1, -5, SpringLayout.NORTH, JButtonActualizar);
		sl_contentPane.putConstraint(SpringLayout.EAST, JLabelImagen1, -47, SpringLayout.EAST, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, JLabelImagen1, -485, SpringLayout.EAST, this);
		JLabelImagen1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelImagen1.setIcon(new ImageIcon(Perfil.class.getResource("/imagenesApp/dados.png")));
		add(JLabelImagen1);
		
	}
	
	//Obtenemos los Datos del Jugador//
	public void setJugador(Jugador p1, Juego v2){
			this.p1=p1;
			this.v2=v2;
			JTextNombre.setText(p1.getNombre());
			JTextApellido1.setText(p1.getApellido1());
			JTextApellido2.setText(p1.getApellido2());
			JTextEdad.setText(String.valueOf(p1.getEdad()));
			JTextCode.setText(String.valueOf(p1.getCode()));
			JTextMail.setText(p1.getEmail());
			JTextGenero.setText(p1.getGenero());
			JTextPuntos.setText(String.valueOf(p1.getPuntos()));
			}
		
		//Método para Recibir los Puntos de la Ventana Juego//
		public void setPuntos(int puntos){
			p1.setPuntos(puntos);
			JTextPuntos.setText(String.valueOf(p1.getPuntos()));
		
		}
	
	//Definimos el ActionListener de los Campos de Texto y Botones a través de la InnerClass//
	public class innerAL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == JTextNombre){
				e.setSource((char)KeyEvent.VK_ENTER);//Al presionar la tecla ENTER pasamos al siguiente campo//
				JTextApellido1.requestFocus();
			}else if(e.getSource() == JTextApellido1){
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextApellido2.requestFocus();
			}else if(e.getSource() == JTextApellido2){
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextEdad.requestFocus();
			}else if(e.getSource() == JTextEdad){
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextMail.requestFocus();
			}else if(e.getSource() == JTextMail){
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextGenero.requestFocus();
			}
			
			if(e.getSource()==JButtonActualizar){
				p1.getId();
				p1.getPuntos();
				p1.setNombre(JTextNombre.getText());
				p1.setApellido1(JTextApellido1.getText());
				p1.setApellido2(JTextApellido2.getText());  
				p1.setEdad(Integer.valueOf(JTextEdad.getText()));
				p1.setCode(String.valueOf(JTextCode.getText()));
				p1.setEmail(JTextMail.getText());
				p1.setGenero(JTextGenero.getText());
				JTextPane.setText("*****Perfil Actualizado Correctamente*****\n"+p1);
				//Pasamos el Nombre del Jugador Actualizado a Ventana Juego
				//mediante el método creado en esta ventana y el de la clase juego//
				v2.setNombre(p1.getNombre());

				jdb.actualizarUsuario(conexion,p1);//Nos permite actualizar el Perfil del jugador en la BBDD//
			}
			
			if(e.getSource()== JButtonSalir){
				System.exit(0); //Acción para cerrar la Aplicación//
			}
		}
		
	}
}
