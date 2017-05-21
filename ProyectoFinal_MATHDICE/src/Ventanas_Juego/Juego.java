package Ventanas_Juego;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import Jugador.Jugador;
import Modelo.ConexionDB;
import Modelo.JugadorDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Juego extends JPanel {

	private JPanel contentPane;
	//Inicializamos un Nuevo Jugador//
	private Jugador p1;
	//Variables Ventana//
	private Registro v1;
	private Perfil v4;
	
	//Variable para Actualizar la BBDD//
	private JugadorDB jdb;
	private ConexionDB db;
	private Connection conexion;
	private boolean connected = false;

	//Declaramos las Variables de JLabel,JText y JButton//
	private JLabel JLabelDado1,JLabelDado2,JLabelDado3,JLabelDado4,
	JLabelDado5,JLabelDado6,JLabelNombreP1,JLabelPuntos,JLabelImagen1,JLabelImagen2,
	JLabelOperacion,JLabelResultado;
	private JButton JButtonSumar,JButtonRestar,JButtonMathDice,JButtonReinicio,JButtonSalir;
	private JTextField JTextOperaciones;

	//Declaramos el Objeto Random//
	private Random dado = new Random();
	//----Array y Almacenamiento de los Números Aleatorios para los dados de 3 caras---//
	private ImageIcon[] dados3 = new ImageIcon[3];
	private int[] numerosAlmacenadosDados3 = new int [3];
	//--------------------------------------------------------------------------------//
		
	//----Array y Almacenamiento de los Números Aleatorios para los dados de 6 caras---//
	private ImageIcon[] dados6 = new ImageIcon[6];
	private int[] numerosAlmacenadosDados6 = new int [2];
	//--------------------------------------------------------------------------------//
		
	//----Array y Almacenamiento de los Números Aleatorios para los dados de 12 caras---//
	private ImageIcon[] dados12 = new ImageIcon[12];
	private int numerosAlmacenadosDados12;
	//--------------------------------------------------------------------------------//
		
	//Creamos la Variable para el DadoGris//
	private ImageIcon dadogris = new ImageIcon(getClass().getResource("/imagenesApp/dadogris.png"));
	
	//Variable Boolean para tocaNumero y esSuma y así poder utilizar semáforos//
	private boolean tocaNumero = true; 
	private boolean esSuma = true; 
	//Variables int para realizar las operaciones//
	private int numerosIntroducidos=0;
	private int operacion=0;
	private int suma;//Variable para hacer las sumas//
	private int resta;//Variable para hacer las Restas//


	public Juego() {
		setBounds(100, 100, 850, 650);
		contentPane=this;
		contentPane.setBackground(new Color(255, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setLayout(null);
		
		//Etiqueta Nombre//
		JLabelNombreP1 = new JLabel(" "+p1);
		JLabelNombreP1.setFont(new Font("Trajan Pro", Font.BOLD, 18));
		JLabelNombreP1.setBounds(10, 10, 375, 27);
		contentPane.add(JLabelNombreP1);
		
		//Imagen Jugador1//
		JLabelImagen1 = new JLabel("");
		JLabelImagen1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelImagen1.setBounds(608, 10, 85, 72);
		JLabelImagen1.setIcon(new ImageIcon(Juego.class.getResource("/imagenesApp/sonriente.png")));
		contentPane.add(JLabelImagen1);
		
		//Imagen Jugador2//
		JLabelImagen2 = new JLabel("");
		JLabelImagen2.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelImagen2.setBounds(730, 10, 85, 72);
		JLabelImagen2.setIcon(new ImageIcon(Juego.class.getResource("/imagenesApp/triste.png")));
		contentPane.add(JLabelImagen2);
		
		//Etiqueta Dado1//
		JLabelDado1 = new JLabel("");
		JLabelDado1.setBounds(32, 48, 143, 149);
		contentPane.add(JLabelDado1);
		
		//Etiqueta Dado2//
		JLabelDado2 = new JLabel("");
		JLabelDado2.setBounds(219, 48, 143, 149);
		contentPane.add(JLabelDado2);
		
		//Etiqueta Dado3//
		JLabelDado3 = new JLabel("");
		JLabelDado3.setBounds(405, 48, 143, 149);
		contentPane.add(JLabelDado3);
		
		//Etiqueta Dado4//
		JLabelDado4 = new JLabel("");
		JLabelDado4.setBounds(94, 232, 143, 149);
		contentPane.add(JLabelDado4);
		
		//Etiqueta Dado5//
		JLabelDado5 = new JLabel("");
		JLabelDado5.setBounds(344, 232, 143, 149);
		contentPane.add(JLabelDado5);
		
		//Etiqueta Dado6//
		JLabelDado6 = new JLabel("");
		JLabelDado6.setBounds(204, 386, 181, 159);
		contentPane.add(JLabelDado6);
		
		//Botón Sumar//
		JButtonSumar = new JButton("+");
		JButtonSumar.setBounds(608, 87, 85, 67);
		JButtonSumar.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		JButtonSumar.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(JButtonSumar);
		
		//Botón Restar//
		JButtonRestar = new JButton("-");
		JButtonRestar.setBounds(730, 87, 85, 67);
		JButtonRestar.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		JButtonRestar.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(JButtonRestar);
		
		//Texto Operaciones//
		JTextOperaciones = new JTextField();
		JTextOperaciones.setBackground(new Color(127, 255, 212));
		JTextOperaciones.setEditable(false);
		JTextOperaciones.setFont(new Font("Verdana", Font.BOLD, 17));
		JTextOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
		JTextOperaciones.setBounds(608, 166, 207, 40);
		JTextOperaciones.setColumns(10);
		contentPane.add(JTextOperaciones);
		
		//Botón MATHDICE//
		JButtonMathDice = new JButton("MATHDICE");
		JButtonMathDice.setFont(new Font("Bauhaus 93", Font.PLAIN, 24));
		JButtonMathDice.setBounds(608, 217, 207, 40);
		contentPane.add(JButtonMathDice);
		JButtonMathDice.addActionListener(new innerAL()); //Añadimos el ActionListener desde la InnerClass//
		
		
		//Etiqueta Operaciones//
		JLabelOperacion = new JLabel("");
		JLabelOperacion.setFont(new Font("Tekton Pro", Font.BOLD, 18));
		JLabelOperacion.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelOperacion.setBounds(608, 279, 207, 40);
		contentPane.add(JLabelOperacion);
		
		//Etiqueta Resultado//
		JLabelResultado = new JLabel("");
		JLabelResultado.setFont(new Font("Tekton Pro", Font.BOLD, 18));
		JLabelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelResultado.setBounds(608, 330, 207, 40);
		contentPane.add(JLabelResultado);
		
		//Etiqueta Puntos//
		JLabelPuntos = new JLabel("Tu Puntuaci\u00F3n es: ");
		JLabelPuntos.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		JLabelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPuntos.setBounds(608, 408, 207, 40);
		contentPane.add(JLabelPuntos);
		
		//Botón Reinicio//
		JButtonReinicio = new JButton("Volver a Jugar");
		JButtonReinicio.setFont(new Font("Century Gothic", Font.BOLD, 15));
		JButtonReinicio.setBounds(610, 478, 205, 33);
		JButtonReinicio.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		contentPane.add(JButtonReinicio);
		
		//Botón Salir//
		JButtonSalir = new JButton("Salir");
		JButtonSalir.setFont(new Font("Century Gothic", Font.BOLD, 15));
		JButtonSalir.setBounds(610, 522, 205, 33);
		JButtonSalir.addActionListener(new innerAL());
		contentPane.add(JButtonSalir);
		
		
		try{
		inicioJuego();//Añadimos la clase de Inicio del Juego//
		}catch(Exception e){
			e.getMessage();
		}
	}
	
	//------------------Método para recoger el Nombre de la Ventana Registro------------------------//
	public void setJugador(Jugador p1, Perfil v4) {
		this.p1=p1;
		this.v4=v4;
		JLabelNombreP1.setText("Bienvenid@ al Juego: " +p1.getNombre());
		JLabelPuntos.setText("Tu Puntuación es: " +String.valueOf(p1.getPuntos()).toString());	
	}
	//----------------------------------------------------------------------------------------------//
	
	//-----------Método para recoger el Nombre Actualizado desde la Ventana Perfil-----------------//
		public void setNombre(String nombre) {
			p1.setNombre(nombre);
			JLabelNombreP1.setText("Bienvenid@ al Juego: " +nombre);
	}
	//--------------------------------------------------------------------------------------------//
	
	//-------------------Método para Conectarse a la BBDD-----------------------------------------//
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
				System.out.println("Conexión Establecida a MySQL");
			}else{ 
				System.out.println("No estás Conectado a MySQL");
			}
		}
	//------------------------------------------------------------------------------------------------//
		
	//-------------------Definimos el Método para pasar los Números al campo Operaciones--------------//
	public void operar (int numeros){
		numerosIntroducidos++;
		if(numerosIntroducidos > 1){
			if(esSuma) operacion = operacion + numeros;
			else operacion = operacion - numeros;
		}else{
			operacion = numeros;
		}	
	}
	//-------------------------------------------------------------------------------------------------//
	
	
	
	private void inicioJuego(){
		//Definimos el ARRAY para el Dado de 3 Caras//
		for(int i=0;i<dados3.length;i++)
		dados3[i]=new ImageIcon(getClass().getResource("/imagenesApp/dado" +String.valueOf(i+1)+ "_3.png"));	
		
		//Definimos el ARRAY para el Dado de 6 Caras//
		for(int i=0;i<dados6.length;i++)
		dados6[i]=new ImageIcon(getClass().getResource("/imagenesApp/dado" +String.valueOf(i+1)+ "_6.png"));
		
		//Definimos el ARRAY para el Dado de 12 Caras//
		for(int i=0;i<dados12.length;i++)
		dados12[i]=new ImageIcon(getClass().getResource("/imagenesApp/dado" +String.valueOf(i+1)+ "_12.png"));
		
		//Determinamos el Random para los dados de 3 caras//
		for(int i=0;i<numerosAlmacenadosDados3.length;i++) 
			numerosAlmacenadosDados3[i]=dado.nextInt(3);
		
		//Determinamos el Random para los dados de 6 caras//
		for(int i=0;i<numerosAlmacenadosDados6.length;i++)
			numerosAlmacenadosDados6[i]=dado.nextInt(6);
		
		//Colocamos el Dado 1// 
		JLabelDado1.setIcon(dados3[numerosAlmacenadosDados3[0]]);
		JLabelDado1.setName("1");
		JLabelDado1.addMouseListener(new innerML());//Añadimos el MouseListener desde la innerclass//
		
		//Colocamos el Dado 2// 
		JLabelDado2.setIcon(dados3[numerosAlmacenadosDados3[1]]);
		JLabelDado2.setName("2");
		JLabelDado2.addMouseListener(new innerML());//Añadimos el MouseListener desde la innerclass//
		
		//Colocamos el Dado 3// 
		JLabelDado3.setIcon(dados3[numerosAlmacenadosDados3[2]]);
		JLabelDado3.setName("3");
		JLabelDado3.addMouseListener(new innerML());//Añadimos el MouseListener desde la innerclass//
		
		//Colocamos el Dado 4// 
		JLabelDado4.setIcon(dados6[numerosAlmacenadosDados6[0]]);
		JLabelDado4.setName("4");
		JLabelDado4.addMouseListener(new innerML());
		
		//Colocamos el Dado 5// 
		JLabelDado5.setIcon(dados6[numerosAlmacenadosDados6[1]]);
		JLabelDado5.setName("5");
		JLabelDado5.addMouseListener(new innerML());
		
		//Número aleatoratorio entre 1 y 12//
		numerosAlmacenadosDados12=dado.nextInt(12);
		
		//Colocamos el Dado 6// 
		JLabelDado6.setIcon(dados12[numerosAlmacenadosDados12]);
		JLabelDado6.setName("6");
		JLabelDado6.addMouseListener(new innerML());
		
		
		//Reiniciar Semáforos,Valores y Botones//
		JTextOperaciones.setText("");
		JLabelOperacion.setText("");
		JLabelResultado.setText("");
		tocaNumero = true;
		operacion=0;
		numerosIntroducidos=0;
		esSuma=true;
		JButtonMathDice.setEnabled(true);
		JButtonReinicio.setEnabled(false);
		
	}
	
	private class innerML implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			JLabel dado = (JLabel)e.getSource();
			int numeroDado=Integer.valueOf(dado.getName());
			try{  //Establecemos un try por si se produce algún error cuando se ejecuta el programa//
			if(tocaNumero){
				//Establecemos las condiciones para poder realizar las operaciones//
				if(numeroDado<4)
					JTextOperaciones.setText(JTextOperaciones.getText()+String.valueOf(numerosAlmacenadosDados3[numeroDado-1]+1));
				else
					JTextOperaciones.setText(JTextOperaciones.getText()+String.valueOf(numerosAlmacenadosDados6[numeroDado-4]+1));
				
				dado.removeMouseListener(this);//Desactiva el valor del dado una vez hacemos click sobre él//
				dado.setIcon(dadogris);//Muestra el dado gris cuando presionamos un dado con números//
				tocaNumero = false;//Establecemos un semáforo al tocar un dado//
				
				if(numeroDado<4)//Condiciones para calcular las operaciones con los valores de los dados//
					operar(numerosAlmacenadosDados3[numeroDado-1]+1);
				else
					operar(numerosAlmacenadosDados6[numeroDado-4]+1);	
			}
			}catch (Exception evt){
				evt.getMessage();
			}
		}
		public void mouseEntered(MouseEvent e) {	
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
	}
	
	private class innerAL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==JButtonSumar){
				//Pasa el Signo de Sumar del Botón + a la Etiqueta de OPERACIONES//
				if(!tocaNumero){
					JTextOperaciones.setText(JTextOperaciones.getText()+" + ");
					//Establecemos los Semáforos para evitar que se puedan poner dos
					//signos a la vez y primero haya que tocar un dado y después
					//introducir un signo//
					tocaNumero=true;
					esSuma=true;
					}
				}else if(e.getSource()==JButtonRestar){
				//Pasa el Signo de Restar del Botón - a la Etiqueta de OPERACIONES//
				if(!tocaNumero){
					JTextOperaciones.setText(JTextOperaciones.getText()+" - ");
					//Establecemos los Semáforos para evitar que se puedan poner dos
					//signos a la vez y primero haya que tocar un dado y después
					//introducir un signo//
					tocaNumero=true;
					esSuma=false; 
					}
				}else if(e.getSource()==JButtonMathDice){
					if(numerosIntroducidos > 1){ //Los Números introducidos han de ser mayores a 1//
		 				JLabelOperacion.setText("Tu Resultado es: " +String.valueOf(operacion));
						JButtonReinicio.setEnabled(true); //Habilitamos el Botón Reiniciar//
						if((numerosAlmacenadosDados12+1)==operacion){
							JLabelResultado.setText(" CORRECTO!!!! ");
							p1.setPuntos(p1.getPuntos()+5);//Por partida correcta obtenemos 5 puntos//
							JLabelPuntos.setText("Tu Puntuación es: " +p1.getPuntos());
							JButtonMathDice.setEnabled(false); //Deshabilitamos el Botón Mathdice hasta una nueva partida//
							JLabelPuntos.setForeground(Color.BLUE);//Cambia el color del Texto de Puntuación cuando se acierta//
							v4.setPuntos(p1.getPuntos());//Actualizamos los Puntos para la Ventana Perfil//
							
							conectar();//Activamos la conexión//
							jdb.actualizarPuntos(conexion,p1);//Nos permite actualizar los puntos del jugador en la BBDD//
						}else{
							JLabelResultado.setText(" Prueba Otra Vez ");
							JButtonMathDice.setEnabled(false);//Deshabilitamos el Botón Mathdice hasta una nueva partida//
						}
				}
			}
				
			if(e.getSource()==JButtonSalir){
				System.exit(0);//Salir de la Aplicación//
			}

			if(e.getSource()==JButtonReinicio){
				inicioJuego();
			}
		}
	}
	

}
