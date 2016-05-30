package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.confDB;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class InsertImagen extends JFrame {

	private JPanel contentPane;
	
	Connection c;
	Statement orden;
	FileInputStream fis = null;
	
	/**
	 * Create the frame.
	 */
	public InsertImagen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		try{
			confDB conf= new confDB();
			c =conf.getConexion();
			File file = new File("c:/Temp/f1.jpg");
		    fis = new FileInputStream(file);
		    String sql = "INSERT INTO ARTICULO (nombre,imagen,precio_compra,pvp,disponibles,cant_minima,cod_categoria)"
		    		+ " values (?, ?, ?,?, ?, ?,?)";
		    PreparedStatement statement = c.prepareStatement(sql);
		    statement.setString(1, "Paco Rebozado");    
            statement.setBlob(2, fis);
            statement.setDouble(3, 1);
            statement.setDouble(4, 1);
            statement.setInt(5, 1);
            statement.setInt(6, 1);
            statement.setInt(7, 1);
            statement.executeUpdate();
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
			        	 c.close();
			      }catch(SQLException se){
			      }
			      try{
			         if(c!=null)
			        	 c.close();
			      	 }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			}//end try
	}		
}
