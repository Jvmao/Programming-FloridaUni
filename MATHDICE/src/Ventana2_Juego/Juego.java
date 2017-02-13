package Ventana2_Juego;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ventana1_Login.Jugador;
import Ventana1_Login.Login;

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
	private JButton salir , reiniciar , sumar , restar , mathDice, btLogin;
	private Jugador p1;
	
	//Clase para almacenar el Jugador//
	private Jugador player1;
	//Variables para los JLabel//
	private JLabel Nombre_p1 , Dado1 , Dado2 , Dado3 , Dado4 , Dado5 , Dado6;
	private JLabel imagenEstatica1 , imagenEstatica2;
	private JLabel resultadoOperacion , resultadoCorrecto;
	private JTextField operaciones; 
	
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
	private ImageIcon dadogris = new ImageIcon(getClass().getResource("/imagenes/dadogris.png"));
	
	//Variable Boolean para tocaNumero y esSuma y así poder utilizar semáforos//
	private boolean tocaNumero = true; 
	private boolean esSuma = true; //esSuma//
	//Variables int para realizar las operaciones//
	private int numerosIntroducidos=0;
	private int operacion=0;
	private int suma;//Variable para hacer las sumas//
	private int resta;//Variable para hacer las Restas//
	
	
	//-------------------------------Inicio Ventana JUEGO--------------------------------//
	

	
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
		contentPane.setBackground(Color.ORANGE);
		//Con el comando setLocationRelativeTo centramos la ventana del Juego en el CENTRO de la Pantalla//
		setLocationRelativeTo(null);
		//Impedimos que la Ventana se puedad hacer más grande//
		setResizable(false);
	//------------------------------------------------------------------//
		
		
		//-------Nombre de la Ventana LOGIN pasa a la Ventana JUEGO------//
		Nombre_p1 = new JLabel(" " +p1);
		Nombre_p1.setFont(new Font("Trajan Pro", Font.BOLD, 14));
		Nombre_p1.setBounds(0, 0, 400, 20);
		contentPane.add(Nombre_p1);
		//----------------------------------------------------------------------//
			
		
		//--------------DADO 1-----------------------------------------//
		Dado1 = new JLabel(" ");
		/**(Parte No Necesaria pero útil para otros proyectos)
		Dado1.addMouseListener(new innerDado());
		Dado1.setIcon(dados3[numerosAlmacenadosDados3[0]]);
		Dado1.setIcon(dados3[dado.nextInt(3)]);//Otra manera de cargar la imágen desde Array//
		Dado1.setName("1");**/
		Dado1.setHorizontalAlignment(SwingConstants.CENTER);
		Dado1.setBounds(20, 31, 148, 134);
		contentPane.add(Dado1);
		//---------------------------------------------------------------//
		
		
		
		//----------------DADO 2-----------------------------------------//
		Dado2 = new JLabel(" ");
		Dado2.setHorizontalAlignment(SwingConstants.CENTER);
		Dado2.setBounds(179, 31, 148, 134);
		contentPane.add(Dado2);
		//-----------------------------------------------------------//
		
		
		
		//-------------------------DADO 3------------------------------//
		Dado3 = new JLabel(" ");
		Dado3.setHorizontalAlignment(SwingConstants.CENTER);
		Dado3.setBounds(337, 31, 148, 134);
		contentPane.add(Dado3);
		//-------------------------------------------------------------//
		
		
		
		//---------------------------DADO 4-------------------------------------//
		Dado4 = new JLabel(" ");
		Dado4.setHorizontalAlignment(SwingConstants.CENTER);
		Dado4.setBounds(82, 174, 148, 134);
		contentPane.add(Dado4);
		//----------------------------------------------------------------------//
		
		
		
		//---------------------------DADO 5-------------------------------------//
		Dado5 = new JLabel();
		Dado5.setHorizontalAlignment(SwingConstants.CENTER);
		Dado5.setBounds(273, 174, 148, 134);
		contentPane.add(Dado5);
		//----------------------------------------------------------------------//
		
		
		
		//-----------------------DADO 6----------------------------------------//
		Dado6 = new JLabel(" ");
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
		//------------------------------------------------------------------------------------//
		
		//-----------------Imagen Estática 2--------------------------------------------------//
		imagenEstatica2 = new JLabel("");
		//Cargamos la imagen desde la carpeta de imagenes//
		imagenEstatica2.setIcon(new ImageIcon(Juego.class.getResource("/imagenes/punisher.png")));
		imagenEstatica2.setHorizontalAlignment(SwingConstants.CENTER);
		imagenEstatica2.setBounds(765, 31, 89, 110);
		contentPane.add(imagenEstatica2);
		//-----------------------------------------------------------------------------------//
		
		
		//--------------------------------Boton SUMAR------------------------------//
		sumar = new JButton(" + ");
		sumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Pasa el Signo de Sumar del Botón + a la Etiqueta de OPERACIONES//
				if(!tocaNumero){
					operaciones.setText(operaciones.getText()+" + ");
					//Establecemos los Semáforos para evitar que se puedan poner dos
					//signos a la vez y primero haya que tocar un dado y después
					//introducir un signo//
					esSuma=true;
					tocaNumero=true;
				}
			}
		});
		sumar.setFont(new Font("Tahoma", Font.BOLD, 18));
		sumar.setBounds(666, 152, 89, 34);
		contentPane.add(sumar);
		//------------------------------------------------------------------------//
		
		
		
		//----------------------------Boton RESTAR ------------------------------//
		restar = new JButton(" - ");
		restar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Pasa el Signo de Restar del Botón - a la Etiqueta de OPERACIONES//
				if(!tocaNumero){
					operaciones.setText(operaciones.getText()+" - ");
					//Establecemos los Semáforos para evitar que se puedan poner dos
					//signos a la vez y primero haya que tocar un dado y después
					//introducir un signo//
					esSuma=false; 
					tocaNumero=true;
				}
			}
		});
		restar.setFont(new Font("Tahoma", Font.BOLD, 18));
		restar.setBounds(765, 152, 89, 34);
		contentPane.add(restar);
		//-----------------------------------------------------------------------//
		
		
		//---------------------------OPERACIONES--------------------------------//
		operaciones = new JTextField();
		operaciones.setEditable(false);
		operaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		operaciones.setBounds(666, 197, 188, 20);
		contentPane.add(operaciones);
		operaciones.setColumns(10);
		//----------------------------------------------------------------------//
		
		
		//-----------------------------MATHDICE---------------------------------//
		mathDice = new JButton("MATHDICE");
		mathDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numerosIntroducidos > 1){ //Los Números introducidos han de ser mayores a 1//
					resultadoOperacion.setText("Tu Resultado es: " +String.valueOf(operacion));
					if((numerosAlmacenadosDados12+1)==operacion){
						resultadoCorrecto.setText(" CORRECTO!!!! ");
						resultadoCorrecto.getIcon();
						mathDice.setEnabled(false); //Deshabilitamos el Botón Mathdice hasta una nueva partida//
						reiniciar.setEnabled(true); //Habilitamos el Botón Reiniciar//
						btLogin.setEnabled(true);//Habilitamos el Botón Login//
					}else{
						resultadoCorrecto.setText(" Prueba Otra Vez ");
						mathDice.setEnabled(false);//Deshabilitamos el Botón Mathdice hasta una nueva partida//
						reiniciar.setEnabled(true);//Habilitamos el Botón Reiniciar//
						btLogin.setEnabled(true);//Habilitamos el Botón Login//
						}
				}		
			}
		});
		mathDice.setFont(new Font("Tahoma", Font.BOLD, 15));
		mathDice.setBounds(666, 228, 188, 23);
		contentPane.add(mathDice);
		//----------------------------------------------------------------------//
		
		//----------------------RESULTADO OPERACION-----------------------------//
		resultadoOperacion = new JLabel(" ");
		resultadoOperacion.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoOperacion.setBounds(666, 263, 188, 53);
		contentPane.add(resultadoOperacion);
		//----------------------------------------------------------------------//
		
		//----------------------RESULTADO CORRECTO------------------------------//
		resultadoCorrecto = new JLabel(" ");
		resultadoCorrecto.setFont(new Font("Stencil Std", Font.BOLD, 15));
		resultadoCorrecto.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoCorrecto.setBounds(666, 319, 188, 53);
		contentPane.add(resultadoCorrecto);
		//---------------------------------------------------------------------//
		
		//--------------Boton REINICIAR----------------------------------------//
		reiniciar = new JButton("Reiniciar");
		reiniciar.setEnabled(false);
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Reinicia el Campo de Dados cargando nuevas imágenes 
				//así como reiniciando el MouseListener y valores
				inicioJuego();
			}
		});
		
		reiniciar.setBounds(666, 451, 89, 23);
		contentPane.add(reiniciar);
		//--------------------------------------------------------------//
		
		
		//-------------------Boton para SALIR de la Aplicación-----------//
		salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//Botón para CERRAR la aplicación//
				System.exit(0);//Acción para CERRAR todas las Ventanas//
			}
		});
		salir.setBounds(765, 451, 89, 23);
		contentPane.add(salir);
		//---------------------------------------------------------------//
		
		//------------Botón para volver a la Ventana Login---------------//
		btLogin = new JButton("<<< Login"); //Solo se habilita cuando se acaba la partida//
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Login v1 = new Login();//Definimos la Ventana Login//
				v1.setVisible(true); //Pasamos a la Ventana Login al presionar el botón << Login//
				dispose(); //Cierra la Ventana Actual//
			}
		});
		btLogin.setBounds(567, 451, 89, 23);
		contentPane.add(btLogin);
		//---------------------------------------------------------------//
		
		
		
		//Al iniciar el Juego permitimos que seleccione las imágenes de forma aleatoria
		//y reinicie todas las operaciones//
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
				for(int i=0;i<dados3.length;i++)
				dados3[i]=new ImageIcon(getClass().getResource("/imagenes/dado" +String.valueOf(i+1)+ "_3.png"));	
				
				//Definimos el ARRAY para el Dado de 6 Caras//
				for(int i=0;i<dados6.length;i++)
				dados6[i]=new ImageIcon(getClass().getResource("/imagenes/dado" +String.valueOf(i+1)+ "_6.png"));	
				
				//Definimos el ARRAY para el Dado de 12 Caras//
				for(int i=0;i<dados12.length;i++)
				dados12[i]=new ImageIcon(getClass().getResource("/imagenes/dado" +String.valueOf(i+1)+ "_12.png"));
				
				//Determinamos el Random para los dados de 3 caras//
				for(int i=0;i<numerosAlmacenadosDados3.length;i++) 
					numerosAlmacenadosDados3[i]=dado.nextInt(3); 
				//Colocamos el Dado 1// 
				Dado1.setIcon(dados3[numerosAlmacenadosDados3[0]]);
				Dado1.setName("1");
				Dado1.addMouseListener(new innerDado());//inner class para los dados//
				
				//Colocamos el Dado 2// 
				Dado2.setIcon(dados3[numerosAlmacenadosDados3[1]]);
				Dado2.setName("2");
				Dado2.addMouseListener(new innerDado());
				
				//Colocamos el Dado 3// 
				Dado3.setIcon(dados3[numerosAlmacenadosDados3[2]]);
				Dado3.setName("3");
				Dado3.addMouseListener(new innerDado());
				
				//Determinamos el Random para los dados de 6 caras//
				for(int i=0;i<numerosAlmacenadosDados6.length;i++)
					numerosAlmacenadosDados6[i]=dado.nextInt(6);
				//Colocamos el Dado 4// 
				Dado4.setIcon(dados6[numerosAlmacenadosDados6[0]]);
				Dado4.setName("4");
				Dado4.addMouseListener(new innerDado());
				
				//Colocamos el Dado 5// 
				Dado5.setIcon(dados6[numerosAlmacenadosDados6[1]]);
				Dado5.setName("5");
				Dado5.addMouseListener(new innerDado());
				
				//Número aleatoratorio entre 1 y 12//
				numerosAlmacenadosDados12=dado.nextInt(12);
				//Colocamos el Dado 6// 
				Dado6.setIcon(dados12[numerosAlmacenadosDados12]);
				
				//Reinicia el Campo de Operaciones//
				operaciones.setText(" ");
				resultadoOperacion.setText(" ");
				resultadoCorrecto.setText(" ");
				
				//Reiniciar Semáforos,Valores y Botones//
				tocaNumero = true;
				operacion=0;
				numerosIntroducidos=0;
				esSuma=true;
				mathDice.setEnabled(true);
				reiniciar.setEnabled(false);
				btLogin.setEnabled(false);
				
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
	
			
	//----------------------------INNER CLASS DADOS 3 CARAS-------------------------------------------//
	private class innerDado implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			JLabel dado = (JLabel)e.getSource();
			int numeroDado=Integer.valueOf(dado.getName());
			try{  //Establecemos un try por si se produce algún error cuando se ejecuta el programa//
			if(tocaNumero){
				//Establecemos las condiciones para poder realizar las operaciones//
				if(numeroDado<4)
					operaciones.setText(operaciones.getText()+String.valueOf(numerosAlmacenadosDados3[numeroDado-1]+1));
				else
					operaciones.setText(operaciones.getText()+String.valueOf(numerosAlmacenadosDados6[numeroDado-4]+1));
				
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
}
