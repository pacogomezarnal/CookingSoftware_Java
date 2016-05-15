package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

/**
* <h1>Login</h1>
* Típica pantalla de login de usuario en aplicación
* 
*
* @author  Paco Gómez
* @version 1.0
* @since   2016-05-15
* @see <a href="">Java. Login Interface</a>
*/
public class Login extends JFrame {
	
	//Contenedor de los elementos
	private JPanel contentPane;
	
	//Los dos campos necesarios para la comprobación del usuario&passwd
	private JTextField textUsuario;
	private JPasswordField textPass;

	//Almacenamos una referencia a nuestra ventana
	Login l;
	
	public Login() {
		//Almacenamos nuestra ventana
		l=this;
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 229);
		
		//Esta es la zona de configuracion del Layout
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		//Controles de Usuario
		JLabel lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		contentPane.add(lblUsuario, gbc_lblUsuario);
		
		textUsuario = new JTextField();
		GridBagConstraints gbc_textUsuario = new GridBagConstraints();
		gbc_textUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_textUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsuario.gridx = 0;
		gbc_textUsuario.gridy = 1;
		contentPane.add(textUsuario, gbc_textUsuario);
		textUsuario.setColumns(10);
		
		//Controles de PAssword
		JLabel lblPass = new JLabel("Password");
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.insets = new Insets(0, 0, 5, 0);
		gbc_lblPass.gridx = 0;
		gbc_lblPass.gridy = 2;
		contentPane.add(lblPass, gbc_lblPass);
		
		textPass = new JPasswordField();
		GridBagConstraints gbc_textPass = new GridBagConstraints();
		gbc_textPass.insets = new Insets(0, 0, 5, 0);
		gbc_textPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPass.gridx = 0;
		gbc_textPass.gridy = 3;
		contentPane.add(textPass, gbc_textPass);
		
		//Panel de Botones
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		//gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		//Boton ENTRAR
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Recoger es el password&user introduccido
		        char[] input = textPass.getPassword();
		        String user = textUsuario.getText();
		        if (isUserCorrect(user,input)) {
		            JOptionPane.showMessageDialog(contentPane,
		                "Usuario correctamente logado");
		        } else {
		            JOptionPane.showMessageDialog(contentPane,
		                "Usuario o password incorrecto",
		                "ERROR",
		                JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		panel.add(btnEntrar);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Nueva ventana de registro
				Registro r=new Registro(l);
				r.setVisible(true);
				l.setVisible(false);
			}
		});
		panel.add(btnRegistro);
	}
	
	private boolean isUserCorrect(String user, char[] input) {
		//Variables de control
	    boolean isCorrect = true;
	    char[] correctPassword = { '1','2','3'};
	    String correctUser="Paco";

	    if ((input.length != correctPassword.length)||(user.length()!=correctUser.length())) {
	        isCorrect = false;
	    } else {
	    	if(Arrays.equals (input, correctPassword)&&(correctUser.equals(user))) isCorrect=true;
	    	else isCorrect=false;
	    }
	    return isCorrect;
	}

}
