package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.Jugador;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Juego extends JFrame {

	
	private Jugador jugador;
	private JPanel contentPane;
	
	
	public static final String VENTANA1= "VENTANA 1";
	public static final String VENTANA2= "VENTANA 2";
	
	
	public void meterJugador(Jugador j){
		jugador=j;
	}
	
	public Jugador getPlayer(){
		return jugador;
	}
	
	
	Login l = new Login(getPlayer());
	Perfil p = new Perfil(getPlayer());
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
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
	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 461);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("Ventanas");
		menuBar.add(menu1);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1= (CardLayout) (contentPane.getLayout());
				c1.show(contentPane, VENTANA2);
			}
		});
		menu1.add(mntmPerfil);
		
		JMenuItem mntmJuego = new JMenuItem("Juego");
		mntmJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1= (CardLayout) (contentPane.getLayout());
				c1.show(contentPane, VENTANA1);
			}
		});
		menu1.add(mntmJuego);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		contentPane.add(p, VENTANA2);
		contentPane.add(l, VENTANA1);
		
		
	}

}
