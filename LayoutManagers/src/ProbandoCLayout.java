import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
/**
* <h1>ProbandoCLayout</h1>
* La clase ProbandoCLayout nos muestra un sencillo ejemplo de uso del CardLayout BorderLayout
* <p>
* Como se puede observar es una disposición muy similar a lo que podría representar cualquier ventana de una aplicación cualquiera, 
* donde en el NORTE tendríamos nuestro menú, en el SUR nuestros elementos de avisos o información, 
* y en la parte central los elementos principales y lógicos de la aplicación.
* 
*
* @author  Paco Gómez
* @version 1.0
* @since   2016-03-31 
* @see <a href="http://cookingsoftware.blogspot.com.es/2016/03/java-layout-managers.html">Java. Layout Managers</a>
*/
public class ProbandoCLayout extends JFrame {

	private JPanel contentPane;
	
	//IDENTIFICADORES PARA EL CARDLAYOUT
	final static String VENTANA1 = "Ventana 1";
	final static String VENTANA2 = "Ventana 2";
	
	Ventana1 v1=new Ventana1();
	Ventana2 v2=new Ventana2();

	/**
	 * Lanzamos la aplicación
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProbandoCLayout frame = new ProbandoCLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Configuraciones del JFrame
	 */
	public ProbandoCLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Añadir las ventanas al contenedor
		contentPane.add(v1,VENTANA1);
		contentPane.add(v2,VENTANA2);
		
		
		//Accedemos al boton de Ventana 1
		v1.btnAVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, VENTANA2);
			}
		});
		//Accedemos al boton de Ventana 2
		v2.btnAVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, VENTANA1);
			}
		});
	}

}
