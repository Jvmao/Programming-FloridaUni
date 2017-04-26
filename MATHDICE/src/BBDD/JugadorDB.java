package BBDD;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Jugador.Jugador;

public class JugadorDB {
		//Nuevo Jugador//
		private Jugador p1;
		
		//Variables Jugadores//
		private String nombre;
		private String apellido1;
		private String apellido2;
		private int edad;
		private int codigo;
		private String genero;
		private int puntos;
		
		//Conexión a la BBDD//
		private Connection conexion;
		//Objeto para Ejecutar la orden//
		private Statement orden = null;
		
		//Para Recibir la Conexión//
		public JugadorDB(Connection c){
			this.conexion=c; 
		}
		
		//Método que Permite insertar un nuevo jugador en la BBDD//
		//La BBDD se llama mathdice y la tabla correspondiente jugadores//
		public void insertarUsuario(String nombre,String apellido1,String apellido2,int edad,int codigo,String genero,int puntos){
			try{
			orden = (Statement) conexion.createStatement();
			//Orden SQL para pasarla a la BBDD//
			String sql = "INSERT INTO jugadores (nombre,apellido1,apellido2,edad,codigo,genero,puntos)" +
			"VALUES ('"+nombre+"','"+apellido1+"','"+apellido2+"','"+edad+"','"+codigo+"','"+genero+"','"+puntos+"')";
			
			orden.executeUpdate(sql);
			//System.out.println("Usuario Registrado con Éxito");
			}catch (SQLException se){
				se.printStackTrace();
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(orden != null)
						conexion.close();
				}catch (SQLException se){
				}
				try{
					if(conexion != null)
						conexion.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
			
			
		}
}
