package juego;

public class Jugador {
	//Atributos (o propiedades)
		private String nombre;
		private String primerapellido;
		private String segundoapellido;
		private int edad;
		private int puntos;
		

		//Constructor 
		//Punto de entrada que se ejeuta al crear un objeto de tipo Jugador
		public Jugador(String nom, String ape1, String ape2, int eda) {
			
			if (eda<=0) {
				throw new IllegalArgumentException("Has introducido una edad invalida");
				
				
			}
			
			//Dentro del constructor, SE RELLENAN los atributos POR PRIMERA VEZ.
			this.nombre=nom;
			this.primerapellido=ape1;
			this.segundoapellido=ape2;
			this.edad=eda;
			this.puntos=0;		
		
		}
		
			
		
		//Métodos getter
		
		//Obtiene el VALOR de una propiedad
		public String getNombre(){
			return nombre;
		}
		public String getPrimerApellido(){
			return primerapellido;
		}
		public String getSegundoApellido(){
			return segundoapellido;
		}
		public int getEdad(){
			return edad;
		}
		public int getPuntos(){
			return puntos;
		}
		
		//Métodos setter
		
		//Modifica el VALOR de una propiedad
		public void setNombre(String nom){
			nombre=nom;
		}
		public void setPrimerApellido(String ape1){
			primerapellido=ape1;
		}
		public void setSegundoApellido(String ape2){
			segundoapellido=ape2;
		}
		public void setEdad (int eda){
			if (eda<=0) {
				throw new IllegalArgumentException("Has introducido una edad invalida");
			}
			edad=eda;
		}
		public void setPuntos (int pun){
			puntos=pun;
		}
		
}