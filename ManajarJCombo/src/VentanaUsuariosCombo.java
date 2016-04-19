import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class VentanaUsuariosCombo extends JFrame {

	private JPanel contentPane;
	private String[] ciudades={"Valencia","Barcelona","Bilbao","Madrid"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuariosCombo frame = new VentanaUsuariosCombo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaUsuariosCombo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 123);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//CAmbiamos el manager a FlowLayout
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		//Añadimos los elementos gráficos
		JLabel lblUsuarios = new JLabel("Usuarios");
		contentPane.add(lblUsuarios);
		
		//Nuestra lista de usuarios
		JComboBox comboNombresPersonas = new JComboBox();
		contentPane.add(comboNombresPersonas);
		comboNombresPersonas.addItem("Paco");
		comboNombresPersonas.addItem("Julia");
		String nombre1="Ana";
		comboNombresPersonas.addItem(nombre1);
		String nombre2="Pedro Gomez";
		comboNombresPersonas.addItem(nombre2);
		
		JComboBox comboNombres = new JComboBox();
		contentPane.add(comboNombres);
		for(int i=0;i<ciudades.length;i++){
			comboNombres.addItem(ciudades[i]);
		}
	}

}
