import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/**
* <h1>VentanaUsuariosCombo</h1>
* La clase VentanaUsuariosCombo nos muestra un sencillo ejemplo de uso del JComboBox
* <p>
* Aprendemos como:
*  - Usar el JComBoBox
*  - Introducir eventos
*  - Manejar objetos
*
* @author  Paco Gómez
* @version 1.0
* @since   2016-04-19 
* @see <a href="">Java. JComboBox</a>
*/
public class VentanaUsuariosCombo extends JFrame {

	private JPanel contentPane;
	private String[] ciudades={"Valencia","Barcelona","Bilbao","Madrid"};
	JComboBox comboNombresPersonas;
	private JTextField nombreElegido;
	private JComboBox comboComunidades;

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
		comboNombresPersonas = new JComboBox();
		contentPane.add(comboNombresPersonas);
		comboNombresPersonas.addItem("Paco");
		comboNombresPersonas.addItem("Julia");
		String nombre1="Ana";
		comboNombresPersonas.addItem(nombre1);
		String nombre2="Pedro Gomez";
		comboNombresPersonas.addItem(nombre2);
		comboNombresPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombreElegido.setText((String)comboNombresPersonas.getSelectedItem());
			}
		});		
		JComboBox comboNombres = new JComboBox();
		contentPane.add(comboNombres);
		
		nombreElegido = new JTextField();
		contentPane.add(nombreElegido);
		nombreElegido.setColumns(10);
		for(int i=0;i<ciudades.length;i++){
			comboNombres.addItem(ciudades[i]);
		}	
		
		//Almacenaremos objetos
		comboComunidades = new JComboBox();
		Comunidad cv=new Comunidad();
		Comunidad cat=new Comunidad();
		//Rellenamos las provincias
		cv.setNombre("Comunidad Valenciana");
		cat.setNombre("Cataluña");
		cv.setNumProvincias(3);
		cat.setNumProvincias(2);
		cv.getProvincias()[0]="Castellon";
		cv.getProvincias()[1]="Valencia";
		cv.getProvincias()[2]="Alicante";
		cat.getProvincias()[0]="Girona";
		cat.getProvincias()[1]="Barcelona";
		comboComunidades.addItem(cv);
		comboComunidades.addItem(cat);
		
		comboComunidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comunidad c=(Comunidad)comboComunidades.getSelectedItem();
				for(int i=0;i<c.getNumProvincias();i++) System.out.println(c.getProvincias()[i]);
			}
		});		
		
		contentPane.add(comboComunidades);

	}

}
