package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import juego.Jugador;

public class VentanaInicio extends JFrame {

	public JPanel contentPane;

	private JTextField caja1;
	private JTextField caja2;
	private JTextField caja3;
	private JTextField caja4;
	
	private VentanaInicio ref;
	
	private JTextField caja5;

	//Crea un objeto de tipo VentanaInicio
	public VentanaInicio() {


		// Propiedades de ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// texto1
		JLabel texto1 = new JLabel("DATOS DEL JUGADOR");
		texto1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		texto1.setBounds(10, 11, 242, 25);
		contentPane.add(texto1);

		// texto2
		JLabel texto2 = new JLabel("Nombre");
		texto2.setBounds(10, 69, 46, 14);
		contentPane.add(texto2);

		// texto3
		JLabel texto3 = new JLabel("Primer Apellido");
		texto3.setBounds(10, 94, 131, 14);
		contentPane.add(texto3);

		// texto4
		JLabel texto4 = new JLabel("Edad");
		texto4.setBounds(10, 169, 46, 14);
		contentPane.add(texto4);
		
		//texto5
		JLabel texto5 = new JLabel("Segundo Apellido");
		texto5.setBounds(10, 125, 131, 14);
		contentPane.add(texto5);

		// caja de texto 1
		caja1 = new JTextField();
		caja1.setBounds(151, 66, 242, 20);
		contentPane.add(caja1);
		caja1.setColumns(10);

		// caja de texto 2
		caja2 = new JTextField();
		caja2.setColumns(10);
		caja2.setBounds(151, 91, 242, 20);
		contentPane.add(caja2);

		// caja de texto 3
		caja3 = new JTextField();
		caja3.setColumns(10);
		caja3.setBounds(151, 166, 242, 20);
		contentPane.add(caja3);

		// caja de texto 4
		caja4 = new JTextField();
		caja4.setBounds(10, 312, 414, 62);
		contentPane.add(caja4);
		caja4.setColumns(10);
		
		// caja de texto 5
		caja5 = new JTextField();
		caja5.setColumns(10);
		caja5.setBounds(151, 122, 242, 20);
		contentPane.add(caja5);

		//Asignamos la referencia de esta ventana
		ref=this;
		
		// Boton
		JButton boton1 = new JButton("A JUGAR");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try{				
					if (caja1.getText().compareTo("")==0|| caja2.getText().compareTo("")==0 || caja5.getText().compareTo("")==0 || caja3.getText().compareTo("")==0) {
						caja4.setText("Rellene todos los campos");
					} else {
						Jugador j = new Jugador(caja1.getText(), caja2.getText(), caja5.getText(), Integer.valueOf(caja3.getText()));
						
						caja4.setText("Player " + j.getNombre() + " " + j.getPrimerApellido() + " de edad " + j.getEdad() + " creado");
						
						//Aqui creamos un objeto de tipo login(la siguiente ventana)(una ventana de login) pero no se va a ejecutar todavia
						//Login l =new Login(j);
						//Con esta linea hacemos que la ventana se muestre.
						//l.setVisible(true);
						
						
						Juego ju = new Juego();
						System.out.println("HE LLEGADO");
						ju.inicializacion(j);
						
						
						
						//Cierra la ventana
						ref.dispose();
						//Abro la ventana de Juego
						ju.setVisible(true);
						
					}				
				} catch(Exception e) {
					caja4.setText("Has introducido un valor de edad invalido");
					System.out.println(e);
					
				}
			}
		});
		boton1.setBounds(10, 278, 383, 23);
		contentPane.add(boton1);
		
		
		
		
	}
}
