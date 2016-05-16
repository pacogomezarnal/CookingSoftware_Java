package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.LibMD5;
import Modelo.Usuario;
import Modelo.UsuarioDB;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textEdad;
	private JTextField textUsuario;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	//Ventana de login
	Login lPadre;
	//VEntana de Registro
	Registro r;

	public Registro(Login l) {
		lPadre=l;
		r=this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 1;
		gbc_textNombre.gridy = 0;
		contentPane.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
		gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerApellido.gridx = 0;
		gbc_lblPrimerApellido.gridy = 1;
		contentPane.add(lblPrimerApellido, gbc_lblPrimerApellido);
		
		textApellido1 = new JTextField();
		GridBagConstraints gbc_textApellido1 = new GridBagConstraints();
		gbc_textApellido1.insets = new Insets(0, 0, 5, 0);
		gbc_textApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellido1.gridx = 1;
		gbc_textApellido1.gridy = 1;
		contentPane.add(textApellido1, gbc_textApellido1);
		textApellido1.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.gridx = 0;
		gbc_lblSegundoApellido.gridy = 2;
		contentPane.add(lblSegundoApellido, gbc_lblSegundoApellido);
		
		textApellido2 = new JTextField();
		GridBagConstraints gbc_textApellido2 = new GridBagConstraints();
		gbc_textApellido2.insets = new Insets(0, 0, 5, 0);
		gbc_textApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellido2.gridx = 1;
		gbc_textApellido2.gridy = 2;
		contentPane.add(textApellido2, gbc_textApellido2);
		textApellido2.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.EAST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 3;
		contentPane.add(lblEdad, gbc_lblEdad);
		
		textEdad = new JTextField();
		GridBagConstraints gbc_textEdad = new GridBagConstraints();
		gbc_textEdad.insets = new Insets(0, 0, 5, 0);
		gbc_textEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEdad.gridx = 1;
		gbc_textEdad.gridy = 3;
		contentPane.add(textEdad, gbc_textEdad);
		textEdad.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 5;
		contentPane.add(lblUsuario, gbc_lblUsuario);
		
		textUsuario = new JTextField();
		GridBagConstraints gbc_textUsuario = new GridBagConstraints();
		gbc_textUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_textUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsuario.gridx = 1;
		gbc_textUsuario.gridy = 5;
		contentPane.add(textUsuario, gbc_textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 6;
		contentPane.add(lblContrasea, gbc_lblContrasea);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 6;
		contentPane.add(passwordField, gbc_passwordField);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir Contrase\u00F1a");
		GridBagConstraints gbc_lblRepetirContrasea = new GridBagConstraints();
		gbc_lblRepetirContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblRepetirContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepetirContrasea.gridx = 0;
		gbc_lblRepetirContrasea.gridy = 7;
		contentPane.add(lblRepetirContrasea, gbc_lblRepetirContrasea);
		
		passwordField_1 = new JPasswordField();
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.gridx = 1;
		gbc_passwordField_1.gridy = 7;
		contentPane.add(passwordField_1, gbc_passwordField_1);
		
		JPanel panelBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.gridheight = 2;
		gbc_panelBotones.insets = new Insets(0, 0, 5, 0);
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 1;
		gbc_panelBotones.gridy = 8;
		contentPane.add(panelBotones, gbc_panelBotones);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Recogemos los campos del formulario
				String nombre=textNombre.getText();
				String apellido1=textApellido1.getText();
				String apellido2=textApellido2.getText();
				String edad=textEdad.getText();
				String usuario=textUsuario.getText();
				char[] pass=passwordField.getPassword();
				char[] pass1=passwordField_1.getPassword();
				
				//Comprobacion del rellenado de todos los campos
				if((nombre.length()<=0)||(apellido1.length()<=0)||(apellido2.length()<=0)
						||(edad.length()<=0)||(usuario.length()<=0)||(pass.length<=0)||(pass1.length<=0)){
		            JOptionPane.showMessageDialog(contentPane,
			                "Falta por rellenar algún campo del formulario",
			                "ERROR",
			                JOptionPane.ERROR_MESSAGE);
				}else{
					if(!Arrays.equals (pass, pass1)){
			            JOptionPane.showMessageDialog(contentPane,
				                "Las contraseñas no coinciden.",
				                "ERROR",
				                JOptionPane.ERROR_MESSAGE);						
					}else{
						//Insertamos el nuevo usuario
						Usuario u=new Usuario(nombre,apellido1,apellido2,Integer.valueOf(edad),usuario);
						UsuarioDB uDB=new UsuarioDB();
						//Generaremos el hash MD5
						String contrasenya= LibMD5.getMD5(passwordField.getPassword());
						uDB.insertarUsuario(u, contrasenya);
						
					}
				}
			}
		});
		panelBotones.add(btnRegistro);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lPadre.setVisible(true);
				r.setVisible(false);
			}
		});
		panelBotones.add(btnCancelar);
	}

}
