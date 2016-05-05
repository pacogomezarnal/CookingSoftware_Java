package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Logica.Usuario;
import Modelo.confDB;
import Modelo.usuariosDB;
import javax.swing.JComboBox;

public class SelectUsuarioJCombo extends JFrame {

	//Contenedor Principal BorderLayout
	private JPanel contentPane;
	//Contenedor de los campos de registro
	private JPanel campos = new JPanel();
	private JTextField apellido1Txt;
	private JTextField apellido2Txt;
	private JTextField edadTxt;

	//Manejador de la base de datos
	private confDB db;
	private usuariosDB udb;
	
	//JCOmbobox de usuarios
	JComboBox comboBox;
	/**
	 * Create the frame.
	 */
	public SelectUsuarioJCombo() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		
		//Campos de registro
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(campos);
		campos.setLayout(new GridLayout(0, 2, -200, 5));
		
		JLabel lblEdad = new JLabel("Nombre");
		campos.add(lblEdad);
		
		comboBox = new JComboBox();
		campos.add(comboBox);
		
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
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario u=(Usuario)comboBox.getSelectedItem();
				apellido1Txt.setText(u.getApellido1());
				apellido2Txt.setText(u.getApellido2());
				edadTxt.setText(String.valueOf(u.getEdad()));
			}
		});
		panel.add(btnNewButton);
		
		contentPane.add(campos, BorderLayout.NORTH);
		
		//Creamos nuestro objeto para el manejo de la base de datos
		db=new confDB();
		udb=new usuariosDB(db.getConexion());
		
		//Añadiriamos todos los usuarios de la base de datos
		udb.buscarUsuario(comboBox);
	}
}
