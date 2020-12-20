
public class Nodo {

	 String dato;
	 Nodo enlace;
	
	
	
	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public Nodo getEnlace() {
		return enlace;
	}

	public void setEnlace(Nodo enlace) {
		this.enlace = enlace;
	}

	
	//Elementp nuevo al final de la lista 
	public Nodo(String dato){
		this.dato = dato;
		enlace = null;
	}
	
	//Elementp nuevo al inicio de la lista 
	public Nodo(String dato, Nodo enlace){
		this.dato = dato;
		this.enlace = enlace;
	}
}
