package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
* <h1>Usuario</h1>
* Clase que nos permite almacenar un usuario de la BBDD en un objeto
* 
*
* @author  Paco Gómez
* @version 1.0
* @since   2016-05-17
* @see <a href="">Java. LoginInterface</a>
*/
public class Usuario {
	private String nombre;
	private String apellidos;
	private String apellido1;
	private String apellido2;
	private int edad;
	private int puntos;
	private String usuario;

	private int id;
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//Constuctores necesarios para generar el usuario
	public Usuario() {
		
	}
	public Usuario(String nombre,String apellido1,String apellido2,int edad,String usuario) {
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.apellidos=apellido1+" "+apellido2;
		this.edad=edad;
		this.puntos=0;		
		this.usuario=usuario;
	}
	
	
	public String toString(){
		return this.id+"-"+this.nombre+" "+this.apellido1;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
