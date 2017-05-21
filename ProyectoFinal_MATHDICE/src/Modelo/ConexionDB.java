package Modelo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConexionDB {
			//Datos Conexi�n//
			static final String CONTROLADOR_MYSQL = "com.mysql.jdbc.Driver";
			

			//Datos BBDD//
			private String host; //host de la BBDD//
			private String bbdd; //nombre de la BBDD//
			private String user; //nombre usuario//
			private String pass; //password de usuario//
			private String url; //proporcionar� el m�todo DriverManager//
			
			//Conexi�n//
			private static Connection conexion = null; //maneja la conexi�n//
			private static ConexionDB INSTANCE = null; //Instancia de la Conexi�n//
			
			//Constructor (le pasamos los datos)
			public boolean ConexionDB (){
				host="localhost";
				bbdd="bbddmathdice";
				user="root";
				pass="Naizuore1x";
				url="jdbc:mysql://"+this.host+"/"+this.bbdd;
				
				//Conexi�n
				try{
					//Cargar el controlador MYSQL para poder conectar con la BBDD
					Class.forName(CONTROLADOR_MYSQL);
					
					//Conectar a la BBDD
					conexion = (Connection) DriverManager.getConnection("jdbc:mysql://"+this.host+"/"
					+this.bbdd, this.user, this.pass);
					if(conexion != null){
						System.out.println("Conexion OK con "+this.user);
					}
					
				}catch( SQLException exSQL ){ 
					exSQL.printStackTrace();
				}catch( ClassNotFoundException error){ 
					error.printStackTrace();
				}
				return false;
			}
		
			//Devuelve una instancia de la Conexi�n//
			public static Connection getConexion(){
				if(conexion==null){
					INSTANCE = new ConexionDB();
			}	return conexion;
		}	
		
}
