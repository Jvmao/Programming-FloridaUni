package BBDD;

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
		private Connection conexion = null; //maneja la conexi�n//
		
		//Constructor (le pasamos los datos)
		public ConexionDB (String HOST,String BBDD,String USER,String PASS){
			this.host=HOST;
			this.bbdd=BBDD;
			this.user=USER;
			this.pass=PASS;
			this.url="jdbc:mysql://"+this.host+"/"+this.bbdd;
		}
		
		//M�todo para Conectarse a la BBDD//
		public boolean connectDB(){
			try{
			//Cargar el Controlador MySql//
			Class.forName(CONTROLADOR_MYSQL);
			//Conectarnos a la BBDD//
			conexion = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
			if(conexion != null){
				System.out.println("Est�s Conectado a la BBDD");
			}else{
				System.out.println("No est�s Conectado a la BBDD");
			}
			
			}catch(SQLException excepcionSql)//No encuentra la BBDD//
			{
				excepcionSql.printStackTrace();
				return false;
			}catch (ClassNotFoundException noFindClass) //No encuentra Driver para la Conexi�n//
			{
				noFindClass.printStackTrace();
				return false;
			}
			return false;
		}
		
		//Devuelve una instancia de la Conexi�n//
		public Connection getConexion(){
			return this.conexion;
		}
}
