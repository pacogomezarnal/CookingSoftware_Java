package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDB {

	public UsuarioDB() {
		// TODO Auto-generated constructor stub
	}
	
	//Método que permite insertar un usuario en la base de datos
	public boolean insertarUsuario(Usuario u){
			boolean correcto=true;
			try{
				//Objetos necesarios para la conexion
				ResultSet rs;
				Connection c=confDB.getConexion();
				Statement orden;
				//Comenzamos con la conexion
				orden = c.createStatement();
			    String sql = "INSERT INTO usuarios (nombre,apellido1,apellido2,edad) " +
			                   "VALUES ('"+u.getNombre()+"', '"+u.getApellido1()+"', '"+u.getApellido2()+
			                   "', "+u.getEdad()+")";
			    orden.executeUpdate(sql);
			    }catch(SQLException se){
				      //Se produce un error con la consulta
				      se.printStackTrace();
				      correcto=false;
			   }catch(Exception e){
				      //Se produce cualquier otro error
				      e.printStackTrace();
				      correcto=false;
			   }
		    return correcto;
	}

}
