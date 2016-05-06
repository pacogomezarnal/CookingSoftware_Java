package Controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
* <h1>Controlador</h1>
* Esta clase nos demuestra el uso y 
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
public class Controlador {
	
	private static Controlador INSTANCE = null;
	private int hora,minutos,segundos,dia;

	private Controlador() {
		Calendar calendario = new GregorianCalendar();
		dia =calendario.get(Calendar.DAY_OF_MONTH);
		hora =calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
	}
	
	//Este es el método que 
    public static Controlador getControlador() {
        if (INSTANCE == null){
        	INSTANCE = new Controlador();
        }
        return INSTANCE;
    }
    
    //Imprimimos la fecha de creación
    public String toString(){
    	return "DIA: "+dia+" HORA: "+hora+" MINUTOS: "+minutos+" SEGUNDOS: "+segundos;
    }

}
