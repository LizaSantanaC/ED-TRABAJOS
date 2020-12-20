public class NodoArbol {
	NodoArbol nodoIzquierdo;
	int dato;
	NodoArbol nodoDerecho;

	public NodoArbol(int dato) {
		this.dato = dato;
		nodoIzquierdo = nodoDerecho = null;
	}
}