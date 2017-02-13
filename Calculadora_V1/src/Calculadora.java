import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {
	//Variables//
	private JPanel contentPane;
	private JTextField pantalla;
	private String memoria1;
	private String signo;
	private String memoria2;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Calculadora() {
		setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 15));
		setTitle("CALCULADORA V1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		//Campo donde se recoger�n las Operaciones//
		pantalla = new JTextField();
		pantalla.setBounds(10, 11, 310, 20);
		contentPane.add(pantalla);
		pantalla.setColumns(10);
		pantalla.setEditable(false);//impide que se pueda escribir en este campo de texto//
		
		//Bot�n 1//
		JButton btnNewButton = new JButton("1");
		//ActionListener Bot�n 1//
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pantalla.setText(pantalla.getText()+ "1"); 
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(153, 255, 204));
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 42, 54, 42);
		contentPane.add(btnNewButton);
		
		
		//Bot�n 2//
		JButton button = new JButton("2");
		//Action Listener Bot�n 2//
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText()+ "2");//Pasa el Bot�n 2 al campo de texto al presionarlo//
			}
		});
		button.setForeground(Color.BLACK);
		button.setBackground(new Color(153, 255, 204));
		button.setFont(new Font("Stencil", Font.PLAIN, 14));
		button.setBounds(74, 42, 54, 42);
		contentPane.add(button);
		
		//Bot�n 3//
		JButton button_1 = new JButton("3");
		//Action Listener Bot�n 3//
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText()+ "3");//Pasa el Bot�n 3 al campo de texto al presionarlo//
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(new Color(153, 255, 204));
		button_1.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_1.setBounds(138, 42, 54, 42);
		contentPane.add(button_1);
		
		//Bot�n RESTA//     //Los signos no sales por pantalla realiza las operaciones de forma interna//
		JButton button_2 = new JButton("-");
		//Action Listener Bot�n RESTA//
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Comprobamos que la pantalla no est� en Blanco//
				//Realizamos el mismo m�todo para SUMA,MUTIPLICACI�N y DIVISI�N//
				if(!pantalla.getText().equals("")){
					memoria1=pantalla.getText(); //variable creada anteriormente//
					signo="-"; //variable creada anteriormente//
					pantalla.setText("");
				}
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setBackground(new Color(153, 255, 204));
		button_2.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_2.setBounds(202, 42, 54, 42);
		contentPane.add(button_2);
		
		//Bot�n C para poder Botar cada car�cter de Forma Individual//
		JButton btnC = new JButton("C");
		//Action Listener Bot�n C//
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Definimos una variable tipo String y la podemos llamar cadena//
				String cadena;
				cadena=pantalla.getText();
				
				if(cadena.length()>0){
					//Borra cada car�cter de forma individual//
					cadena=cadena.substring(0 , cadena.length()-1);
					pantalla.setText(cadena);
					
				}
			}
		});
		btnC.setForeground(Color.BLACK);
		btnC.setBackground(new Color(153, 255, 204));
		btnC.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnC.setBounds(266, 42, 54, 42);
		contentPane.add(btnC);
		
		//Bot�nn 4//
		JButton button_4 = new JButton("4");
		//Action Listener Bot�n 4//
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText()+ "4");//Pasa el Bot�n 4 al campo de texto al presionarlo//
			}
		});
		button_4.setForeground(Color.BLACK);
		button_4.setBackground(new Color(153, 255, 204));
		button_4.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_4.setBounds(10, 95, 54, 42);
		contentPane.add(button_4);
		
		//Bot�n 5//
		JButton button_5 = new JButton("5");
		//Action Listener Bot�n 5//
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText()+ "5");//Pasa el Bot�n 5 al campo de texto al presionarlo//
			}
		});
		button_5.setForeground(Color.BLACK);
		button_5.setBackground(new Color(153, 255, 204));
		button_5.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_5.setBounds(74, 95, 54, 42);
		contentPane.add(button_5);
		
		//Bot�n 6//
		JButton button_6 = new JButton("6");
		//Action Listener Bot�n 6//
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText()+ "6");//Pasa el Bot�n 6 al campo de texto al presionarlo//
			}
		});
		button_6.setForeground(Color.BLACK);
		button_6.setBackground(new Color(153, 255, 204));
		button_6.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_6.setBounds(138, 95, 54, 42);
		contentPane.add(button_6);
		
		//Bot�n SUMA//
		JButton button_7 = new JButton("+");
		//Action Listener Bot�n SUMA//
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Comprobamos que la pantalla no est� en Blanco//
				if(!pantalla.getText().equals("")){
					memoria1=pantalla.getText(); //variable creada anteriormente//
					signo = "+"; //variable creada anteriormente//
					pantalla.setText("");
				}
			}
		});
		button_7.setForeground(Color.BLACK);
		button_7.setBackground(new Color(153, 255, 204));
		button_7.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_7.setBounds(202, 95, 54, 42);
		contentPane.add(button_7);
		
		//Bot�n CE para Borrar toda la pantalla//
		JButton btnCc = new JButton("CE");
		//Action Listener Bot�n CE//
		btnCc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(" ");
			}
		});
		btnCc.setForeground(Color.BLACK);
		btnCc.setBackground(new Color(153, 255, 204));
		btnCc.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnCc.setBounds(266, 95, 54, 42);
		contentPane.add(btnCc);
		
		//Bot�n 7//
		JButton button_9 = new JButton("7");
		//Action Listener Bot�n 7//
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText()+ "7");//Pasa el Bot�n 7 al campo de texto al presionarlo//
			}
		});
		button_9.setForeground(Color.BLACK);
		button_9.setBackground(new Color(153, 255, 204));
		button_9.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_9.setBounds(10, 148, 54, 42);
		contentPane.add(button_9);
		
		//Bot�n 0//
		JButton button_10 = new JButton("0");
		//Action Listener Bot�n 0//
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText()+ "0");//Pasa el Bot�n 0 al campo de texto al presionarlo//
			}
		});
		button_10.setForeground(Color.BLACK);
		button_10.setBackground(new Color(153, 255, 204));
		button_10.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_10.setBounds(10, 197, 54, 42);
		contentPane.add(button_10);
		
		//Bot�n 8//
		JButton button_11 = new JButton("8");
		//Action Listener Bot�n 8//
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText()+ "8");//Pasa el Bot�n 8 al campo de texto al presionarlo//
			}
		});
		button_11.setForeground(Color.BLACK);
		button_11.setBackground(new Color(153, 255, 204));
		button_11.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_11.setBounds(74, 148, 54, 42);
		contentPane.add(button_11);
		
		//Bot�n +/-//
		JButton button_12 = new JButton("+/-");
		//Action Listener Bot�n +/-//
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Declaramos una nueva variable Decimal//
				Double num;
				//Declaramos una Variable String//
				String cadena;
				cadena=pantalla.getText();
				//Variable condicional para evitar que la cadena est� vacia//
				if(cadena.length()>0){
					num=(Double.parseDouble(cadena))*(-1); //Convierte la variable Double a String//
					pantalla.setText(num.toString());
				}
			}
		});
		button_12.setForeground(Color.BLACK);
		button_12.setBackground(new Color(153, 255, 204));
		button_12.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_12.setBounds(74, 197, 54, 42);
		contentPane.add(button_12);
		
		//Bot�n 9//
		JButton button_13 = new JButton("9");
		//Action Listener Bot�n 9//
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(pantalla.getText()+ "9");//Pasa el Bot�n 9 al campo de texto al presionarlo//
			}
		});
		button_13.setForeground(Color.BLACK);
		button_13.setBackground(new Color(153, 255, 204));
		button_13.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_13.setBounds(138, 148, 54, 42);
		contentPane.add(button_13);
		
		//Bot�n Multiplicar//
		JButton button_14 = new JButton("*");
		//Action Listener Bot�n Multiplicar//
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Comprobamos que la pantalla no est� en Blanco//
				if(!pantalla.getText().equals("")){
					memoria1=pantalla.getText(); //variable creada anteriormente//
					signo="*"; //variable creada anteriormente//
					pantalla.setText("");
				}
			}
		});
		button_14.setForeground(Color.BLACK);
		button_14.setBackground(new Color(153, 255, 204));
		button_14.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_14.setBounds(202, 148, 54, 42);
		contentPane.add(button_14);
		
		//Bot�n 1/x para realizar la operaci�n inversa//
		JButton btnx = new JButton("1/x");
		//Action Listener Bot�n 1/x//
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Creamos otra variable tipo String y la volvemos a denominar cadena,
				//aunque se puede elegir el nombre que  creamos m�s conveniente//
				String cadena;
				cadena=pantalla.getText();
				
				//Comprueba que la cadena no est� vac�a//
				Double num; //guarda el valor de la cadena inversa
				cadena=pantalla.getText();
				if(cadena.length()>0){
					num=1/(Double.parseDouble(cadena)); //convierte el valor a decimal para que se pueda dividir
					pantalla.setText(num.toString());
				}
			}
		});
		btnx.setForeground(Color.BLACK);
		btnx.setBackground(new Color(153, 255, 204));
		btnx.setFont(new Font("Stencil", Font.PLAIN, 11));
		btnx.setBounds(266, 148, 54, 42);
		contentPane.add(btnx);
		
		//Bot�n PUNTO//
		JButton button_16 = new JButton(".");
		//Action Listener Bot�n PUNTO//
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Definimos una Variable Cadena para el PUNTO//
				String cadena;
				cadena=pantalla.getText();
				//Comprueba si la cadena est� vacia//
				if (cadena.length() <= 0){
					pantalla.setText("0.");
				}else{
					if(!existenumero(pantalla.getText())){
						pantalla.setText(pantalla.getText()+".");
					}
				}
			}
		});
		button_16.setForeground(Color.BLACK);
		button_16.setBackground(new Color(153, 255, 204));
		button_16.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_16.setBounds(138, 197, 54, 42);
		contentPane.add(button_16);
		
		//Bot�n Divisi�n//
		JButton button_17 = new JButton("/");
		//Action Listener Bot�n Divisi�n//
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Comprobamos que la pantalla no est� en Blanco//
				if(!pantalla.getText().equals("")){
					memoria1=pantalla.getText(); //variable creada anteriormente//
					signo="/"; //variable creada anteriormente//
					pantalla.setText("");
				}
			}
		});
		button_17.setForeground(Color.BLACK);
		button_17.setBackground(new Color(153, 255, 204));
		button_17.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_17.setBounds(202, 197, 54, 42);
		contentPane.add(button_17);
		
		//Bot�n =//
		JButton button_18 = new JButton("=");
		//Action Listener Bot�n =//
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Creamos una variable String para el resultado//
				String resultado;
				memoria2=pantalla.getText();
				//Declaramos una Condicional//
				if(!memoria2.equals("")){
					//Enviamos los par�metros al resultado mediante el m�todo calculadora
					//definido en la parte inferior//
					resultado=calculadora(memoria1,memoria2,signo);
					pantalla.setText(resultado);
				}
			}
		});
		button_18.setForeground(Color.BLACK);
		button_18.setBackground(new Color(153, 255, 204));
		button_18.setFont(new Font("Stencil", Font.PLAIN, 14));
		button_18.setBounds(266, 197, 54, 42);
		contentPane.add(button_18);
	}
	
	//Creamos el M�todo para que reconozca los puntos//
	public static boolean existenumero (String cadena){
		boolean resultado;
		resultado=false;
		//Revisa todos los car�cteres//
		for(int i=0; i<cadena.length(); i++){
			if(cadena.substring(1, i+1).equals(".")){
				resultado = true;
				break;
			}
		}
		//Para Devolver el Resultado//
		return resultado;
	}
	
	//Creamos el M�todo Calculadora//
	//A�adimos los par�metros que va a recibir este m�todo//
	public static String calculadora(String memoria1 , String memoria2, String signo){
		//Variable Double para el Resultado//
		Double resultado=0.0;
		//Variable String para que de una Respuesta//
		String respuesta;
		
		//Condicional para comparar en que signo se ha hecho click//
		//Para el Signo NEGATIVO//
		if(signo.equals("-")){
			resultado=Double.parseDouble(memoria1)-Double.parseDouble(memoria2);	
		}
		
		//Para el Signo POSITIVO//
		if(signo.equals("+")){
			resultado=Double.parseDouble(memoria1)+Double.parseDouble(memoria2);
		}
		
		//Para el Signo MULTIPLICAR//
		if(signo.equals("*")){
			resultado=Double.parseDouble(memoria1)*Double.parseDouble(memoria2);
		}
		
		//Para el Signo DIVIDIR//
		if(signo.equals("/")){
			resultado=Double.parseDouble(memoria1)/Double.parseDouble(memoria2);
		}
		
		//Convertir el Resultado en String para guardarlo en respuesta//
		respuesta=resultado.toString();
		return respuesta;
	}
}
