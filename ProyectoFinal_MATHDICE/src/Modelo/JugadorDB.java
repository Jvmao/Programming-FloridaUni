package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Jugador.Jugador;

public class JugadorDB {
			//Nuevo Jugador//
			private Jugador p1;
			private JugadorDB jdb;
			
			//Variables Jugadores//
			private String nombre;
			private String apellido1;
			private String apellido2;
			private int edad;
			private String email;
			private String genero;
			private String codigo;
			private int puntos;
			private int id;
			
			//Conexión a la BBDD//
			private  static Connection conexion = null;
			//Objeto para Ejecutar la orden//
			private  Statement orden = null;
			
			//Para Recibir la Conexión//
			public  JugadorDB(Connection c){
				this.conexion=c; 
			}
			
			
			//Método que Permite insertar un nuevo jugador en la BBDD//
			//La BBDD se llama BBDDMathDice y la tabla correspondiente jugadoresMathDice//
			public void insertarUsuario(String nombre,String apellido1,String apellido2,int edad,
					String email,String genero,String codigo,int puntos){
				int id=0; //inicializamos el id del jugador//
				try{
				orden = (Statement) conexion.createStatement();
				//Creamos la Tabla SQL para introducir los Datos del Jugador en la BBDD//
				String sql = "INSERT INTO jugadoresMathDice (Nombre,PrimerApellido,SegundoApellido,"
						+ "Edad,Email,Genero,Codigo,Puntos)" +
				"VALUES ('"+nombre+"','"+apellido1+"','"+apellido2+"','"+edad+"','"+email+"','"+genero+
				"','"+codigo+"','"+puntos+"')";
				
				orden.executeUpdate(sql);//Se ejecuta la consulta//
				System.out.println("Usuario Registrado en BBDD");
				
			    //conexion.close();//Cerramos la conexión//
				System.out.println("Conexión Cerrada");
				}catch (SQLException se){
					se.printStackTrace();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
			
			
			//Método para agregar a los Jugadores en el ComboBox//
			public void usuariosBox(String buscarNombre,JComboBox jc){
				//Variable donde almacenaremos el resultado de la consulta SQL
				ResultSet rs;
				try {
					orden = (Statement) conexion.createStatement();
					String comandoSQL 
					= "SELECT id, nombre, primerapellido, segundoapellido, edad,email,"
							+ "genero,codigo,puntos FROM jugadoresmathdice WHERE nombre='"+buscarNombre+"'";
					rs=orden.executeQuery(comandoSQL);
					
					//Recorremos los Resultados//
					while(rs.next()){
						//Añadimos cada fila obtenida en un objeto Jugador//
						Jugador p1 = new Jugador();
						p1.setId(rs.getInt("id"));
						p1.setNombre(rs.getString("nombre"));
						p1.setApellido1(rs.getString("primerapellido"));
						p1.setApellido2(rs.getString("segundoapellido"));
						p1.setEdad(rs.getInt("edad"));
						p1.setGenero(rs.getString("genero"));
						p1.setEmail(rs.getString("email"));
						p1.setCode(rs.getString("codigo"));
						p1.setPuntos(rs.getInt("puntos"));
		
						jc.addItem(p1);
					}
					rs.close();//Cerramos la Conexión//
					
				} catch (SQLException e) {	
					e.printStackTrace();
				} catch (Exception evt) {	
					evt.printStackTrace();
				}
		}
			
			//Método que permite actualizar la BBDD con un preparedStatement//
			public void actualizarUsuario(Connection c,Jugador p1){
				try{
				  orden = (Statement) conexion.createStatement();
				// Insertamos los Campos a Actualizar//
			      String sql = "update jugadoresmathdice "+
		                       "set Nombre = ?"+
		                       ",PrimerApellido = ?"+
		                       ",SegundoApellido = ?"+
		                       ",Edad = ?"+
		                       ",Email = ?"+
		                       ",Genero = ?"+
		                       ",Codigo = ?"+
		                       ",Puntos = ?"+
			    		       " where id = "+p1.getId();
			      PreparedStatement preparedStmt = (PreparedStatement) conexion.prepareStatement(sql);
			      preparedStmt.setString(1, p1.getNombre());
			      preparedStmt.setString(2, p1.getApellido1());
			      preparedStmt.setString(3, p1.getApellido2());
			      preparedStmt.setInt(4, p1.getEdad());
			      preparedStmt.setString(5, p1.getEmail());
			      preparedStmt.setString(6, p1.getGenero());
			      preparedStmt.setString(7, p1.getCode());
			      preparedStmt.setInt(8, p1.getPuntos());
			 
			      //Ejecución de la Consulta//
			      preparedStmt.executeUpdate();
			      System.out.println(sql);
				}catch(SQLException se){
					      //Error con la consulta//
					      se.printStackTrace();
				}catch(Exception e){
					      //Cualquier otro Error//
					      e.printStackTrace();
				}		
			}
	
			//Método que permite buscar actualizar los puntos del  Jugador en la base de datos//
			public void actualizarPuntos(Connection c,Jugador p1){
				try{
				  orden = (Statement) conexion.createStatement();
			      String usql = "update jugadoresmathdice set puntos = ? where id = "+p1.getId();
			     PreparedStatement setSQL = (PreparedStatement) conexion.prepareStatement(usql);
			     //Asignación de Valores//
			     setSQL.setInt(1, p1.getPuntos());
			     System.out.println(usql);
			     //Ejecución de la consulta
				 setSQL.executeUpdate();
				}catch(SQLException se){
					      	//Se produce un error con la consulta SQL//
							System.out.println("Error Consulta");
							se.printStackTrace();
				}catch(Exception e){
							System.out.println("Otro tipo de Error en la Consulta");
							e.printStackTrace();      
				}	
		}
}
