package ventanas;

import javax.swing.JPanel;

import juego.Jugador;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Perfil extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Perfil(Jugador j) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(34, 41, 46, 14);
		add(lblNewLabel);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setBounds(34, 84, 46, 14);
		add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setBounds(34, 129, 46, 14);
		add(lblSegundoApellido);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(34, 185, 46, 14);
		add(lblEdad);
		
		textField = new JTextField();
		textField.setBounds(128, 38, 465, 20);
		textField.setText(j.getNombre());
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 81, 465, 20);
		textField_1.setText(j.getPrimerApellido());
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 126, 465, 20);
		textField_2.setText(j.getSegundoApellido());
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 182, 465, 20);
		textField_3.setText(String.valueOf(j.getEdad()));
		add(textField_3);

	}

}
