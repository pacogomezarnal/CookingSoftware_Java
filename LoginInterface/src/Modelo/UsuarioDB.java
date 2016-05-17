package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* <h1>UsuarioDB</h1>
* Clase que nos permite interactuar con la BBDD para la inserción y comprobación de un usuario
* 
*
* @author  Paco Gómez
* @version 1.0
* @since   2016-05-17
* @see <a href="">Java. LoginInterface</a>
*/
public class UsuarioDB {

	public UsuarioDB() {
		// TODO Auto-generated constructor stub
	}
	
	//Método que permite insertar un usuario en la base de datos
	public boolean insertarUsuario(Usuario u,String pass){
			boolean correcto=true;
			try{
				//Objetos necesarios para la conexion
				ResultSet rs;
				Connection c=confDB.getConexion();
				Statement orden;
				//Comenzamos con la conexion
				orden = c.createStatement();
			    String sql = "INSERT INTO usuarios (nombre,apellido1,apellido2,edad,usuario,passwd) " +
			                   "VALUES ('"+u.getNombre()+"', '"+u.getApellido1()+"', '"+u.getApellido2()+
			                   "', "+u.getEdad()+", '"+u.getUsuario()+"', '"+pass+"')";
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
	//Método que permite insertar un usuario en la base de datos
	public String selectUsuario(String u){
			boolean correcto=true;
			String pass=null;
			try{
				//Objetos necesarios para la conexion
				ResultSet rs;
				Connection c=confDB.getConexion();
				Statement orden;
				//Comenzamos con la conexion
				orden = c.createStatement();
			    String sql = "SELECT passwd FROM usuarios WHERE usuario='"+u+"'";
			    rs = orden.executeQuery(sql);
			    //Cogemos el usuario
			    
			    if(rs.next()) pass=rs.getString("passwd");
			    }catch(SQLException se){
				      //Se produce un error con la consulta
				      se.printStackTrace();
				      correcto=false;
			   }catch(Exception e){
				      //Se produce cualquier otro error
				      e.printStackTrace();
				      correcto=false;
			   }
		    return pass;
	}

}
