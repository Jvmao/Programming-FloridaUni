package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import Modelo.ConexionDB;
import Modelo.Usuario;
import Modelo.UsuariosDB;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarUsuarioBBDD extends JFrame {

	private JPanel contentPane;
	private JTextField JTextFieldNombre,JTextFieldApellido1,JTextFieldApellido2,JTextFieldEdad;
	private JComboBox<String> comboBoxUsuario;
	private JLabel JLabelNombre,JLabelApellido1,JLabelApellido2,JLabelEdad;
	private JButton btnBuscar;
	
	//Manejadores BBDD//
	private ConexionDB db;
	private UsuariosDB udb;
	private Connection conexion;
	private boolean connected = false;
	
	//Número de Elementos en el ComboBox//
	private int numero_de_items;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarUsuarioBBDD frame = new BuscarUsuarioBBDD();
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
	public BuscarUsuarioBBDD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		comboBoxUsuario = new JComboBox();
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u=(Usuario)comboBoxUsuario.getSelectedItem();
				if (u !=null){
					JTextFieldNombre.setText(u.getNombre());
					JTextFieldApellido1.setText(u.getApellido1());
					JTextFieldApellido2.setText(u.getApellido2());
					JTextFieldEdad.setText(String.valueOf(u.getEdad()));
				}
			}
		});
		GridBagConstraints gbc_comboBoxUsuario = new GridBagConstraints();
		gbc_comboBoxUsuario.gridwidth = 11;
		gbc_comboBoxUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxUsuario.fill = GridBagConstraints.BOTH;
		gbc_comboBoxUsuario.gridx = 0;
		gbc_comboBoxUsuario.gridy = 0;
		contentPane.add(comboBoxUsuario, gbc_comboBoxUsuario);
		
		JLabelNombre = new JLabel("NOMBRE");
		JLabelNombre.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 14));
		JLabelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_JLabelNombre = new GridBagConstraints();
		gbc_JLabelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_JLabelNombre.fill = GridBagConstraints.BOTH;
		gbc_JLabelNombre.gridx = 0;
		gbc_JLabelNombre.gridy = 2;
		contentPane.add(JLabelNombre, gbc_JLabelNombre);
		
		
		JTextFieldNombre = new JTextField();
		GridBagConstraints gbc_JTextFieldNombre = new GridBagConstraints();
		gbc_JTextFieldNombre.gridwidth = 7;
		gbc_JTextFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_JTextFieldNombre.fill = GridBagConstraints.BOTH;
		gbc_JTextFieldNombre.gridx = 1;
		gbc_JTextFieldNombre.gridy = 2;
		contentPane.add(JTextFieldNombre, gbc_JTextFieldNombre);
		JTextFieldNombre.setColumns(10);
		
		JLabelApellido1 = new JLabel("APELLIDO 1");
		JLabelApellido1.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 14));
		JLabelApellido1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_JLabelApellido1 = new GridBagConstraints();
		gbc_JLabelApellido1.fill = GridBagConstraints.BOTH;
		gbc_JLabelApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_JLabelApellido1.gridx = 0;
		gbc_JLabelApellido1.gridy = 3;
		contentPane.add(JLabelApellido1, gbc_JLabelApellido1);
		
		JTextFieldApellido1 = new JTextField();
		GridBagConstraints gbc_JTextFieldApellido1 = new GridBagConstraints();
		gbc_JTextFieldApellido1.gridwidth = 7;
		gbc_JTextFieldApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_JTextFieldApellido1.fill = GridBagConstraints.BOTH;
		gbc_JTextFieldApellido1.gridx = 1;
		gbc_JTextFieldApellido1.gridy = 3;
		contentPane.add(JTextFieldApellido1, gbc_JTextFieldApellido1);
		JTextFieldApellido1.setColumns(10);
		
		JLabelApellido2 = new JLabel("APELLIDO 2");
		JLabelApellido2.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 14));
		JLabelApellido2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_JLabelApellido2 = new GridBagConstraints();
		gbc_JLabelApellido2.fill = GridBagConstraints.BOTH;
		gbc_JLabelApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_JLabelApellido2.gridx = 0;
		gbc_JLabelApellido2.gridy = 4;
		contentPane.add(JLabelApellido2, gbc_JLabelApellido2);
		
		JTextFieldApellido2 = new JTextField();
		GridBagConstraints gbc_JTextFieldApellido2 = new GridBagConstraints();
		gbc_JTextFieldApellido2.gridwidth = 7;
		gbc_JTextFieldApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_JTextFieldApellido2.fill = GridBagConstraints.BOTH;
		gbc_JTextFieldApellido2.gridx = 1;
		gbc_JTextFieldApellido2.gridy = 4;
		contentPane.add(JTextFieldApellido2, gbc_JTextFieldApellido2);
		JTextFieldApellido2.setColumns(10);
		
		JLabelEdad = new JLabel("EDAD");
		JLabelEdad.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 14));
		JLabelEdad.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.fill = GridBagConstraints.BOTH;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 5;
		contentPane.add(JLabelEdad, gbc_lblEdad);
		
		JTextFieldEdad = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 7;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		contentPane.add(JTextFieldEdad, gbc_textField);
		JTextFieldEdad.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxUsuario.removeAllItems(); //Se Vacian los Items Anteriores//
				
				//Conexión con la BBDD//
				Conectar();
				
				//Buscamos el Usuario por el Nombre y las Coincidencias quedan recogidas en un ComboBox//
				udb.buscarUsuario(JTextFieldNombre.getText(), comboBoxUsuario);
				
				numero_de_items=comboBoxUsuario.getItemCount();//Número de Items en el ComboBox///
				
				//Método para Saber si el Usuario ya está registrado o no//
				if(numero_de_items==0){
					JTextFieldApellido1.setText("Usuario No Encontrado");
					JTextFieldApellido2.setText("Usuario No Encontrado");
					JTextFieldEdad.setText("Usuario No Encontrado");
				}
			}
		});
		btnBuscar.setFont(new Font("Trajan Pro", Font.BOLD | Font.ITALIC, 14));
		btnBuscar.setBackground(Color.ORANGE);
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridwidth = 7;
		gbc_btnBuscar.fill = GridBagConstraints.BOTH;
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 8;
		contentPane.add(btnBuscar, gbc_btnBuscar);
	}
	
	//Método para Conectar con la BBDD//
	private void Conectar(){
		//Objeto para el Manejo de la BBDD//
		db = new ConexionDB("localhost","usuarios","root","Naizuore1x");
		//Establecemos la Conexión//
		connected=db.connectDB();
		//Asignamos con el Getter la Conexión Establecida//
		conexion=db.getConexion();
		//Pasamos la Conexión a un Número Objeto UsuariosDB para Insertar Datos//
		udb=new UsuariosDB(conexion);
	}
}
