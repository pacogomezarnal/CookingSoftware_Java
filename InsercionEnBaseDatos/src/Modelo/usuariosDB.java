package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
* <h1>usuariosDB</h1>
* Clase que nos permite interactuar con la tabla usuarios
* 
*
* @author  Paco Gómez
* @version 1.0
* @since   2016-04-11 
* @see <a href="">Java. Layout Managers</a>
*/
public class usuariosDB {
	//Campos de la tabla
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	//Conexion a la base de datos
	private Connection conexion;
	private Statement orden = null;
	
	public usuariosDB(Connection c) {
		this.conexion=c;
	}
	
	//Método que permite insertar un usuario en la base de datos
	public void insertarUsuario(String nombre,String apellido1,String apellido2,int edad){
		try{
			orden = conexion.createStatement();
		    String sql = "INSERT INTO usuarios (nombre,apellido1,apellido2,edad) " +
		                   "VALUES ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', "+edad+")";
		    orden.executeUpdate(sql);
		    System.out.println("Usuario registrado con exito");
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
			        	 conexion.close();
			      }catch(SQLException se){
			      }
			      try{
			         if(conexion!=null)
			        	 conexion.close();
			      	 }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			}//end try
	}
}
