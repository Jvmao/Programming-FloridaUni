package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import Juego.Jugador;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;

public class Perfil extends JPanel {
	
	//Almacenamos al Jugador//
	private Jugador p1;

	//Variable Ventana Juego//
	private Juego v2;
	
	//Declaración de Variables//
	private JLabel JLabelFoto1;
	private JLabel JLabelNombre,JLabelApellido1, JLabelApellido2, 
	JLabelEdad, JLabelID, JLabelGenero, JLabelPuntos,
	JLabelPerfil1,JLabelPerfil2,JLabelPerfil3,JLabelDatos;
	private JTextField JTextNombre, JTextApellido1 , JTextApellido2, 
	JTextEdad, JTextID, JTextGenero, JTextPuntos;
	private JButton JButtonDatos, JButtonSalir;
	private JTextPane JPaneDatos;
	
	
	
	
	public Perfil() {
		setBackground(new Color(255, 255, 102));
		//setLocale("Perfil Jugador");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 900, 600);
		
		//Objeto para la clase Jugador//
		p1 = new Jugador();
		
		//Etiqueta Título//
		JLabelPerfil1 = new JLabel("DATOS PERFIL JUGADOR");
		JLabelPerfil1.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		
		//Etiqueta Foto Perfil//
		JLabelFoto1 = new JLabel("");
		JLabelFoto1.setIcon(new ImageIcon(Perfil.class.getResource("/imagenes/hombre.png")));
		
		//Etiqueta y Campo de Texto Para Nombre//
		JLabelNombre = new JLabel("NOMBRE");
		JLabelNombre.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		JTextNombre = new JTextField();
		JTextNombre.setColumns(10);
		
		//Etiqueta y Campo de Texto Para Apellido1//
		JLabelApellido1 = new JLabel("APELLIDO1");
		JLabelApellido1.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		JTextApellido1 = new JTextField();
		JTextApellido1.setColumns(10);
		
		//Etiqueta y Campo de Texto Para Apellido2//
		JLabelApellido2 = new JLabel("APELLIDO2");
		JLabelApellido2.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		JTextApellido2 = new JTextField();
		JTextApellido2.setColumns(10);
		
		//Etiqueta y Campo de Texto Para Edad//
		JLabelEdad = new JLabel("EDAD");
		JLabelEdad.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		JTextEdad = new JTextField();
		JTextEdad.setColumns(10);
		
		//Etiqueta y Campo de Texto Para ID//
		JLabelID = new JLabel("ID");
		JLabelID.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		JTextID = new JTextField();
		JTextID.setEditable(false);
		JTextID.setColumns(10);
		
		//Etiqueta y Campo de Texto para Género//
		JLabelGenero = new JLabel("GÉNERO");
		JLabelGenero.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		JTextGenero = new JTextField();
		JTextGenero.setColumns(10);
		
		//Etiqueta y Campo de Texto para Puntos//
		JLabelPuntos = new JLabel("PUNTOS");
		JLabelPuntos.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		JTextPuntos = new JTextField();
		JTextPuntos.setEditable(false);
		JTextPuntos.setColumns(10);
		
		//Botón para Actualizar Datos//
		JButtonDatos = new JButton("ACTUALIZAR DATOS");
		JButtonDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p1.setNombre(JTextNombre.getText());
				p1.setApellido1(JTextApellido1.getText());
				p1.setApellido2(JTextApellido2.getText());  
				p1.setEdad(Integer.valueOf(JTextEdad.getText()));
				p1.setId(Integer.valueOf(JTextID.getText()));
				p1.setGenero(JTextGenero.getText());
				JPaneDatos.setText("Perfil Actualizado Correctamente:\n"+p1);
				//Pasamos el Nombre del Jugador Actualizado a Ventana Juego
				//mediante el método creado en esta ventana y el de la clase juego//
				v2.setNombre(p1.getNombre());
			}
		});
		JButtonDatos.setForeground(Color.BLUE);
		JButtonDatos.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		
		//Etiqueta Datos//
		JLabelDatos = new JLabel("DATOS");
		JLabelDatos.setForeground(Color.BLUE);
		JLabelDatos.setFont(new Font("Stencil", Font.PLAIN, 18));
		JLabelDatos.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Panel para Recoger los Datos Actualizados//
		JPaneDatos = new JTextPane();
		JPaneDatos.setBackground(new Color(204, 255, 204));
		JPaneDatos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
		JPaneDatos.setEditable(false);
		
		//Botón Salir//
		JButtonSalir = new JButton("Salir");
		JButtonSalir.setForeground(Color.DARK_GRAY);
		JButtonSalir.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		JButtonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); //Acción para Cerrar Todas las Ventanas y Salir de la Aplicación//
			}
		});
		
		//Iconos Jugador//
		JLabelPerfil3 = new JLabel("");
		JLabelPerfil3.setIcon(new ImageIcon(Perfil.class.getResource("/imagenes/manc.png")));
		
		JLabelPerfil2 = new JLabel("");
		JLabelPerfil2.setIcon(new ImageIcon(Perfil.class.getResource("/imagenes/mujer.png")));
		
		
		//Características del GroupLayOut//
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(JLabelPerfil1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(JLabelPerfil2, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(8)
									.addComponent(JLabelPerfil3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(JLabelFoto1, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
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
										.addComponent(JTextApellido1, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addComponent(JTextNombre, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addComponent(JTextID, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addComponent(JTextEdad, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addComponent(JTextGenero, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addComponent(JTextPuntos, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(JButtonSalir, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(64)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(JPaneDatos, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
								.addComponent(JLabelDatos, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))))
					.addGap(68))
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
					.addGap(33)
					.addComponent(JButtonSalir)
					.addGap(83))
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
		JTextPuntos.setText(String.valueOf(p1.getPuntos()));
		}
	
	//Método para Recibir los Puntos de la Ventana Juego//
	public void setPuntos(int puntos){
		p1.setPuntos(puntos);
		JTextPuntos.setText(String.valueOf(p1.getPuntos()));
	}
	
}
