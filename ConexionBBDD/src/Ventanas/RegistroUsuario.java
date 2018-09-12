package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import Modelo.ConexionDB;
import Modelo.UsuariosDB;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class RegistroUsuario extends JFrame {
	
	//Contenedor Principal BorderLayout//
	private JPanel contentPane;
	//Contenedor de los Campos de Registro//
	private JPanel campos;
	//Contenedor del Botón de Registro//
	private JPanel registro;
	
	
	//Variables de los Campos del JPanel//
	private JLabel labelNombre,labelApellido1,labelApellido2,labelEdad;
	private JTextField JtextNombre;
	private JTextField JtextApellido1;
	private JTextField JtextApellido2;
	private JTextField JtextEdad;
	private JButton btnRegistro;
	private JMenuBar menuBar;
	private JMenu mnLista, mnInformacion;
	private JMenuItem mntmUsuario;
	
	//Manejadores de la BBDD//
	private ConexionDB db;
	private UsuariosDB udb;
	private Connection conexion;
	private boolean connected = false;
	
	

	public RegistroUsuario() {
		
		//Características JFrame//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Barra Menú//
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Item desplegable//
		mnLista = new JMenu("Lista");
		menuBar.add(mnLista);
		
		//Item desplegable//
		mnInformacion = new JMenu("Información");
		menuBar.add(mnInformacion);
		
		//Item desplegable dentro de Lista//
		mntmUsuario = new JMenuItem("Usuario");
		mnLista.add(mntmUsuario);
		
		
	
		
		//Nombre//
		labelNombre = new JLabel("NOMBRE");
		labelNombre.setBounds(10, 11, 70, 14);
		contentPane.add(labelNombre);
		
		JtextNombre = new JTextField();
		JtextNombre.setBounds(90, 8, 334, 20);
		contentPane.add(JtextNombre);
		JtextNombre.setColumns(10);
		
		//Apellido1//
		labelApellido1 = new JLabel("APELLIDO1");
		labelApellido1.setBounds(10, 46, 79, 14);
		contentPane.add(labelApellido1);
		
		JtextApellido1 = new JTextField();
		JtextApellido1.setBounds(90, 43, 334, 20);
		contentPane.add(JtextApellido1);
		JtextApellido1.setColumns(10);
		
		
		//Apellido2//
		labelApellido2 = new JLabel("APELLIDO2");
		labelApellido2.setBounds(10, 86, 79, 14);
		contentPane.add(labelApellido2);
		
		JtextApellido2 = new JTextField();
		JtextApellido2.setBounds(90, 83, 334, 20);
		contentPane.add(JtextApellido2);
		JtextApellido2.setColumns(10);
		
		
		//Edad//
		labelEdad = new JLabel("EDAD");
		labelEdad.setBounds(10, 123, 46, 14);
		contentPane.add(labelEdad);
		
		JtextEdad = new JTextField();
		JtextEdad.setBounds(90, 120, 334, 20);
		contentPane.add(JtextEdad);
		JtextEdad.setColumns(10);
		
		
		//Botón//
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(335, 206, 89, 23);
		contentPane.add(btnRegistro);
		
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				udb.insertarUsuario(JtextNombre.getText(), JtextApellido1.getText(), 
						JtextApellido2.getText(), Integer.valueOf(JtextEdad.getText()));
			}
		});
		
		//Objeto para Manejar los Datos//
		db=new ConexionDB("localhost","usuarios","root","Naizuore1x");
		//Establecemos la Conexión//
		connected=db.connectDB();
		//Asignamos con el getter la conexión establecida//
		conexion=db.getConexion();
		//Pasamos la Conexión a un Nuevo Usuario//
		udb=new UsuariosDB(conexion);
		
		//Comprobamos que la Conexión ha tenido Éxito//
		if(connected==false){
			System.out.println("EXITO EN LA CONEXIÓN");
		}else System.out.println("SIN EXITO EN LA CONEXIÓN");
	}
}
