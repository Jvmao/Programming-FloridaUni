package Ventana2_Juego;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ventana1_Login.Jugador;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.Toolkit;

//Abrir la nueva clase con la opción JFrame//
public class Juego extends JFrame {
	private JPanel contentPane;
	
	//Variables para los Botones//
	private JButton boton1 , boton2 , boton3 , boton4 , boton5;
	private Jugador p1;
	
	//Clase para almacenar el Jugador//
	private Jugador player1;
	//Variables para los JLabel//
	private JLabel Nombre_p1 , Dado1 , Dado2 , Dado3 , Dado4 , Dado5 , Dado6 , resultado;
	private JLabel imagenEstatica1 , imagenEstatica2;
	private JTextField operaciones;
	
	//Declaramos el Objeto Random//
	private Random dado = new Random();
	
	//----Array y Almacenamiento de los Números Aleatorios para los dados de 3 caras---//
	//Array para ImageIcon de los Dados de 3 Caras//
	private ImageIcon[] dados3 = new ImageIcon[3];
	//Almacenamiento de los Números Aleatorios, de los Dados de 3 caras, para poder realizar el cálculo posteriormente//
	private int[] numerosAlmacenadosDados3 = new int [3];
	//--------------------------------------------------------------------------------//
	
	//----Array y Almacenamiento de los Números Aleatorios para los dados de 6 caras---//
	//Array para ImageIcon de los Dados de 6 Caras//
	private ImageIcon[] dados6 = new ImageIcon[6];
	//Almacenamiento de los Números Aleatorios, de los Dados de 6 caras, para poder realizar el cálculo posteriormente//
	private int[] numerosAlmacenadosDados6 = new int [2];
	//--------------------------------------------------------------------------------//
	
	//----Array y Almacenamiento de los Números Aleatorios para los dados de 12 caras---//
	//Array para ImageIcon de los Dados de 12 Caras//
	private ImageIcon[] dados12 = new ImageIcon[12];
	//Almacenamiento de los Números Aleatorios, de los Dados de 12 caras, para poder realizar el cálculo posteriormente//
	private int[] numerosAlmacenadosDados12 = new int [12];
	//--------------------------------------------------------------------------------//
	
	//Creamos la Variable para el DadoGris//
	private ImageIcon dadogris = new ImageIcon(getClass().getResource("/imagenes/dadogris.png"));
	
	//Variable Boolean para tocaNumero//
	private boolean tocaNumero = true; 
	private boolean operacion = true; 
	
	//Variables para poder realizar Operaciones//
	private int suma;//Variable para hacer las sumas//
	private int resta;//Variable para hacer las Restas//
	private int sumatorio;//Variable para poder realizar la operación enetera//
	
	
	//-------------------------------Inicio Ventana JUEGO--------------------------------//
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//--------------------Frame de la ventana JUEGO---------------------//
	public Juego() {
		setTitle("MATHDICE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Cambiar Color ContenPane//
		contentPane.setBackground(Color.YELLOW);
		//Con el comando setLocationRelativeTo centramos la ventana del Juego en el CENTRO de la Pantalla//
		setLocationRelativeTo(null);
		//Impedimos que la Ventana se puedad hacer más grande//
		setResizable(false);
	//------------------------------------------------------------------//
		
		
		//-------Nombre de la Ventana LOGIN pasa a la Ventana JUEGO------//
		Nombre_p1 = new JLabel(" " +p1);
		Nombre_p1.setFont(new Font("Trajan Pro", Font.BOLD, 14));
		Nombre_p1.setBounds(0, 0, 553, 20);
		contentPane.add(Nombre_p1);
		//----------------------------------------------------------------------//
		
		//Con el comando this iniciamos el juego con las imágenes en el Array//
		this.inicioJuego();
		
		
		//--------------DADO 1-----------------------------------------//
		Dado1 = new JLabel(" ");
		//Mouse Listener DADO1 desde INNER Class//
		//Dado1.addMouseListener(new dado3());
		//Mouse Listener DADO1//
		Dado1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
						Dado1.setIcon(dadogris);
						Dado1.removeMouseListener(this);
					
			}
		});
		
		//Cargamos las imágenes en el Dado desde el Array//
		Dado1.setIcon(dados3[numerosAlmacenadosDados3[0]]);
		//Dado1.setIcon(dados3[dado.nextInt(3)]);//Otra manera de cargar la imágen desde Array//
		Dado1.setName(" 1 ");
		Dado1.setHorizontalAlignment(SwingConstants.CENTER);
		Dado1.setBounds(20, 31, 148, 134);
		contentPane.add(Dado1);
		
		//---------------------------------------------------------------//
		
		
		
		//----------------DADO 2-----------------------------------------//
		Dado2 = new JLabel(" ");
		//Mouse Listener DADO 2 desde INNER CLASS//
		Dado2.addMouseListener(new dado3());
		//Mouse Listener DADO2//
		Dado2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		//Insertar Dado 2 desde Array//
		Dado2.setIcon(dados3[numerosAlmacenadosDados3[1]]);
		//Dado2.setIcon(dados3[dado.nextInt(3)]);
		Dado2.setName("2");
		Dado2.setHorizontalAlignment(SwingConstants.CENTER);
		Dado2.setBounds(179, 31, 148, 134);
		contentPane.add(Dado2);
		//-----------------------------------------------------------//
		
		
		
		//-------------------------DADO 3------------------------------//
		Dado3 = new JLabel(" ");
		//Mouse Listener DADO3 desde INNER Class//
		Dado3.addMouseListener(new dado3());
		//Mouse Listener DADO3//
		Dado3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {		
			}
		});
		//Insertar Dado 3 desde Array//
		Dado3.setIcon(dados3[dado.nextInt(3)]);
		Dado3.setName("3"); 
		Dado3.setHorizontalAlignment(SwingConstants.CENTER);
		Dado3.setBounds(337, 31, 148, 134);
		contentPane.add(Dado3);
		//-------------------------------------------------------------//
		
		
		
		//---------------------------DADO 4-------------------------------------//
		Dado4 = new JLabel(" ");
		//Mouse Listener DADO 4 desde INNER Class//
		//Dado4.addMouseListener(new dado6());
		//Mouse Listener DADO4//	
		Dado4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Dado4.setIcon(dadogris);
				Dado4.removeMouseListener(this);
			}
		});
		Dado4.setIcon(dados6[numerosAlmacenadosDados6[0]]);
		//Dado4.setIcon(dados6[dado.nextInt(6)]);
		Dado4.setName(" 4 ");
		Dado4.setHorizontalAlignment(SwingConstants.CENTER);
		Dado4.setBounds(82, 174, 148, 134);
		contentPane.add(Dado4);
		//----------------------------------------------------------------------//
		
		
		
		//---------------------------DADO 5-------------------------------------//
		Dado5 = new JLabel();
		//Mouse Listener DADO5 desde INNER Class//
		//Dado5.addMouseListener(new dado6());
		//Mouse Listener DADO5//
		Dado5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Dado5.setIcon(dadogris);
				Dado5.removeMouseListener(this);
			}
		});
		Dado5.setIcon(dados6[numerosAlmacenadosDados6[1]]);
		//Dado5.setIcon(dados6[dado.nextInt(6)]);
		Dado5.setName(" 5 ");
		Dado5.setHorizontalAlignment(SwingConstants.CENTER);
		Dado5.setBounds(273, 174, 148, 134);
		contentPane.add(Dado5);
		//----------------------------------------------------------------------//
		
		
		
		//-----------------------DADO 6----------------------------------------//
		Dado6 = new JLabel(" ");
		//Cargamos Imágen desde Array//
		Dado6.setIcon(dados12[dado.nextInt(12)]);
		Dado6.setName(" 6 ");
		Dado6.setBounds(153, 319, 174, 155);
		contentPane.add(Dado6);
		//---------------------------------------------------------------------//
		
		
		//-----------------Imagen Estática 1--------------------------------------------------//
		imagenEstatica1 = new JLabel("");
		imagenEstatica1.setHorizontalAlignment(SwingConstants.CENTER);
		//Cargamos la imagen desde la carpeta de imagenes//
		imagenEstatica1.setIcon(new ImageIcon(Juego.class.getResource("/imagenes/IronMan.png")));
		imagenEstatica1.setBounds(666, 31, 89, 115);
		contentPane.add(imagenEstatica1);
		
		//-----------------Imagen Estática 2--------------------------------------------------//
		imagenEstatica2 = new JLabel("");
		//Cargamos la imagen desde la carpeta de imagenes//
		imagenEstatica2.setIcon(new ImageIcon(Juego.class.getResource("/imagenes/punisher.png")));
		imagenEstatica2.setHorizontalAlignment(SwingConstants.CENTER);
		imagenEstatica2.setBounds(765, 31, 89, 110);
		contentPane.add(imagenEstatica2);
		//-----------------------------------------------------------------------------------//
		
		
		//--------------------------------Boton SUMAR------------------------------//
		boton3 = new JButton(" + ");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Pasa el Signo de Sumar del Botón + a la Etiqueta de OPERACIONES//
				if(!tocaNumero){
					operaciones.setText(operaciones.getText()+" + ");
					//Establecemos los Semáforos para evitar que se puedan poner dos
					//signos a la vez y primero haya que tocar un dado y después
					//introducir un signo//
					operacion=true;
					tocaNumero=true;
				}
			}
		});
		boton3.setFont(new Font("Tahoma", Font.BOLD, 18));
		boton3.setBounds(666, 152, 89, 34);
		contentPane.add(boton3);
		//-------------------------------------------------------------------//
		
		
		
		//----------------------------Boton RESTAR ------------------------------//
		boton4 = new JButton(" - ");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Pasa el Signo de Restar del Botón - a la Etiqueta de OPERACIONES//
				if(!tocaNumero){
					operaciones.setText(operaciones.getText()+" - ");
					//Establecemos los Semáforos para evitar que se puedan poner dos
					//signos a la vez y primero haya que tocar un dado y después
					//introducir un signo//
					operacion=false; 
					tocaNumero=true;
				}
				
			}
		});
		boton4.setFont(new Font("Tahoma", Font.BOLD, 18));
		boton4.setBounds(765, 152, 89, 34);
		contentPane.add(boton4);
		//-----------------------------------------------------------------//
		
		
		//---------------------------OPERACIONES------------------------//
		operaciones = new JTextField();
		operaciones.setEditable(false);
		operaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		operaciones.setBounds(666, 197, 188, 20);
		contentPane.add(operaciones);
		operaciones.setColumns(10);
		//------------------------------------------------------------//
		
		
		//------------------------MATHDICE-------------------------------//
		boton5 = new JButton("MATHDICE");
		boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					resultado.setText("Tu Resultado es: ");
			}
		});
		boton5.setFont(new Font("Tahoma", Font.BOLD, 15));
		boton5.setBounds(666, 228, 188, 23);
		contentPane.add(boton5);
		//--------------------------------------------------------------//
		
		//----------------------RESULTADO---------------------------------//
		resultado = new JLabel(" ");
		resultado.setBounds(666, 263, 188, 45);
		contentPane.add(resultado);
		//-----------------------------------------------------------------------//
		
		
		//--------------Boton REINICIAR----------------------------------------//
		boton2 = new JButton("Reiniciar");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Reinicia el Campo de Dados cargando nuevas imágenes así como el MouseListener//
				Dado1.setIcon(dados3[numerosAlmacenadosDados3[0]]);
				Dado1.setIcon(dados3[dado.nextInt(3)]);
				//Dado1.addMouseListener(new dado3());
				Dado2.setIcon(dados3[numerosAlmacenadosDados3[1]]);
				Dado2.setIcon(dados3[dado.nextInt(3)]);
				Dado2.addMouseListener(new dado3());
				Dado3.setIcon(dados3[numerosAlmacenadosDados3[2]]);
				Dado3.setIcon(dados3[dado.nextInt(3)]);
				Dado3.addMouseListener(new dado3());
				Dado4.setIcon(dados6[numerosAlmacenadosDados6[0]]);
				Dado4.setIcon(dados6[dado.nextInt(6)]);
				//Dado4.addMouseListener(new dado6());
				Dado5.setIcon(dados6[numerosAlmacenadosDados6[1]]);
				Dado5.setIcon(dados6[dado.nextInt(6)]);
				//Dado5.addMouseListener(new dado6());
				Dado6.setIcon(dados12[numerosAlmacenadosDados12[0]]);
				Dado6.setIcon(dados12[dado.nextInt(12)]);
				//Reinicia el Campo de Operaciones//
				operaciones.setText(" ");
				resultado.setText(" ");
			}
		});
		boton2.setBounds(666, 451, 89, 23);
		contentPane.add(boton2);
		//--------------------------------------------------------------//
		
		
		//-------------------Boton para SALIR de la Aplicación-----------//
		boton1 = new JButton("Salir");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Botón para CERRAR la aplicación//
				dispose();
				//Acción para CERRAR todas las Ventanas//
				System.exit(0);
			}
		});
		boton1.setBounds(765, 451, 89, 23);
		contentPane.add(boton1);
		//---------------------------------------------------------------//
		
		
		//Al iniciar el Juego permitimos que seleccione las imágenes de forma aleatoria//
		try{
		inicioJuego();
		}catch (Exception e){
			e.getMessage();
		}
		//----------------------------------------------------------------------------//
		
	}
	//---------------------------------FIN VENTANA JUEGO------------------------------------------------//
	
	
	
	
	
	//-----------Pasa el Nombre de la Ventana_Login a la Ventana_Jugador-------------//
			public void setJugador(Jugador p1){
				this.p1=p1;
				Nombre_p1.setText("Bienvenid@ al Juego: " +p1.getNombre());
			}
	//------------------------------------------------------------------------------//
			
			
	
	//-----Método para iniciar el Juego con Imágenes Aleatorias para Dados de varias caras----//
			private void inicioJuego(){
				//Definimos el ARRAY para el Dado de 3 Caras//
				for(int i=0;i<dados3.length;i++){
				dados3[i]=new ImageIcon(getClass().getResource("/imagenes/dado" +String.valueOf(i+1)+ "_3.png"));	
				}
				//Definimos el ARRAY para el Dado de 6 Caras//
				for(int i=0;i<dados6.length;i++){
				dados6[i]=new ImageIcon(getClass().getResource("/imagenes/dado" +String.valueOf(i+1)+ "_6.png"));	
				}
				//Definimos el ARRAY para el Dado de 12 Caras//
				for(int i=0;i<dados12.length;i++){
				dados12[i]=new ImageIcon(getClass().getResource("/imagenes/dado" +String.valueOf(i+1)+ "_12.png"));	
				}
				//Colocamos los dados de 3 caras//
				for(int i=0;i<numerosAlmacenadosDados3.length;i++)
				//Número aleatorio entre 0 y 2
				numerosAlmacenadosDados3[i]=dado.nextInt(3);
				//Colocamos los dados de 6 caras//
				for(int i=0;i<numerosAlmacenadosDados6.length;i++)
				//Número aleatorio entre 0 y 5
				numerosAlmacenadosDados6[i]=dado.nextInt(6);
				  
				//Colocamos los dados de 12 caras//
				for(int i=0;i<numerosAlmacenadosDados12.length;i++)
				//Número aleatorio entre 0 y 11
				numerosAlmacenadosDados12[i]=dado.nextInt(12);
				
		}	
	//------------------------------------------------------------------------------------------------//
			
			//Definimos el Método para pasar los Números al campo Operaciones//
			public void operar (int numeros){
				sumatorio++;
			
				if(sumatorio > 1){
					if(operacion) sumatorio= sumatorio + numeros;
					else sumatorio=sumatorio - numeros;
				}else{
					sumatorio = numeros;
				}
				
			}
	
			
	//----------------------------INNER CLASS DADOS 3 CARAS-------------------------------------------//
	private class dado3 implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			JLabel dado3 = (JLabel)e.getSource();
			int numeroDado3=Integer.valueOf(dado3.getName());
			try{
			if(tocaNumero==true){
				dado3.setIcon(dadogris);
				tocaNumero = false;
				dado3.removeMouseListener(this);
			}
			}catch (Exception evt){
				evt.getMessage();
			}
			
		}
		//MouseListener sin Utilizar------------------------------//
		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
		//---------------------------------------------------------//		
			}
	//-------------------------FIN INNER CLASS DADOS 3 CARAS----------------------------------------//
	
	//--------------------INNER CLASS DADOS 6 CARAS-------------------------------------------------//
	
	private class dado6 implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			JLabel dado6 = (JLabel)e.getSource();
			int numeroDado6=Integer.valueOf(dado6.getName());
			try{
			if(!tocaNumero == true){
				dado6.setIcon(dadogris);
				tocaNumero = false;
				dado6.removeMouseListener(this);	
			}
			}catch (Exception evt){
				evt.getMessage();
			}
			
		}
		//MouseListener sin Utilizar------------------------------//
		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
		//--------------------------------------------------------//
	}
}
