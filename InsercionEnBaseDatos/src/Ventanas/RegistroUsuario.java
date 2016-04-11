package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.confDB;
import Modelo.usuariosDB;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* <h1>RegistroUsuario</h1>
* Ventana que nos permitirá registrar un usuario en nuestro sistema
* 
*
* @author  Paco Gómez
* @version 1.0
* @since   2016-04-11 
* @see <a href="">Java. Layout Managers</a>
*/
public class RegistroUsuario extends JFrame {

	//Contenedor Principal BorderLayout
	private JPanel contentPane;
	//Contenedor de los campos de registro
	private JPanel campos = new JPanel();
	
	//Campos
	private JTextField nombreTxt;
	private JTextField apellido1Txt;
	private JTextField apellido2Txt;
	private JTextField edadTxt;

	//Manejador de la base de datos
	private confDB db;
	private usuariosDB udb;
	/**
	 * Create the frame.
	 */
	public RegistroUsuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 172);
		
		//Campos de registro
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(campos);
		campos.setLayout(new GridLayout(0, 2, -200, 5));
		
		JLabel lblEdad = new JLabel("Nombre");
		campos.add(lblEdad);
		
		nombreTxt = new JTextField();
		campos.add(nombreTxt);
		nombreTxt.setColumns(10);
		
		JLabel labelApellido1 = new JLabel("Apellido1");
		campos.add(labelApellido1);
		
		apellido1Txt = new JTextField();
		campos.add(apellido1Txt);
		apellido1Txt.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido2");
		campos.add(lblApellido);
		
		apellido2Txt = new JTextField();
		campos.add(apellido2Txt);
		apellido2Txt.setColumns(10);
		
		JLabel lblEdad_1 = new JLabel("Edad");
		campos.add(lblEdad_1);
		
		edadTxt = new JTextField();
		campos.add(edadTxt);
		edadTxt.setColumns(10);
		
		//Boton de registro
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		//Registramos nuevo usuario y cerramos la conexion
		JButton btnNewButton = new JButton("Registro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//udb.insertarUsuario(nombreTxt.getText(), apellido1Txt.getText(), apellido2Txt.getText(), Integer.valueOf(edadTxt.getText()));
			}
		});
		panel.add(btnNewButton);
		
		contentPane.add(campos, BorderLayout.NORTH);
		
		//Creamos nuestro objeto para el manejo de la base de datos
		db=new confDB();
		udb=new usuariosDB(db.getConexion());
	}

}
