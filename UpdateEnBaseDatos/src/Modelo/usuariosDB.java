package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import Logica.Usuario;

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
	//Método que permite buscar un usuario en la base de datos
	public Usuario buscarUsuario(String nombreBuscar){
		ResultSet rs;
		Usuario u=new Usuario();
		try{
		  orden = conexion.createStatement();
	      String sql = "SELECT id,nombre, apellido1, apellido2, edad FROM usuarios WHERE nombre='"+nombreBuscar+"'";
	      rs = orden.executeQuery(sql);
	      //Cogemos los usuarios
	      while(rs.next()){
	    	  //Es necesario el id para después realizar la actualización
	    	  u.setId(rs.getInt("id"));
		      u.setNombre(rs.getString("nombre"));
		      u.setApellido1(rs.getString("apellido1"));
		      u.setApellido2(rs.getString("apellido2"));
		      u.setEdad(rs.getInt("edad"));
	      }
	      //Debemos cerrar la conexion
	      rs.close();
	      return u;
		}catch(SQLException se){
			      //Se produce un error con la consulta
			      se.printStackTrace();
			      return u;
		}catch(Exception e){
			      //Se produce cualquier otro error
			      e.printStackTrace();
			      return u;
		}finally{
		      //Cerramos los recursos
			/*
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
		      	 */
		}
	}
	
	//Método que permite buscar un usuario en la base de datos devolviendolos en un JComboBox
		public void buscarUsuario(JComboBox jc){
			ResultSet rs;
			try{
			  orden = conexion.createStatement();
		      String sql = "SELECT id,nombre, apellido1, apellido2, edad FROM usuarios";
		      rs = orden.executeQuery(sql);
		      //Cogemos los usuarios
		      while(rs.next()){
		    	  Usuario u=new Usuario();
		    	  u.setId(rs.getInt("id"));
			      u.setNombre(rs.getString("nombre"));
			      u.setApellido1(rs.getString("apellido1"));
			      u.setApellido2(rs.getString("apellido2"));
			      u.setEdad(rs.getInt("edad"));
			      jc.addItem(u);
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
			        	 conexion.close();
			      }catch(SQLException se){
			      }
			      try{
			         if(conexion!=null)
			        	 conexion.close();
			      	 }catch(SQLException se){
			         se.printStackTrace();
			      	 }//end finally try
			}
		}
		
		//Método que permite buscar actualizar un usuario en la base de datos
		public void actualizarUsuario(Usuario u){
			try{
			  orden = conexion.createStatement();
		      String sql = "UPDATE usuarios " +
	                       "SET nombre = '"+u.getNombre()+"'"+
	                       ",apellido1 = '"+u.getApellido1()+"'"+
	                       ",apellido2 = '"+u.getApellido2()+"'"+
	                       ",edad = "+u.getEdad()+" "+
		    		       "WHERE id = "+u.getId();
		      System.out.println(sql);
		      orden.executeUpdate(sql);
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
			}			
		}
		
		//Método que permite buscar actualizar un usuario en la base de datos con un preparedStatement
				public void actualizarUsuarioPreparada(Usuario u){
					try{
					  orden = conexion.createStatement();
					// create the java mysql update preparedstatement
				      String sql = "UPDATE usuarios " +
			                       "SET nombre = ?"+
			                       ",apellido1 = ?"+
			                       ",apellido2 = ?"+
			                       ",edad = ? "+
				    		       "WHERE id = "+u.getId();
				      PreparedStatement preparedStmt = conexion.prepareStatement(sql);
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
					}			
				}

}
