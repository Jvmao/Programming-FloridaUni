package Modelo;

import java.sql.SQLException;

import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class UsuariosDB {
	//Campos Tabla Usuario//
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String edad;
	
	private Usuario u;
	
	//Conexión a la BBDD//
	private Connection conexion;
	//Objeto para Ejecutar la orden//
	private Statement orden = null;
	
	//Constructor que Recoge la Conexión establecida para la BBDD//
	public UsuariosDB(Connection c){
		this.conexion=c;
	}
	
	//Método que Permite insertar un usuario en la BBDD//
	//La BBDD se llama usuarios y la tabla correspondiente usuario//
	public void insertarUsuario(String nombre,String apellido1,String apellido2,int edad){
		try{
		orden = (Statement) conexion.createStatement();
		String sql = "INSERT INTO jugador (nombre, apellido1, apellido2,edad)" +
		"VALUES ('"+nombre+"','"+apellido1+"','"+apellido2+"','"+edad+"')";
		
		orden.execute(sql);
		System.out.println("Usuario Registrado con Éxito");
		
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(orden!=null)
					conexion.close();
			}catch (SQLException se){
			}
			try{
				if(conexion!=null)
					conexion.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
	
	//Creamos el Método para Buscar Usuario//
	public  void buscarUsuario(String nombreBuscar,JComboBox jc){
		ResultSet rs;
		Usuario u=new Usuario(); //Se generará un usuario por cada coincidencia
		try{
			orden = (Statement) conexion.createStatement();
			  /*Si quisiésemos que devolviese todos los usuarios de la BBDD en el COMBOX haríamos
			   * String sql = "SELECT id,nombre, apellido1, apellido2, edad FROM usuario";
			   * y eliminaríamos el input de nombreBuscar en el método
			   */
			//órden SQL//
		      String sql = "SELECT id,nombre, apellido1, apellido2, edad FROM jugador WHERE nombre='"+nombreBuscar+"'";
		      rs = (ResultSet) orden.executeQuery(sql);
			//Cogemos los usuarios
			      while(rs.next()){
			    	  u.setId(rs.getInt("id"));
				      u.setNombre(rs.getString("nombre"));
				      u.setApellido1(rs.getString("apellido1"));
				      u.setApellido2(rs.getString("apellido2"));
				      u.setEdad(rs.getInt("edad"));
				      //Añadimos el usuario encontrado al JComboBox
				      //El usuario no "será destruido" al salir del método porque se almacena en un objeto
				      //superior que lo guarda, que es el jc (un objeto ComboBox)
				      jc.addItem(u);
				      System.out.println(u.getId()+""+u.getNombre()+""+u.getApellido1()+""+u.getApellido2()+""+u.getEdad()+"\n");
				      //Comprobación por monitor
				      System.out.println("Coincidencias: "+u.toString()+"\n");
			      }
			    //Debemos cerrar la conexion
			      rs.close();
				}catch(SQLException se){
					      //Se produce un error con la consulta
					      se.printStackTrace();
				}catch(Exception e){
					      //Se produce cualquier otro error
					      e.printStackTrace();
				}finally{
				      //Cerramos los recursos
				      try{
				         if(orden!=null)
				        	 orden.close();
				      }catch(SQLException se){
				      }
				      try{
				         if(conexion!=null)
				        	 conexion.close();
				      	 }catch(SQLException se){
				         se.printStackTrace();
				      	 }//Finalizar Intento
				}
		} 
	
	//Método que permite buscar y actualizar la BBDD con un preparedStatement//
	public void actualizarUsuario(Connection c){
		try{
		  orden = (Statement) c.createStatement();
		// create the java mysql update preparedstatement
	      String sql = "UPDATE usuarios " +
                       "SET nombre = ?"+
                       ",apellido1 = ?"+
                       ",apellido2 = ?"+
                       ",edad = ? "+
	    		       "WHERE id = "+u.getId();
	      PreparedStatement preparedStmt = (PreparedStatement) c.prepareStatement(sql);
	      preparedStmt.setString(1, u.getNombre());
	      preparedStmt.setString(2, u.getApellido1());
	      preparedStmt.setString(3, u.getApellido2());
	      preparedStmt.setInt(4, u.getEdad());
	 
	      // se ejecuta la consulta
	      preparedStmt.executeUpdate();
		}catch(SQLException se){
			      //Se produce un error con la consulta
			      se.printStackTrace();
		}catch(Exception e){
			      //Se produce cualquier otro error
			      e.printStackTrace();
		}		
	}
	
	//Método que permite buscar actualizar un usuario en la base de datos con un preparedStatement
		public void actualizarUsuarioPuntos(Connection c){
			try{
			  orden = (Statement) c.createStatement();
			// create the java mysql update preparedstatement
		      String sql = "UPDATE usuarios " +
	                       "SET puntos = ? "+
		    		       "WHERE id = "+u.getId();
		      PreparedStatement preparedStmt = (PreparedStatement) c.prepareStatement(sql);
		      //preparedStmt.setInt(1, u.getPuntos());

		      // se ejecuta la consulta
		      preparedStmt.executeUpdate();
			}catch(SQLException se){
				      //Se produce un error con la consulta
				      se.printStackTrace();
			}catch(Exception e){
				      //Se produce cualquier otro error
				      e.printStackTrace();
			}		
	}
	
}
